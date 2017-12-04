package com.biz.breeze.ufunctions

import breeze.linalg._
import breeze.numerics._
import breeze.math._

object ReductionUFunctions {

  def main(args: Array[String]): Unit = {

    ReductionUFunctions.uFunctions()

  }

  def uFunctions(): Unit = {

    val matrix: DenseMatrix[Double] = DenseMatrix((1.0, 2.0, 3.0), (4.0, 5.0, 6.0))

    //It will SUM all the elements in Matrix
    println(sum(matrix))

    
    
  }

}