import org.apache.spark.sql.SparkSession

object ques10k_dataset {
  def main(args: Array[String]){
    
    val spark = SparkSession.builder().master("local[1]").appName("abc").getOrCreate()
    val sc = spark.sparkContext
    import spark.implicits
    sc.setLogLevel("OFF")
    
    val df = spark.read.format("csv").option("header","true").option("inferSchema","true").load("/home/siddhu/workspace/Input_Files/ques10k.csv")
    
    println(df.head())
    
    df.show()
    df.printSchema()
    
    df.select("Id", "Tag").show()
    
    df.select("Id","Tag").filter("tag = 'css'").show()
    
    //df.select("Tag").
    println(f"Number of php tags = ${df.select("Tag").filter("tag = 'php'").count()}")
    
    df.select("Tag").filter("tag LIKE 'c%'").show()
    
    
    
    
  }
  
}