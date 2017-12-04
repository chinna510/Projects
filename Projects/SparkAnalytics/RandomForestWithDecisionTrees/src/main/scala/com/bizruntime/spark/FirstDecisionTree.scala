package com.bizruntime.spark

import org.apache.spark.SparkContext

import org.apache.spark.SparkConf
import org.apache.spark.SparkConf
import org.apache.spark.rdd.RDD._
import org.apache.spark.mllib.regression._
import org.apache.spark.mllib.linalg._
import org.apache.mesos.protobuf.GeneratedMessageLite.ExtendableBuilder
import org.apache.spark.mllib.tree.model.DecisionTreeModel
import org.apache.spark.rdd.RDD
import org.apache.spark.mllib.evaluation.MulticlassMetrics
import org.apache.spark.mllib.tree.DecisionTree
import scala.collection.immutable.Map
import org.apache.log4j.Logger

class FirstDecisionTree extends Serializable {

  val conf: SparkConf = new SparkConf().setAppName("FirstDecisionTree")
  val sc: SparkContext = new SparkContext(conf)

  val logger: Logger = Logger.getLogger("FirstDecisionTree")

  //firstTree() Starting
  def firstTreeCreation(filename: String, minPartitions: Integer): Unit = {

    val rawData: RDD[String] = sc.textFile(filename, minPartitions)

    val data = rawData.map { line =>
      val values = line.split(",").map(_.toDouble)
      //init returns all but last value; target is last column
      val futureVector: Vector = Vectors.dense(values.init)
      // DecisionTree needs labels starting at 0; subtract 1
      val label: Double = values.last - 1
      LabeledPoint(label, futureVector)
    }

    val Array(trainData, crossValidData, testData) = data.randomSplit(Array(0.8, 0.1, 0.1))
    trainData.cache()
    crossValidData.cache()
    testData.cache()

    val model: DecisionTreeModel = DecisionTree.trainClassifier(trainData, 7, Map[Int, Int](), "gini", 4, 100)
    val cvMetrics: MulticlassMetrics = getMetrics(model, crossValidData)
    val confMatrix: Matrix = cvMetrics.confusionMatrix
    logger.info("Confusion Matrix \n " + confMatrix)
    val accuratePredicates: Double = cvMetrics.precision
    //It Will Give 37% Accuracy
    logger.info("Accuracy : " + accuratePredicates)

    //DecisionTreeModel numbers categories from 0 to 7
    (0 until 7).map(category => (cvMetrics.precision(category), cvMetrics.recall(category))).foreach(value => logger.info(value))

    val trainProbabilities = classProbabilities(trainData)

    val cvProbabilities = classProbabilities(crossValidData)

    val cvOverTrain: Double = trainProbabilities.zip(cvProbabilities).map { case (train, cv) => train * cv }.sum

    logger.info("Probability : " + cvOverTrain)

  } // firstTree() Ending

  def getMetrics(model: DecisionTreeModel, data: RDD[LabeledPoint]): MulticlassMetrics = {

    val predictionsAndLabels = data.map(example => (model.predict(example.features), example.label))

    new MulticlassMetrics(predictionsAndLabels)

  }
  def classProbabilities(data: RDD[LabeledPoint]): Array[Double] = {

    val countsByCategory = data.map(_.label).countByValue()
    val counts = countsByCategory.toArray.sortBy(_._1).map(_._2)
    counts.map(_.toDouble / counts.sum)

  }

}

object FirstDecisionTree extends Serializable{
  def main(args: Array[String]): Unit = {

    new FirstDecisionTree().firstTreeCreation(args(0), args(1).toInt)

  }

}