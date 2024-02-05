import org.apache.spark.sql.SparkSession

object FlatMap_example {
  def main(args: Array[String]){
   val spark = SparkSession.builder().master("local[1]").appName("abc").getOrCreate();
   val sc = spark.sparkContext
   val rdd1= sc.textFile()
  
}
}