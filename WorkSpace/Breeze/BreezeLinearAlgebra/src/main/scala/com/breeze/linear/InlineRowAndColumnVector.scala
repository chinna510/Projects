package com.breeze.linear

import breeze.linalg.DenseMatrix
import breeze.linalg.DenseVector

object InlineRowAndColumnVector {

  def rowVector(): Unit = {
    val rowVector = DenseVector(1, 2, 3, 4).t
    println(rowVector)
   
   
  }

  def columnVector(): Unit = {

    val colVector = DenseVector(1, 2, 3, 4)

    println(colVector)
    colVector.foreach(println)

  }

  def main(args: Array[String]): Unit = {
    
    rowVector()
    columnVector()
    
  }
}