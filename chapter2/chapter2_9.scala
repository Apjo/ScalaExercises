import scala.annotation.tailrec
object problem9 {

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
 def main(args:Array[String]): Unit = {
   println("Recusive product:"+productRecursive(args(0)))  
 }
}
