import org.apache.spark.sql.SparkSession

object Actions {
  def main(args: Array[String]){
    val spark = SparkSession.builder().master("local[1]").appName("abc").getOrCreate()
    val sc = spark.sparkContext

    // Actions
    val rdd = sc.parallelize(List(1,2,3,4,5))
    val result2 = rdd.count()
    println(result2)
    val result3 = rdd.max()
    println(result2)
    val result4 = rdd.min()
    println(result2)
    val result5 = rdd.sum()
    println(result2)
    val result6 = rdd.mean()
    println(result2)
    
    // CountByKey & CountByValue
    val rdd1 = sc.parallelize(Array(("a",1),("a",2),("b",3)))
    val result7 = rdd1.countByKey()
    println(result7)
    val result8 = rdd1.countByValue()
    println(result8)
    
    // Reduce
    val rdd2 = sc.parallelize(List(1,2,3,4,5))
    val result9 = rdd2.reduce(_+_)    // Method 1
    val result10 = rdd2.reduce((a,b)=>a+b)  // Method 2
    println(result9)  // println(result10)
    
    // Coalesce & Repartition
    val rdd3 = sc.parallelize(Array(("a",1),("a",2),("b",3)),4)
    println(rdd3.partitions.length)
    rdd3.coalesce(2)
    println(rdd3.partitions.length)
    val rdd4 = sc.parallelize(Array(("a",5),("a",8),("b",1),("b",6)))
  }
}