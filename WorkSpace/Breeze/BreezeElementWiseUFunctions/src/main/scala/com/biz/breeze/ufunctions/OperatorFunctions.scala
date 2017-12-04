package com.biz.breeze.ufunctions

import breeze.linalg.DenseVector
import breeze.numerics._
import breeze.math._

import org.apache.log4j.Logger
import breeze.linalg.operators.OpAdd
import breeze.linalg.operators.OpSub
import breeze.linalg.operators.OpNeg

object OperatorFunctions {

  val logger: Logger = Logger.getLogger("OperatorFunctions")

  def main(args: Array[String]): Unit = {

    OperatorFunctions.oFunctions()

  }

  def oFunctions(): Unit = {

    val v1: DenseVector[Double] = DenseVector(1.0, 2.0)

    val v2: DenseVector[Double] = DenseVector(3.0, 4.0)

    val result: DenseVector[Double] = v1 + v2
    logger.info(result)

    //OR

    OpAdd(v1, v2).foreach(result => logger.info(result))

    // unary operator
    val unaryVector: DenseVector[Double] = -v1
    unaryVector.foreach(values => logger.info(values))

    //OR

    OpNeg(v1).foreach(values => logger.info(values))

    //SubStraction
    OpSub(v1, v2).foreach(result => logger.info(result))

  }

}