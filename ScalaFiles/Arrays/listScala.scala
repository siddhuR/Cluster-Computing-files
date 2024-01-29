

object listScala {
  def main(args: Array[String]){
    
    // simple list
    val fruitList = List("orange", "banana", "apple", "grape");
    fruitList.foreach(println);
    
    // Constructing List using :: and nil
    val list = 20::30::Nil    // element_x::element_xs
    list.foreach(println)
    
    val list1 = 20::30::40::50::Nil    // element_x::element_xs
    val list2 = list1:+60      // Appending Elements
    list2.foreach(println)
    
    val list3 = 30+:list2;    // prepending Elements
    list3.foreach(println)
    
    val conc = list1:::list3;    // concatenation
    conc.foreach(println)
    
    println("Head"+list.head);    // head gives only first element in the list
    println("Tail"+list1.tail);   // tail gives all the values except first element in the list
  }
}