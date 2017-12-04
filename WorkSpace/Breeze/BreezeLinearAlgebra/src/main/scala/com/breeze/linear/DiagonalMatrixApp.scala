package com.breeze.linear

import breeze.linalg._

object DiagonalMatrixApp {
  
  def create(): Unit = {
   
   val diagonal = diag(DenseVector(1,2,3,4))
    
    print(diagonal)
    
  }
  
  def main(args: Array[String]): Unit = {
   
    DiagonalMatrixApp.create()
  }
  
}