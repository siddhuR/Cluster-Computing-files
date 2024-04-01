import org.apache.spark.sql.SparkSession
import org.apache.spark._
import org.apache.spark.streaming._
import org.apache.spark.streaming.StreamingContext._ 
import org.apache.spark.sql.functions._

object scalaStructuredStreaming {
  def main(args: Array[String]){
    
    //creating spark session
    val spark = SparkSession.builder().master("local[1]").appName("Socket Source").getOrCreate()
    spark.sparkContext.setLogLevel("ERROR")
    
    
    val host = "127.0.0.1"
    val port = "9999"
    
    // create streaming dataframe by reading data from socket
    val initDF = (spark.readStream.format("socket").option("host", host).option("port", port).load())
    
    // checl if th edataframe is streaming or not
    
    print(initDF.printSchema())
    println("Streaming DataFrame :" + initDF.isStreaming)
    
    //performing word count on streaming dataframe
    val wordCount = (initDF.select(explode(split(col("value"), " ")).alias("words")).groupBy("words").count())
    
    //print Schema of Dataframe
    println("Schema of DataFrame wordCount.")
    println(wordCount.printSchema())
    
//    wordCount.writeStream.outputMode("update")      // change the output format from update to append and complete to see changes
//    .format("console").start().awaitTermination()
    
    wordCount.writeStream.outputMode("complete")
    .format("console").start().awaitTermination()
    
    
  }
} 