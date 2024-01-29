

object listScala {
  def main(args: Array[String]){
    
    // simple list
    val fruitList = List("orange", "banana", "apple", "grape");
    fruitList.foreach(println);
    
    // Constructing List using :: and nil
    val list = 20::30::Nil    // element_x::element_xs
    list.foreach(println)
  }
}