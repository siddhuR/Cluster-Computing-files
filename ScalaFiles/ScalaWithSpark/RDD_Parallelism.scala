import org.apache.spark.sql.SparkSession

object RDD_Parallelism {
  def main(args: Array[String]){
   val spark = SparkSession.builder().master("local[1]").appName("abc").getOrCreate();
   val sc = spark.sparkContext
   val rdd1 = sc.parallelize(List(1,2,3,4,5))
   val rdd2 = rdd1.map(a=>a*2)
   // rdd2.saveAsTextFile("/home/siddhu/workspace/prac/Parallelize_rdd")
   
   val rdd3 = sc.textFile("")
   val rdd4 = rdd3.map(a=>a.split(","))
   println(rdd4.collect().mkString(","))
   
   // Filters
   val fill = rdd1.filter(a => a % 2 == 0)
   println(fill.collect().mkString(","))
   
   // groupBy
   val rdd5 = sc.parallelize(Array("aman","aditya","bbb","bjjj"))
   val ans = rdd5.groupBy((x=>x.charAt(0)))
   
   // reduceBy
  
}
}