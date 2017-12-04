package com.scala.functions

object HigherOrderFunctions {

  def main(args: Array[String]): Unit = {

    println(apply(log, 10))

  }

  def apply(f: Int => String, v: Int) = f(v)

  def log[A](x: A) = x.toString()

}