package com.breeze.linear

import breeze.linalg.CSCMatrix

object CreatingCSCMatrices {
  
  def create(): Unit = {
    
   val builder= new CSCMatrix.Builder[Double](rows =10,cols=10)
   
 val matrix=  builder.result()
   
 matrix.foreachPair((x,y) => println(x))
 
println(matrix) 
  }
  
  
  def main(args: Array[String]): Unit = {
    
    
    create()
  }
  
}