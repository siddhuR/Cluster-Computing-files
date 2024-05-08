import org.apache.spark.sql.SparkSession
import org.apache.spark._
import org.apache.spark.streaming._
import org.apache.spark.streaming.StreamingContext._ 
import org.apache.spark.sql.functions._

object sparkStructureRate {
  def main(args: Array[String]){
    
    val spark = SparkSession.builder().master("local[1]").appName("abc").getOrCreate()
   
    spark.sparkContext.setLogLevel("ERROR")
   
    //define host and port number to listen
   val host ="127.0.0.1"
   val port = "9999"
   
   //Creating Streaming dataframe by reading data from socket.
   
   val initDF = (spark.readStream.format("rate").option("rowsPerSecond",10).load())
   
   //Check if dataframe is streaming or not
   println("Streaming DataFrame : " + initDF.isStreaming)
   println(initDF.printSchema())
   
   val resultDF = initDF.withColumn("result",col("value")+lit(1))
   //val wordCount = (initDF.select(explode(split ( col("value")," ")).alias("words")).groupBy("words").count())
   
   
   resultDF.writeStream.outputMode("append").format("console").start().awaitTermination()
   
       
   
   
   
  }
} 