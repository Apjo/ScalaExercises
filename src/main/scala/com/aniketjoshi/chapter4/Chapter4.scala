package com.aniketjoshi.chapter4

import java.util.Scanner
import java.io._
import java.util

object Chapter4_01 {
  //Set up a map of prices for a numbe rof gizmos you covet. Then produce a second map with the same keys and the prices at a discount of 10%
  val thingsToPrice = Map("bed" -> 400.0, "shoes" -> 100.2)
  val thingsToPriceDoubles = for ((key, value) <- thingsToPrice) yield (key, value * 0.9)
  assert(thingsToPriceDoubles == Map("bed" -> 360, "shoes" -> 90))
}

  object Chapter4_02 {
    //write a program that reads words from a file, use a mutable map to count how often each word appears.
    //To read the words simply use java.util.scanner
    def countWords() = {
      val reader = scala.collection.mutable.Map.empty[String, Int]
      val in = new Scanner(new File("myFile.txt"))
      while (in.hasNext()) {
        val word = in.next
        reader(word) = reader.getOrElse(in.next(), 0) + 1
      }
      for ((word, count) ← reader) println(s"word $word occurs $count times")
    }
  }

  object Chapter4_03 {
    //repeat the previous example with a Immutable Map
    def countWordsImmutable() = {
      var reader = Map.empty[String, Int]
      val in = new Scanner(new File("myFile.txt"))
      while (in.hasNext()) {
        val word = in.next
        reader += (word → (reader.getOrElse(word, 0) + 1))
      }
      for ((word, count) ← reader) println(s"word $word occurs $count times")
    }
  }

  object Chapter4_04 {
    //Repeat the preceding exercise with a sorted map, so that the words are printed in sorted order.
    def countAndPrintWordsInSorted() = {
      var sortedMap = scala.collection.SortedMap.empty[String, Int]
      val in = new Scanner(new File("myFile.txt"))
      while (in.hasNext()) {
        val word = in.next
        sortedMap += (word → (sortedMap.getOrElse(word, 0) + 1))
      }
      for ((word, count) ← sortedMap) println(s"word $word occurs $count times")
    }
  }

  object Chapter4_05 {
    //Repeat the preceding exercise with a java.util.TreeMap that you adapt to the Scala API.
    def countAndPrintWordsInSorted() = {
      import scala.collection.JavaConverters._
      var tree = new util.TreeMap[String, Int]().asScala
      val in = new Scanner(new File("myFile.txt"))
      while (in.hasNext()) {
        val word = in.next
        tree += (word → (tree.getOrElse(word, 0) + 1))
      }
      for ((word, count) ← tree) println(s"word $word occurs $count times")
    }
  }

    object Chapter4_06 {
      //Define a linked hash map that maps "Monday" to java.util.Calendar.MONDAY, and similarly for the other weekdays. Demonstrate that the elements are visited in insertion order.
      def generateMappedMondays() = {
        val mondayMapper = scala.collection.mutable.LinkedHashMap[String, Int]()
        mondayMapper += ("MONDAY" → java.util.Calendar.MONDAY)
        mondayMapper += ("TUESDAY" → java.util.Calendar.TUESDAY)
        mondayMapper += ("WEDNESDAY" → java.util.Calendar.WEDNESDAY)
        mondayMapper += ("THURSDAY" → java.util.Calendar.THURSDAY)
        mondayMapper += ("FRIDAY" → java.util.Calendar.FRIDAY)
        mondayMapper += ("SATURDAY" → java.util.Calendar.SATURDAY)
        mondayMapper += ("SUNDAY" → java.util.Calendar.SUNDAY)

        for((dayOfTheWeek, weekNumber) ← mondayMapper) println(s"Day of the week $dayOfTheWeek is $weekNumber")
      }
    }
    object Chapter4_07 {
      //print a table of all java properties
      def printJavaProperties() = {
        import scala.collection.JavaConverters._
        val systemProps: scala.collection.mutable.Map[String, String] = System.getProperties.asScala
        val maxKeyLength = (for((key, value) ← systemProps) yield key.length).max

        for((key, value) ← systemProps) printf("%-"+maxKeyLength + "s | %s \n", key, value)
      }
    }

    object Chapter4_08 {
      //Write a function minmax(values: Array[Int]) that returns a pair containing the smallest and largest values in the array.
      def minmax(values: Array[Int]) = (values.min, values.max)
    }

    object Chapter4_09 {
      //Write a function lteqgt(values: Array[Int], v: Int) that returns a triple containing the counts of values less than v, equal to v, and greater than v.
      def lteqgt(values: Array[Int], v: Int) ={
        (values.count(_ < v), values.count(_ == v), values.count(_ > v))
      }
    }

    object Chapter4_10 {
      print("Hello".zip("World"))
    }