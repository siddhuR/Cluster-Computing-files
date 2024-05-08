import org.apache.spark._
import org.apache.spark.graphx._
// To make some of the examples work we will also need RDD
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.SparkSession

object graphX2 {
  def main(args: Array[String]) {
    val spark = SparkSession.builder().master("local[1]").appName("abc").getOrCreate()
    val sc = spark.sparkContext
    sc.setLogLevel("OFF")

    // load the edges first
    val graph = GraphLoader.edgeListFile(sc, "/home/siddhu/workspace/Input_Files/com-youtube.ungraph.txt")

    graph.numEdges
    println("NumOfEdges:",graph)

// number of iterations as the argument
val staticPageRank = graph.staticPageRank(10)
staticPageRank.vertices.collect()

val pageRank = graph.pageRank(0.001).vertices

//print top 5 items from result
println(pageRank.top(5).mkString("\n"))
   
    
  }
}