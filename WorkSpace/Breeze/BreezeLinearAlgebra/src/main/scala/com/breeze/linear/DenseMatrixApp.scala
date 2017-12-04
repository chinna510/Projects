package com.breeze.linear
import breeze.linalg._

object DenseMatrixApp {
  
  def create(): Unit = {
   
   //LinSpace, it prints matrix of 5 * 4 , here 5 is number of rows, 4 is number of columns and 
    //linspace range between 1-20 with 20 elements 
    val linSpace = new DenseMatrix(5, 4, linspace(1.0, 20.0, 20).toArray)
    println("**LinSpace MAtrix** ")

    println(linSpace)

    // Identity Matrix
    val Identitymatrix = DenseMatrix.eye[Double](10)
    println("**Identity MAtrix** ")
    println(Identitymatrix)
  
  }
  
  
  def main(args: Array[String]): Unit = {
    
    DenseMatrixApp.create()
  }
}