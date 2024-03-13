import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._


object sparkSQL {
  def main(args: Array[String]){
    
    val spark = SparkSession.builder().master("local[1]").appName("abc").getOrCreate()
    val sc = spark.sparkContext
    import spark.implicits
    sc.setLogLevel("OFF")
    
    val df = spark.read.format("csv").option("header","true").option("inferSchema","true").load("/home/siddhu/workspace/Input_Files/ques10k.csv")
    
    df.createOrReplaceTempView("mytable")  // Creating temp table
//    spark.catalog.listTables.show()
//    
//    spark.sql("show tables").show()
//    
//    // print id and tag
//    df.select("id","tag").show()  // spark api method
//    spark.sql("SELECT id, tag FROM mytable").show  // spark SQL method
//    
//    // Find all the rows where tag column has value of css
//    
//    spark.sql("SELECT * FROM mytable WHERE tag=='css'").show  // spark SQL method
//    
//    // Count the number of php tags in dataframe:  Number of php tags =<num>
//    
//    spark.sql("SELECT count(tag) FROM mytable WHERE tag=='php'").show  // spark SQL method
//    
//    // Find all tags whose values start with c
//    
//    spark.sql("SELECT tag FROM mytable WHERE tag LIKE 'c%'").show  // spark SQL method
//    
//    // Find all tags whose value start with letter d and then only pick id 1 or 4
//    
//    spark.sql("SELECT tag FROM mytable WHERE tag LIKE 'd%' AND (id ==1 OR id == 4) ").show  // spark SQL method
//    
//    spark.sql("SELECT tag FROM mytable WHERE tag LIKE 'd%' AND id IN (1,4) ").show  // spark SQL method 2
//    
//    // find all tags whose id's are equal to (4,6)
//    
//    spark.sql("SELECT tag FROM mytable WHERE (id ==4 OR id == 6) ").show  // spark SQL method
//    
//    // findout how many rows match each tag in our dataframe 
//    
//    spark.sql("SELECT tag, count(*) AS TC FROM mytable GROUP BY tag ").show  // spark SQL method
//    
//    spark.sql("SELECT tag,count(*) AS TC FROM mytable HAVING tag>3 ").show  // spark SQL method
//    
    // JOINS for orders.csv and customers .csv
    
    val df1 = spark.read.format("csv").option("header","true").option("inferSchema","true").load("/home/siddhu/workspace/Input_Files/orders.csv")
    val df2 = spark.read.format("csv").option("header","true").option("inferSchema","true").load("/home/siddhu/workspace/Input_Files/customers.csv")
    
    df1.show()
    df2.show()
    
    df1.createOrReplaceTempView("orders")
    df2.createOrReplaceTempView("customers")
    
    val DF = spark.sql("SELECT o.order_id, o.amount, o.customer_id, c.first_name FROM orders o INNER JOIN customers c ON o.customer_id = c.customer_id")
    DF.show()
    
  
  }
}