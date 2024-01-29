

object ScalaStrings {
  def main(args: Array[String]){
    println("Hello" + "World")
    val a="Sid"
    println(s"Hellow $a Woorld")    // s here is the simple string interpolator
    println(s"Hellow ${2+4} Woorld")
    val pi=3.14159F
    println(f"the value of pi is $pi%.2f")
    println("Without Raw:\nFirst\nSecond")
    println(raw"With Raw:\nFirst\nSecond")
    val multilineString="""Hello this is sid
      from LPU"""
    println(multilineString)
    
    val s3= "hello, this, is, me"
    val s4=s3.split(",")
    for(words<-s4){
      println(words)
    }
    
    //pattern matching
    val expression = "[1-5]{2}+".r
    val series = "12 67 93 48 51"
    val match1 = expression.findAllIn(series)
    match1.foreach(println)
    
    // regualr expressionas
    val replaceIn = "8201530"
    var replaced = replaceIn.replaceFirst("01","x")
    println(replaced)
  }
}