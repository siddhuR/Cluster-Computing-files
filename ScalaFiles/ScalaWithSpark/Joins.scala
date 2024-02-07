import org.apache.spark.sql.SparkSession

object Joins {
  def main(args: Array[String]){
    val spark = SparkSession.builder().master("local[1]").appName("abc").getOrCreate()
    val sc = spark.sparkContext

    // Joins
    val rdd1 = sc.parallelize(Array(("a",1),("a",2),("b",3)))
    val rdd2 = sc.parallelize(Array(("a",5),("a",8),("b",1),("b",6)))
    val result = rdd1.join(rdd2)
    println(result.collect().mkString(","))
    
    // UNION & INTERSECTION
    val rdd3 = sc.parallelize(List(1,2,3,4,5))
    val rdd4 = sc.parallelize(List(1,3,5,7,10))
    val result2 = rdd3.union(rdd4)
    println(result2.collect().mkString(","))
    val result3 = rdd3.intersection(rdd4)
    println(result3.collect().mkString(","))
       
  }
}