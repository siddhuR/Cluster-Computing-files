import org.apache.spark.sql.SparkSession
import org.apache.spark._
import org.apache.spark.streaming._
import org.apache.spark.streaming.StreamingContext._ 

object sparkStreaming {
  def main(args: Array[String]){
    
    val spark = SparkSession.builder().master("local[1]").appName("abc").getOrCreate()
    val sc = spark.sparkContext
    sc.setLogLevel("OFF")
    sc.stop()  // to stop all the previous spark sessions.
    
    val conf = new SparkConf().setMaster("local[2]").setAppName("NetworkWordCount")
    val ssc = new StreamingContext(conf, Seconds(10))
    
    val lines = ssc.socketTextStream("localhost", 9999)
    
    //1. WORD COUNT
//    val words = lines.flatMap(_.split(" "))
//    
//    val pairs = words.map(word => (word, 1))
//    val wordCounts = pairs.reduceByKey(_ + _)
    
    //2. Sending number in the console and that number should be multiplied by 10.
//    val nums = lines.flatMap(_.split(" ")).map(_.toInt)
//    val pairs = nums.map(nums => (nums*10))
//    
//    pairs.print()
//    
    //3. count the word count that start with a.
    val words = lines.flatMap(_.split(" "))
    val pairs = words.map(word => (word, 1))
    val wordCounts = pairs.reduceByKey(_ + _)
    
     //lines.filter()
//    wordCounts.filter(col("wordCounts").startsWith("a")).show()
    
    ssc.start()
    ssc.awaitTermination()
  }
} 