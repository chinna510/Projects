package com.breeze.linear

import breeze.linalg.DenseMatrix

object InlineMatrix {
  
  
  def create(): Unit = {
    
  val inline=  DenseMatrix((1.0,2.0,5.0),(3.0,4.0,6.0),(5.0,3.0,2.0))
    
  println(inline)
  
  }
  def main(args: Array[String]): Unit = {
    
    
    InlineMatrix.create()
  }
}