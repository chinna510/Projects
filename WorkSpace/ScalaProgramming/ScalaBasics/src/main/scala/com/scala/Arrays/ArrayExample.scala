package com.scala.Arrays

object ArrayExample {
  def main(args: Array[String]): Unit = {

    var myList = Array(1.9, 2.9, 3.4, 3.5)

    for (i <- myList)
      println(i)

       // Summing all elements
      var total = 0.0;
      
      for ( i <- 0 to (myList.length - 1)) {
         total += myList(i);
      }
      println("Total is " + total);

      
  }
}