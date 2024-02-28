import org.apache.spark.sql.SparkSession

object OlympicDataset {
  def main(args: Array[String]){
    
    val spark = SparkSession.builder().master("local[1]").appName("abc").getOrCreate()
    val sc = spark.sparkContext
    import spark.implicits
    sc.setLogLevel("OFF")
    
    val df = spark.read.format("csv").option("header","true").option("inferSchema","true").load("/home/siddhu/workspace/Input_Files/archive/athlete_events.csv")
    
    println(df.head())
    
    df.show()
    df.printSchema()
    df.select("Games").show()
    
    df.select("City").filter("Year == 2016").show()
    
  }
}