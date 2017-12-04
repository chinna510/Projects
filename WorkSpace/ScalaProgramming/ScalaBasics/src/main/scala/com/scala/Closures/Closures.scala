package com.scala.Closures

object Closures {

  def main(args: Array[String]) {

    println(multiplier(1))
     println(multiplier(2))
      println(multiplier(3))

  }

  var factor = 3
  val multiplier = (i: Int) => i * factor

}