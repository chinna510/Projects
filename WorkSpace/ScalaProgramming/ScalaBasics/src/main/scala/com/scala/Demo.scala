package com.scala

import com.scala.inheritence.Point

object SimpleObject {

  def main(args: Array[String]): Unit = {

    val point = new Point(10, 20);

    point.move(15, 30)
  }
}