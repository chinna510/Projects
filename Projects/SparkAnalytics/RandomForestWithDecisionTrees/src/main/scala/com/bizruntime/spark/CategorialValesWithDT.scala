package com.bizruntime.spark
import org.apache.spark.rdd.RDD

import org.apache.spark.SparkContext
import org.apache.spark.SparkConf
import org.apache.spark.mllib.tree.DecisionTree
import scala.collection.immutable.Map
import org.apache.log4j.Logger
import org.apache.spark.mllib.regression._
import org.apache.spark.mllib.linalg._
import org.apache.spark.mllib.tree.model.DecisionTreeModel
import org.apache.spark.mllib.evaluation.MulticlassMetrics
class CategorialValesWithDT {

  val logger: Logger = Logger.getLogger("CategorialValesWithDT")

  def getFeatures(filename: String, minPartitions: Integer): Unit = {

    val conf = new SparkConf().setAppName("CategorialValesWithDT")

    val sc = new SparkContext(conf)

    val rawData: RDD[String] = sc.textFile(filename, minPartitions)

    val data = rawData.map { line =>

      val values = line.split(",").map(_.toDouble)

      //Which of 4 “wilderness” features is 1
      val wilderness = values.slice(10, 14).indexOf(1.0).toDouble

      //Which of 40 “Soil” features is 1
      val soil = values.slice(14, 54).indexOf(1.0).toDouble

      //Add THose Features To First 10 Values
      val featureVector = Vectors.dense(values.slice(0, 10) :+ wilderness :+ soil)
      //Target Result is Last Value
      val label = values.last - 1

      LabeledPoint(label, featureVector)

    }
    val Array(trainData, crossValidData, testData) = data.randomSplit(Array(0.8, 0.1, 0.1))
    trainData.cache()
    crossValidData.cache()
    testData.cache()

    val evaluations = for (
      impurity <- Array("gini", "entropy");
      depth <- Array(10, 20, 30);
      bins <- Array(40, 300)
    ) yield {

      val model = DecisionTree.trainClassifier(trainData, 7, Map(10 -> 4, 11 -> 40), impurity, depth, bins)

      val trainAccuracy = getMetrics(model, trainData).precision
      val cvAccuracy = getMetrics(model, crossValidData).precision
      ((impurity, depth, bins), (trainAccuracy, cvAccuracy))

    }
    evaluations.sortBy(_._2).reverse.foreach(tuple => logger.info(tuple))

  }
  def getMetrics(model: DecisionTreeModel, data: RDD[LabeledPoint]): MulticlassMetrics = {

    val predictionsAndLabels = data.map(example => (model.predict(example.features), example.label))

    new MulticlassMetrics(predictionsAndLabels)

  }

}

object CategorialValesWithDT extends Serializable{

  def main(args: Array[String]): Unit = {

    new CategorialValesWithDT().getFeatures(args(0), args(1).toInt)

  }
}