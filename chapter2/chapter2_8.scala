object problem8 {
 def product(str:String):Int = {
   var p = 1
   for(j <- str) {
       p *= j.toInt
   }
  p
 }
 def main(args:Array[String]):Unit = {
    println(s"Product of unicode characters of a string are:"+product(args(0)))
 }
}
