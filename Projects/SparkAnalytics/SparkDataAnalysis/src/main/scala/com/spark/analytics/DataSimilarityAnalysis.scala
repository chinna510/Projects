package com.spark.analytics

import org.apache.spark.SparkContext

import java.lang.Double.isNaN
import org.apache.spark.SparkConf
import org.apache.spark.rdd.RDD
import org.apache.log4j.Logger
import akka.event.Logging


object DataSimilarityAnalysis extends Serializable {

  val log = Logger.getLogger("DataSimilarityAnalysis")
  def main(args: Array[String]): Unit = {

    DataSimilarityAnalysis.analyse(args(0), args(1).toInt)
  }

  def analyse(filename: String, noOfPartitions: Integer) = {

    val conf = new SparkConf().setAppName("DataSimilarityAnalysis").setMaster("local[2]");
    val sc = new SparkContext(conf);

    val blocks = sc.textFile(filename, noOfPartitions)

    val head = blocks.take(10)

    val noheader = blocks.filter(x => !isHeader(x))

    var line = head(5)

    val matchedTuple = parse(line)
    val noHeaderParse = noheader.map(line => parse(line))
    val cached = noHeaderParse.cache()

    //parsing function tested on a single record
    val matchngDataSet = head.filter(x => !isHeader(x)).map(x => parse(x))

    val grouped = matchngDataSet.groupBy(md => md.matched)

    grouped.mapValues(x => x.size).foreach(log.info)

    // Creation Of Histograms Using CountByValue() method
    val matchCounts = noHeaderParse.map(md => md.matched).countByValue()

    // It Contains Map[String, Long]
    val matchCountsSeq = matchCounts.toSeq

    // Sort By String
    matchCountsSeq.sortBy(_._1).foreach(log.info)
    // Sort By Long
    matchCountsSeq.sortBy(_._2).foreach(log.info)

    //Reverse The Sequence
    matchCountsSeq.sortBy(_._2).reverse.foreach(log.info)

    //Before Filtering mean,SD,Min and Max values are NaN
    val statsCounter = noHeaderParse.map(md => md.scores(0)).stats()
    log.info(statsCounter)

    //After Filtering All the variables Contains  Elements. isNaN method filter the placeholders in the data

    val filterStatsCounter = noHeaderParse.map(md => md.scores(0)).filter(!isNaN(_)).stats()

    //Scala’s Range construct to create a loop that would iterate through each index value    
    val stats = (0 until 9).map(i => {
      noHeaderParse.map(md => md.scores(i)).filter(!isNaN(_)).stats()
    })

    //  Insted Of this Logic we Wrote statsWithMissing() method 

    /*  val naStats = noHeaderParse.map(md => {
      md.scores.map(d => NAStatCounter(d))
    });
    log.info(naStats)
    val reduceStats = naStats.reduce((n1, n2) => {
    n1.zip(n2).map { case (a, b) => a.merge(b) }
    })
    reduceStats.foreach(log.info)*/

    //Statistics With Matching Datasets
    val statsm = statsWithMissing(noHeaderParse.filter(_.matched).map(_.scores))

    //Statistics With Non-Matching Datasets
    val statsn = statsWithMissing(noHeaderParse.filter(!_.matched).map(_.scores))

    statsm.zip(statsn).map { case (m, n) => (m.missing + n.missing, m.stats.mean - n.stats.mean) }
      .foreach((tuple) => log.info(tuple))

    val ct = noHeaderParse.map(md => {
      val score = Array(2, 5, 6, 7, 8).map(i => naz(md.scores(i))).sum

      Scored(md, score)
    })

    //ThresHold = 4.0
    val filterNM = ct.filter(s => s.score >= 4.0).map(s => s.md.matched).countByValue()

    //Thresshold =2.0
    val filterNM1 = ct.filter(s => s.score >= 2.0).map(s => s.md.matched).countByValue().foreach((tuple) => log.info(tuple))

  }
  def isHeader(line: String): Boolean = { line.contains("id_1") }

  def parse(line: String) = {
    val pieces = line.split(",")
    val id1 = pieces(0).toInt
    val id2 = pieces(1).toInt
    //Slice Method Is used for including values between two indexes
    val rawscores = pieces.slice(2, 11).map(toDouble)
    val matched = pieces(11).toBoolean
    MatchData(id1, id2, rawscores, matched)

  }

  def toDouble(s: String) = {
    if ("?".equals(s))
      Double.NaN
    else
      s.toDouble
  }

  def naz(d: Double) = if (Double.NaN.equals(d)) 0.0 else d

  def statsWithMissing(rdd: RDD[Array[Double]]): Array[NAStatCounter] = {

    val naStats = rdd.mapPartitions((iter: Iterator[Array[Double]]) => {

      val nas: Array[NAStatCounter] = iter.next().map(d => NAStatCounter(d))
      iter.foreach(arr => {

        nas.zip(arr).foreach { case (n, d) => n.add(d) }
      })
      Iterator(nas)
    })
    naStats.reduce { (n1, n2) =>
      {
        n1.zip(n2).map { case (a, b) => a.merge(b) }
      };

    }
  }
}

case class MatchData(id1: Int, id2: Int, scores: Array[Double], matched: Boolean) extends Serializable
case class Scored(md: MatchData, score: Double) extends Serializable

