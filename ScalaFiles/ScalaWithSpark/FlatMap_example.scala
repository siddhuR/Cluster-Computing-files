import org.apache.spark.sql.SparkSession

object FlatMap_example {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().master("local[1]").appName("abc").getOrCreate()
    val sc = spark.sparkContext

    // Adjust the file path to point to a valid file
    val rdd1 = sc.textFile("/home/siddhu/workspace/Input_Files/FlatMap")

    // Use map transformation, but it will result in an RDD of arrays
    val rdd2 = rdd1.map(a => a.split(" "))
    // Uncomment the line below if you want to save rdd2 to a text file
    // rdd2.saveAsTextFile("/home/hayvik/spark/Map_FlatMap_Comparison")

    // Use flatMap transformation to get a flat RDD of words
    val rdd3 = rdd1.flatMap(a => a.split(" "))
    // Uncomment the line below if you want to save rdd3 to a text file
    // rdd3.saveAsTextFile("/home/hayvik/spark/Map_FlatMap_Comparison2")

    // Print the result of rdd3
    println(rdd3.collect().mkString(","))
  }
}