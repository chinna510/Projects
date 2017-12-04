package com.breeze.linear

import breeze.linalg.DenseVector
import breeze.linalg.DenseMatrix

object MatrixAndVectorFromFunc {

  def vectorFunc(): Unit = {

    val vfFunc = DenseVector.tabulate(3) { i => i * 2 }

    println(vfFunc)
    vfFunc.foreach(println)
  }
  def matrixFrmFunc(): Unit = {

    val mfFunc = DenseMatrix.tabulate(3, 3) { case (i, j) => i + j }

    println(mfFunc)
  }

  def main(args: Array[String]): Unit = {

    vectorFunc()
    matrixFrmFunc()
  }
}