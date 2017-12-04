package com.bizruntime.spark

import org.apache.spark.SparkContext
import org.apache.spark.SparkConf
import org.apache.spark.SparkConf
import org.apache.spark.rdd.RDD._
import org.apache.spark.mllib.regression._
import org.apache.spark.mllib.linalg._
import org.apache.log4j.Logger
import org.apache.spark.rdd.RDD
import org.apache.spark.mllib.tree.model.DecisionTreeModel
import org.apache.spark.mllib.tree.DecisionTree
import org.apache.spark.mllib.evaluation.MulticlassMetrics

class TuningDecisionTrees extends Serializable {

  val conf: SparkConf = new SparkConf().setAppName("FirstDecisionTree")
  val sc: SparkContext = new SparkContext(conf)

  val logger: Logger = Logger.getLogger("TuningDecisionTrees")

  def compareImpurities(filename: String, minPartitions: Integer): Unit = {

    val rawData: RDD[String] = sc.textFile(filename, minPartitions)

    val data = rawData.map { line =>
      val values = line.split(",").map(_.toDouble)
      val futureVector: Vector = Vectors.dense(values.init)
      val label: Double = values.last - 1
      LabeledPoint(label, futureVector)
    }

    val Array(trainData, crossValidData, testData) = data.randomSplit(Array(0.8, 0.1, 0.1))
    trainData.cache()
    crossValidData.cache()
    testData.cache()

    val evaluations = for (
      impurity <- Array("gini", "entropy");
      depth <- Array(1, 20);
      bins <- Array(10, 300)
    ) yield {
      val model = DecisionTree.trainClassifier(
        trainData, 7, Map[Int, Int](), impurity, depth, bins)

      val predictionsAndLabels = crossValidData.map(example =>
        (model.predict(example.features), example.label))

      val accuracy =
        new MulticlassMetrics(predictionsAndLabels).precision
      ((impurity, depth, bins), accuracy)
    }

    evaluations.sortBy(_._2).reverse.foreach(tuple => logger.info(tuple))

  }

}

object TuningDecisionTrees {

  def main(args: Array[String]): Unit = {

    new TuningDecisionTrees().compareImpurities(args(0), args(1).toInt)
  }
}