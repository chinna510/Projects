package com.scala.functions

import java.util.Date

object PartiallyFunctions {

  def main(args: Array[String]): Unit = {

    val date = new Date();
    log(date, "Hello1")

    Thread.sleep(10000)
    log(date, "Hello2")

    Thread.sleep(1000)
    log(date, "Hello3")

  }

  def log(date: Date, message: String): Unit = {

    println("Date : " + date + " Message :" + message)

  }

}