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

class EntropyImpurity extends Serializable {

  val conf: SparkConf = new SparkConf().setAppName("EntropyImpurity")
  val sc: SparkContext = new SparkContext(conf)

  val logger: Logger = Logger.getLogger("TuningDecisionTrees")

  def checkigAccuracy(filename: String, minPartitions: Integer): Unit = {

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

    val model = DecisionTree.trainClassifier(trainData.union(crossValidData), 7, Map[Int, Int](), "entropy", 20, 300)

    val predictionsAndLabels = crossValidData.map(example =>
      (model.predict(example.features), example.label))
    val accuracy: Double =
      new MulticlassMetrics(predictionsAndLabels).precision

    // It will Give Around 95% Accuracy 
    logger.info("Accuracy : " + accuracy)
  }
}

object EntropyImpurity extends Serializable {

  def main(args: Array[String]): Unit = {

    new EntropyImpurity().checkigAccuracy(args(0), args(1).toInt)

  }
}