import org.apache.spark._
import org.apache.spark.graphx._
// To make some of the examples work we will also need RDD
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.SparkSession

object graphX3example {
  def main(args: Array[String]) {
    val spark = SparkSession.builder().master("local[1]").appName("abc").getOrCreate()
    val sc = spark.sparkContext
    sc.setLogLevel("OFF")

    // load the edges first
    val v1 = sc.parallelize(Array(
      (1L, ("Philadelphia",1580863)), //1580863L
      (2L, ("Baltimore",620961)), //620961L
      (3L, ("Harrisburg",49528)), //49528L
      (4L, ("Wilmington",70851)), //70851L
      (5L, ("New York",8175133)), //8175133L
      (6L, ("Scranton",76089))  //76089L
    ))

    val e1 = sc.parallelize(Array(
      Edge(2L, 3L, 113),
      Edge(2L, 4L, 106),
      Edge(3L, 4L, 128),
      Edge(3L, 5L, 248),
      Edge(3L, 6L, 162),
      Edge(4L, 1L, 39),
      Edge(1L, 5L, 130),
      Edge(1L, 6L, 168),
      Edge(5L, 6L, 159)
    ))

    val graph = Graph(v1, e1)
    
    // 1Q find the cities with population more than 50000?
    val cities1 = graph.vertices.filter { case (id, (_, population)) => population > 50000 }
    println("cities:")
    cities1.collect.foreach(println)
    
    
    // 2Q find the distance between the connected cities?
    
//    graph.triplets.map(triplet =>
//    triplet.srcAttr._1 + " is the " + triplet.attr + " of " + triplet.dstAttr._1)
    
    
    // 3Q find the cities, the distance between which is less than 150km
    
    val cities3 = graph.edges.filter { case Edge(_,_, distance) => distance < 150 }
    println("distance:")
    cities3.collect.foreach(println)
    
  }
  
}