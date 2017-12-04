package com.breeze.linear

import breeze.linalg.DenseMatrix

object MatrixFromArray {
  
  
  def create(): Unit = {
    
    val matrix= new DenseMatrix(2,3,Array(1,2,3,4,5,6))
    
    print(matrix)
    
  }
  
  def main(args: Array[String]): Unit = {
    
    create()
  }
}