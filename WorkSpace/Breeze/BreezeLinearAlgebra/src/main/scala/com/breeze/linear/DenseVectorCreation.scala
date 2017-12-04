import breeze.linalg._

import java.util.Arrays

object DenseVectorCreation {

  def create(): Unit = {

    // DenseMatrix
    val denseMatrix = DenseMatrix(1, 2, 3, 4)
    println("Rows :  " + denseMatrix.rows + " Columns : " + denseMatrix.cols)

    print(denseMatrix)
    //Dense Vector
    val dense = DenseVector(1, 2, 3)
    val denseMatrix1 = dense.asDenseMatrix
    println("Rows : " + denseMatrix1.rows + " Columns : " + denseMatrix1.cols)
    print(denseMatrix1)

    //Zeroed vector 
    val denseZero = DenseVector.zeros[Double](5)
    println(denseZero.length)
    denseZero.foreach(println)

    //DenseOnes Vector
    val denseOnes = DenseVector.ones[Double](5)
    denseOnes.foreach(println)

    //DenseZero Matrix
    val denseZeroMatrix = denseZero.asDenseMatrix
    print("denseZeroMatrix : " + denseZeroMatrix)
    // denseZeroMatrix.foreachPair((x, y) => println(x._1 + " -> " + y))

    //DenseOnes MAtrix
    val denseOnesMatrix = denseOnes.asDenseMatrix
    // denseOnesMatrix.foreachPair((x, y) => println(x._1 + " -> " + y))
    print(denseOnesMatrix)

    //DenseVector Fill(number of Elements){element}
    val denseFill = DenseVector.fill(10) { 5.0 }
    denseFill.foreach(println)

    //DanseRangeVector . it Prints values between 1 to 10 and difference between elements is 2 . like 1,3,5,7,9

    val denseRangeVector = DenseVector.range(1, 10, 2)
    denseRangeVector.foreach(println)

    //Vector Range Same as Dense Range Vector but it is for Double values 
    val vectorRange = Vector.rangeD(1, 10, 3)
    vectorRange.foreach(println)

   
  }

  def main(args: Array[String]): Unit = {

    DenseVectorCreation.create()

  }
}