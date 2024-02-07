import org.apache.spark.sql.SparkSession

object Actions {
  def main(args: Array[String]){
    val spark = SparkSession.builder().master("local[1]").appName("abc").getOrCreate()
    val sc = spark.sparkContext
    sc.setLogLevel("OFF")

    // Actions
    val rdd = sc.parallelize(List(1,2,3,4,5))
    val result2 = rdd.count()
    println(result2)
    val result3 = rdd.max()
    println(result3)
    val result4 = rdd.min()
    println(result4)
    val result5 = rdd.sum()
    println(result5)
    val result6 = rdd.mean()
    println(result6)
    
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
    
    // adding some words in the output with the rdd input
    val rdd4 = sc.parallelize(List("cone","venila","Butterscotch","chocolate"))
    rdd4.foreach(println);
    
    for (i <-rdd4){
     println(i+" is good.");
   }
    
    for (i <-rdd4){
     println(i+", " + i.length());
   }
    
    // Sample
    val x = sc.parallelize(Array(1,2,3,4,5,6,7,8,9,0,10))
    val y = x.sample(false,0.4,1)
    
    println(y.collect().mkString(", "))
    
    
  }
}