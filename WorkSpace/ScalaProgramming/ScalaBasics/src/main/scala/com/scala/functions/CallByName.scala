package com.scala.functions

object CallByName {

  def time() = {
    println("Getting time in nano seconds")
    System.nanoTime
  }
  def delayed(t: => Long) = {
    println("In delayed method")
    println("Param: " + t)
  }

  def main(args: Array[String]) {
    delayed(time())
  }
}