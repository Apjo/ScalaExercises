import scala.annotation.tailrec
object problem9 {

def productRecursive(str:String):Int = {
  @tailrec
  def productAccumulator(str:Array[Char], accum:Int): Int = {
    if(str.length == 0) 1
    else productAccumulator(str, accum * str.map(_.toInt))
  }
  productAccumulator(str.toCharArray, 1)
 } 
 def main(args:Array[String]): Unit = {
   println("Recusive product:"+productRecursive(args(0)))  
 }
}
