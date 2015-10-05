import scala.annotation.tailrec

object problem10 {
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
 def main(args:Array[String]):Unit = {
  println("x raised to n is:"+ xRaisedToN(args(0).toDouble,args(1).toInt))
 }
}
