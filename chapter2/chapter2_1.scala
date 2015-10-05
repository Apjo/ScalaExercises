object Chapter2 {
def calculateSignum(num:Int):Int={
if(num < 0) -1
else if(num > 0) 1
else 0
}
 def main(args:Array[String]):Unit = {
  if(args == null) {
    println("No arguments provided exiting !!")
  } else {
        if(args.length > 0) {
          val numberArg = args(0)
	  
          println(s"We got: $numberArg")  
	  
          val number = numberArg.toInt
          	
          val output = calculateSignum(number)
          if(output == 1) {
            println("We got a positive number")
	  } else if(output == -1) {
                println("we got a negative number")  
            } else {
              println("we got a 0")
             }   
       }
   }
 }
}
