package com.breeze.linear

import breeze.linalg.DenseVector

import breeze.linalg.DenseMatrix
import org.apache.log4j.Logger

object VectorAndMAtrixFromRandom {

  val log = Logger.getLogger("VectorAndMAtrixFromRandom")
  
  def vectorFrRandom(): Unit = {

    val vector = DenseVector.rand(4)

    vector.foreach(log.info)

 println(vector.keys)
  println(vector.pairs)

 val iter=vector.iterator.drop(0)  
 
 iter.foreach(println)
 
 println(vector.keySet)
  }

  def matrixFrRandom(): Unit = {

val matrix = DenseMatrix.rand(3, 2)
    println(matrix)
  }

  def main(args: Array[String]): Unit = {

    vectorFrRandom()

    matrixFrRandom()

  }
}