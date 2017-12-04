package com.spark.analytics
import org.apache.spark.util.StatCounter
import java.lang.Double


// Non-Missing Values Filter
class NAStatCounter extends Serializable {

  val stats: StatCounter = new StatCounter()

  var missing: Long = 0

  def add(x: Double): NAStatCounter = {
    if (Double.isNaN(x)) {

      missing = missing + 1
    } else {

      stats.merge(x)
    }
    this

  }

  def merge(other: NAStatCounter): NAStatCounter = {

    stats.merge(other.stats)

    missing += other.missing

    this
  }

  override def toString() = {

    "Stats :" + stats.toString() + " NaN :" + missing
  }

}

object NAStatCounter extends Serializable {

  def apply(x: Double) = new NAStatCounter().add(x)

}