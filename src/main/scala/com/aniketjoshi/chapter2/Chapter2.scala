package com.aniketjoshi.chapter2


import scala.annotation.tailrec

object Chapter2 {

def calculateSignum(num:Int):Int={
if(num < 0) -1
else if(num > 0) 1
else 0
}

  def countdown(num:Int) {
    if(num == 0) print(0)
    if(num < 0) {
      for(i <- num to 0) {
        print(i+" ")
      }
    }
    if(num > 0){
      var j = num
      while(j >= 0) {
        print(j+" ")
        j = j - 1
      }
    }
    println()
  }

  def xRaisedToN(x:Double, n:Int):Double = {
    x match {
      case 0 => 0
      case _ => n match {
        case n if n > 0 &&  n % 2 == 0 && n == 2 => x * x
        case n if n > 0 && n % 2 == 0 => xRaisedToN(xRaisedToN(x, n / 2), 2)
        case n if n > 0  && n % 2 > 0 => x * xRaisedToN(x, n - 1)
        case n if n < 0 => 1 / xRaisedToN(x ,-n)
        case n if n == 0 => x
        case _ => 0
      }
    }
  }

  def productOfCharacters(str:String):Int = {
    str.map(_.toInt).product
  }
  def computeProduct(str:String): Int = {
    var p = 1
    for(i <- str) p *= i.toInt
    p
  }

  def product(str:String):Int = {
    var p = 1
    for(j <- str) {
      p *= j.toInt
    }
    p
  }

  def productRecursive(str:String):Int = {
    @tailrec
    def productAccumulator(accum:Int, idx:Int): Int = {
      if(str.length == idx) accum
      else {
        val currentChar = str(idx).toInt
        val updatedAccum = accum * currentChar
        val nextIdx = idx + 1
        productAccumulator(updatedAccum, nextIdx)
      }
    }
    productAccumulator(1, 0)
  }
}
