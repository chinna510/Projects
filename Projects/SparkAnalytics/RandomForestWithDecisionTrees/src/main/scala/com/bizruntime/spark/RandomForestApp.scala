package com.bizruntime.spark

import org.apache.spark.SparkContext
import org.apache.spark.SparkConf
import org.apache.spark.rdd.RDD._
import org.apache.spark.mllib.regression._
import org.apache.spark.mllib.linalg._
import org.apache.log4j.Logger
import org.apache.spark.rdd.RDD
import org.apache.spark.mllib.tree.model.DecisionTreeModel
import org.apache.spark.mllib.tree.DecisionTree
import org.apache.spark.mllib.evaluation.MulticlassMetrics
import org.apache.spark.mllib.tree.RandomForest
import org.apache.spark.mllib.tree.model.RandomForestModel

class RandomForestApp extends Serializable {

  val conf: SparkConf = new SparkConf().setAppName("RandomForestApp").setMaster("local[*]")
  val sc: SparkContext = new SparkContext(conf)

  val logger: Logger = Logger.getLogger("RandomForestApp")

  def random(filename: String, minPartitions: Integer): Unit = {

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

    val model = RandomForest.trainClassifier(trainData, 7, Map(10 -> 4, 11 -> 40), 20, "auto", "entropy", 30, 300)

    val cvMetrics: MulticlassMetrics = getMetrics(model, crossValidData)

    val accuratePredicates: Double = cvMetrics.precision
    logger.info("CVDATA Accuracy : " + accuratePredicates)

    val trainMetrics = getMetrics(model, trainData)
    val trainPredicates = trainMetrics.precision
    logger.info("TrainDataAccuracy : " + trainPredicates)

  }
  def getMetrics(model: RandomForestModel, data: RDD[LabeledPoint]): MulticlassMetrics = {

    val predictionsAndLabels = data.map(example => (model.predict(example.features), example.label))

    new MulticlassMetrics(predictionsAndLabels)

  }

}
object RandomForestApp extends Serializable{

  def main(args: Array[String]): Unit = {

    new RandomForestApp().random(args(0), args(1).toInt)
  }

}