package com.breeze.linear

import java.io.File
import breeze.linalg.csvread
import breeze.linalg.csvwrite
import breeze.linalg.DenseMatrix
import org.apache.log4j.Logger

object ReadingAndWritingMatrices {

  val log = Logger.getLogger("ReadingAndWritingMatrices")

  def read(): Unit = {

    val readingFrmFile: DenseMatrix[Double] = csvread(new File("/home/bizruntime/Chinna/BizRuntime/DataSamples/input.csv"))

    log.info(readingFrmFile)
  }

  def write(): Unit = {
    val readingFrmFile: DenseMatrix[Double] = csvread(new File("/home/bizruntime/Chinna/BizRuntime/DataSamples/input.csv"))

    val writeToFile = csvwrite(new File("/home/bizruntime/Chinna/BizRuntime/DataSamples/output.csv"), readingFrmFile, '\t', ''', '\t', 2)
  }

  def main(args: Array[String]): Unit = {
    ReadingAndWritingMatrices.read()
    ReadingAndWritingMatrices.write()

  }

}