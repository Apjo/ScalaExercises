package com.aniketjoshi.chapter3

import scala.util.Random

object Chapter3 {

  def initArray(high: Int) = {
  for(ctr <- 0 to high) yield Array(new Random())
}

  def swapAdjacentElementsOfArray(t: Array[Int]) = {
    for(elem <- t.indices; if elem % 2 == 1) {
      val temp = t(elem); t(elem) = t(elem - 1); t(elem - 1) = temp
    }
  }

  def swapAdjacentElementsOfArrayWithForYield(t: Array[Int]) = {
    for(elem <- t.indices) yield {
      if (elem % 2 == 1)
        t(elem - 1)
      else if(elem + 1 <= t.length - 1)
        t(elem + 1)
      else
        t(elem)
    }
  }

  //positive no.s in their original order, 0 or negative no.s in their original order
  def alignElements(x: Array[Int]) = x.filter (_ > 0) ++ x.filter(_ <= 0)

  //compute the average of an Array of Double
  def computeAvgForDoubleArray(a: Array[Double]) = a.sum / a.length

  //rearrange the elements of an Array[Int] so that they appear in reverse sorted order.
  def rearrangeInReverseSort(a: Array[Int]) = {
    a.sortWith(_ > _)
  }

  //remove duplicates from an array
  def removeDuplicates(a: Array[Int]) = a.distinct

  //make use of `drop`
  def useDrop(a: Array[Int]) = for (i <- a.indices if i <= a.indexWhere(_ < 0) || a(i) > 0) yield a(i)

  def stripTZ() = java.util.TimeZone.getAvailableIDs.map(_.replace("America/", "")).sorted
}
