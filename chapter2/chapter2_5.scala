object problem5 {
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

 def main(args:Array[String])= {
   if(args.length > 0) {
      val num = args(0).toInt
      println(s"You supplied:$num")
      countdown(num)
   } else {
     println("must supply 1 argument!")
    }
 }
}
