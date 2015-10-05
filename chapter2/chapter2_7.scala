object problem7 {
def productOfCharacters(str:String):Int = {
 str.map(_.toInt).product
}

def main(args:Array[String]):Unit = {
println("product of characters is:"+ productOfCharacters(args(0)))
}
}
