package com.scala.Arrays

import Array._

object TwoDimensionalArrays {

  def main(args: Array[String]): Unit = {

    var myMatrix = ofDim[Int](3, 3)

    for (i <- 0 to 2) {
      for (j <- 0 to 2) {

        myMatrix(i)(j) = j

        print(" "+myMatrix(i)(j))
      }
      println()
    }

  }

}