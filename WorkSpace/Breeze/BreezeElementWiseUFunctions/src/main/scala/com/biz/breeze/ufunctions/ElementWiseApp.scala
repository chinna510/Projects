package com.biz.breeze.ufunctions

import breeze.linalg._

import breeze.math._
import breeze.numerics._
import org.apache.log4j.Logger

object ElementWiseApp {

  val logger: Logger = Logger.getLogger("ElementWiseApp")

  def main(args: Array[String]): Unit = {

    ElementWiseApp.uFunctions()
  }

  def uFunctions(): Unit = {

    logger.info(log(1.0))

    val dense: DenseMatrix[Double] = DenseMatrix((1.0, 2.0), (3.0, 4.0))
    logger.info(dense)
    logger.info(log(dense))

    log(Array(1.0, 2.0)).foreach(x => logger.info(x))

    log.inPlace(dense).foreachKey({ case (x, y) => println(x + " " + y) })

  }
}