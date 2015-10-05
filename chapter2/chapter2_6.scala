object problem6 {
 def computeProduct(str:String): Int = {
    var p = 1
    for(i <- str) p *= i.toInt
    p
 }

 def main(args:Array[String]):Unit = {
   val str = args(0)
   println("product:"+computeProduct(str))
 }
}
