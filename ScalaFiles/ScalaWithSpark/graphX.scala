import org.apache.spark._
import org.apache.spark.graphx._
// To make some of the examples work we will also need RDD
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.SparkSession

object graphX {
  def main(args: Array[String]) {
    val spark = SparkSession.builder().master("local[1]").appName("abc").getOrCreate()
    val sc = spark.sparkContext
    sc.setLogLevel("OFF")

    val v1 = sc.parallelize(Array(
      (2L, ("rxin", "stu")),
      (5L, ("franklin", "prof")),
      (3L, ("rxin", "stu")),  
      (7L, ("igonzal", "pst.doc"))  
    ))

    val e1 = sc.parallelize(Array(
      Edge(2L, 5L, "Colleague"),
      Edge(5L, 3L, "Advisor"),
      Edge(3L, 7L, "Collab"),
      Edge(5L, 7L, "Pl")
    ))

    val graph = Graph(v1, e1)
   
    // Filter vertices for professors
    val profVertices = graph.vertices.filter { case (id, (_, occupation)) => occupation == "prof" }
    val cols = graph.edges.filter{case Edge( a,b,c) => c== "Colleague"}.count()
   
   
    // Print information of professors
    println("Professors:")
    profVertices.collect.foreach(println)
  }
}