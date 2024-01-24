

object obj1 {
  def main(args: Array[String]){
    val a=Seq (1,2,3,4)
    val b=Set(4,5,6,9)
    val c=Map(("a",25), ("b",50), ("c",75))
    println(a.apply(3))
    println(b.apply(4))
    println(c.apply("b"))
  }
}