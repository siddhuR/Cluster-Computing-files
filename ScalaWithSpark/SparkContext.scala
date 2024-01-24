import org.apache.spark.sql.SparkSession

object SparkContext {
  def main(args: Array[String]){
   val s = sc.sparkContext.textFile("/home/siddhu/sparkexample") 
  }
}