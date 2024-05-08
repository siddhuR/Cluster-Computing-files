import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._
import org.apache.spark._
import org.apache.spark.streaming._
import org.apache.spark.streaming.StreamingContext._

object ca324042024 {
  def main(args: Array[String]){
    // 1Q. 
    val spark = SparkSession.builder().master("local[1]").appName("abc").getOrCreate()
    val sc = spark.sparkContext
    import spark.implicits
    sc.setLogLevel("OFF")
    
    val df = spark.read.format("csv").option("header","true").option("inferSchema","true").load("/home/siddhu/workspace/order.csv")
    
    df.createOrReplaceTempView("Sales")
    
    val df1 = spark.read.format("csv").option("header","true").option("inferSchema","true").load("/home/siddhu/workspace/product.csv")
    
    df1.createOrReplaceTempView("product")
    
    spark.sql("show tables").show()
  }
}











// //2nd Question:
//import org.apache.spark.sql.SparkSession
//import org.apache.spark._
//import org.apache.spark.streaming._
//import org.apache.spark.streaming.StreamingContext._ 
//
//object ca324042024 {
//  def main(args: Array[String]){
//    
//    val spark = SparkSession.builder().master("local[1]").appName("ca3").getOrCreate()
//    val sc = spark.sparkContext
//    sc.setLogLevel("OFF")
//    sc.stop()  // to stop all the previous spark sessions.
//    
//    val conf = new SparkConf().setMaster("local[2]").setAppName("NetworkWordCount")
//    val ssc = new StreamingContext(conf, Seconds(10))
//    
//    val lines = ssc.socketTextStream("localhost", 9999)
//    
//    
//    val a = lines.flatMap(_.split(" ")).map(_.toInt)
//    val b = a.filter(_ % 2 == 0)
//    b.print()
//   
//    ssc.start()
//    ssc.awaitTermination()
//  }
//} 