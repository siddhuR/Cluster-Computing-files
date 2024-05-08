import scala.collection.mutable.ArrayBuffer

object arrayBuffers {
  def main(args: Array[String]){
    
    // >>ARRAY BUFFERS<<
    
    val arrB = new ArrayBuffer[Int] ()  // initializing arrayBuffer
    arrB+=1
    arrB+=4
    arrB+=6
    arrB+=3
    
    arrB-=1  // if we want to delete one by one value in the array
    // arrB.remove(2,4);  // to delete multiple values at a time in the array
    //arrB.clear();  // to delete all the values in the array
    print(arrB)
  }
}