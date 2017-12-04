package com.scala.functions

object AnonymousFunctions {

  def main(args: Array[String]) {

    println(inc(10))

  }

  val inc = (x: Int) => x + 1;

  val x = inc(10) - 1;

}