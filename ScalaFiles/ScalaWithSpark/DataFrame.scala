import org.apache.spark.sql.SparkSession

object DataFrame {
    def main(args: Array[String]){
    val spark = SparkSession.builder().master("local[1]").appName("abc").getOrCreate()
    val sc = spark.sparkContext
    sc.setLogLevel("OFF")

   // Question1
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
    
    // DataFrame
    
    val rdd1 = sc.parallelize(Array(("a",1),("a",2),("b",3)))
    // rdd1.toDF()  // to convert the data into dataframe.
    // val rdd2  = rdd1.toDF()
    // rdd2.show()
    // rdd2.printSchema()
    
    
    
   
    
    
    
  }
}