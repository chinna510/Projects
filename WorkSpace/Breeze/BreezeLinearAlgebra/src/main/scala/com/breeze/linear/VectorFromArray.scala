package com.breeze.linear

import breeze.linalg.DenseVector

object VectorFromArray {

  def create(): Unit = {

    val vectorFrmArray = new DenseVector(Array(0, 1, 2, 3, 4))

    println(vectorFrmArray)
    vectorFrmArray.foreach(println)

  }

  def main(args: Array[String]): Unit = {

    create()
  }
}