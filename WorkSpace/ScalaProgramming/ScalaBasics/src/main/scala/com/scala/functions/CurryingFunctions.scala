package com.scala.functions

object CurryingFunctions {

  def main(args: Array[String]) {

    val str1: String = "Hello, "
    val str2: String = "Scala!"

    println(concat(str1)(str2).toString())

  }

  def concat(str11: String)(str22: String) = {

    str11 + str22;

  }

}