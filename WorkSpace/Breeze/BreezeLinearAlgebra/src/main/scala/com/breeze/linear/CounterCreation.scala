package com.breeze.linear

import breeze.linalg.Counter
import org.apache.log4j.Logger

import java.io.File
import breeze.linalg.csvread
import breeze.linalg.DenseMatrix

object CounterCreation {

  val log = Logger.getLogger("CounterCreation")

  def create(): Unit = {

    val counter: Counter[String, Int] = Counter("a" -> 1, "b" -> 2, "x" -> 3)

    counter("y") = 17

    log.info(counter)

    log.debug(counter dot counter)

    counter += 10

    log.info(counter)

    counter += Counter("x" -> 100, "c" -> 3)
    log.info(counter)

   
  }

  def main(args: Array[String]): Unit = {

    create()

  }
}