import org.apache.spark.sql.SparkSession

object ca03042024 {
  def main(args: Array[String]){
    val spark = SparkSession.builder().master("local[1]").appName("abc").getOrCreate()
    val sc = spark.sparkContext
    sc.setLogLevel("OFF")
    
    
    // 1.1
    val col = Seq(2, 4, 6, 8, 10)
    val r1 = spark.sparkContext.parallelize(col)
    println(r1.sum())
    
    // 1.2
    val col1 = Array(1, 2, 3, 4, 5, 6, 7, 8, 9)
    println(col1.min)
    println(col1.max)
	  println(col1.max)  // highest
    println(col1.head)
    
    // 1.3
    val r3 = sc.parallelize(Array(1, 1, 2, 2, 3, 3, 4, 4, 5, 5))
    println(r3.map(f => f))
    println(r3.flatMap(f => f.toString))
    
    // 1.4
    val col4 = Array(3, 4, 5, 9, 8, 12)
    val r4 = spark.sparkContext.parallelize(col4)
    println(r4.filter(x => x % 2 == 0).collect())
    
    // 1.5
    val col5 = Seq("Gnu", "Rat", "Dog", "Gnu", "Rat")
    println(col5.distinct)
       
    // 2nd question
    
    val df = spark.read.option("header", "true").csv("/home/siddhu/ipl.csv")
    //df.show()
    
    // 2.1
    println(df.count())
    
    // 2.2
    df.groupBy("winner").count().show()
    
    // 2.3
    val ds = df.filter("method == 'D/L'")
    ds.groupBy("winner").count().show()
    
    // 2.4
    val margin = df.selectExpr("winner").groupBy("winner")
    //margin.show()
    
    // 2.6
    println(df.groupBy("player_of_match").count().first())
}
}


















//import org.apache.spark.sql.SparkSession
//
//object ca03042024 {
//  
//    def main(args: Array[String]){
//    val spark = SparkSession.builder().master("local[1]").appName("abc").getOrCreate()
//    val sc = spark.sparkContext
//    sc.setLogLevel("OFF")
//    
//    // 1.1
//    val col = Seq(2,4,6,8,10)
//    val r1 = spark.sparkContext.parallelize(col)
//    val sum = r1.sum()
//    
//    // 1.2
//    val col1 = Array(1,2,3,4,5,6,7,8,9)
//    col1.min
//    col1.max
//    
//    //1.3
//    val r3 = sc.parallelize(Array(1,1,2,2,3,3,4,4,5,5))
//    //r3.
//    val map = r3.map(f => f)
//    val fmap = r3.flatMap(f=>.split(","))
//    
//    
//    // 1.4
//    val col4 = Array(1,1,2,2,3,3,4,4,5,5)
//    val r4 = spark.sparkContext.parallelize(col)
//    
//    // 1.5
//    val  col5 = Seq("Gnu", "Rat", "Dog", "Gnu", "Rat")
//    col5.distinct
//    
//    
//    // 2nd question
//    
//    val df = spark.read.csv("/home/siddhu/ipl.csv")
//    df.show()
//    
//    //2.1
//    df.count()
//    
//    //2.2
//    
//    val a = sparkContest.flatMap(df)
//    
//    //2.3
//    
//    df.winner.count()
//    val mapw = df.map(winner => winner)
//    
//    
//    
//  
//    
//    
//    
//  }
//}