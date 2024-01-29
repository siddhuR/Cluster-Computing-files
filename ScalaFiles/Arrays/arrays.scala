

object arrays {
  def main(args: Array[String]){
    
    // >>ARRAYS<<
    
   val arr = Array(1,2,3,4);
   val arr2 = new Array[Int](4);
   
   val arr3 = Array.range(0,5);
   arr3.foreach(println);
   
   val arr4 = Array.fill(2)("UBD");  // fill(number of elements)(value)
   arr4.foreach(println);
   // inplace of foreach, we can use for loop
   for (i <-arr4){
     println(i);
   }
   
   val arr5 = "hello".toArray  // converts arguments to an array
   arr5.foreach(println);
   
   // question
   val arr6 = Array(1,2,3,4,5,6,7,8,9,0).filter(x=>x%2==0).map(c=>c*10).reverse.foreach(println);  // "(x=>x%2==0)" can be also written as "(_%2==0)"
   
   arr5(2)
  }
}