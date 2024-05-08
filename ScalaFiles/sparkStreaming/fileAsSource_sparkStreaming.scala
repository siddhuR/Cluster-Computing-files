import org.apache.spark.sql.SparkSession
import org.apache.spark._
import org.apache.spark.streaming._
import org.apache.spark.streaming.StreamingContext._
import org.apache.spark.sql.functions._
import org.apache.spark.sql.types._



object fileAsSource_sparkStreaming {
  def main(args:Array[String]){
    val spark = SparkSession.builder().master("local[1]").appName("abc").getOrCreate()
   
    spark.sparkContext.setLogLevel("ERROR")
   
    //define host and port number to listen
   val host ="127.0.0.1"
   val port = "9999"
   
   //Creating Streaming dataframe by reading data from socket.
   val cschema = StructType(List(StructField("ID",IntegerType,true),
       StructField("Name",StringType,true),
       StructField("DID" , IntegerType,true),
       StructField("Dname",StringType,true),
       StructField("VisitDate",DateType,true)
       ))
   
   val dfPatients = (spark.readStream.format("csv").option("header","true").option("path","/home/siddhu/workspace/Input_Files/dept").schema(cschema).load())
   
   val orthoPatients = dfPatients.select("ID","Name").where("DID = 35")
   orthoPatients.writeStream.outputMode("update").format("console").start().awaitTermination()
   
   
   
   //resultDF.writeStream.outputMode("append").format("console").start().awaitTermination() 
   
   
   
  }
}