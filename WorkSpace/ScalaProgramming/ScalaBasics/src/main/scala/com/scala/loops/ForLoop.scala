package com.scala.loops

import scalaz.Forall

object ForLoop {

  def test(): Unit = {

    val a: Int = 0;
    val b: Int = 0;

    //TO Keyword 
    for (a <- 1 to 10) {
      println("TO : " + a)
    }

    //Until Keyword

    for (b <- 1 until 10) {
      println("UNTILL  : " + b)
    }
    //With List 
    var c = 0;
    var numlist = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    for (c <- numlist) {

      println(" Elements Of List: " + c)

    }

    //With Filters 
    for (c <- numlist if (c != 3); if (c < 8)) {

      println(" Elements Of Filtered List : " + c)

    }
    var retVal = for { c <- numlist if c != 3; if c < 8 } yield c

    for (c <- retVal) {
      println(c)
    }
  }

  def main(args: Array[String]): Unit = {

    test()
  }

}