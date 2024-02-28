object PracQues {
  def main(args: Array[String]){
    
    val a = "coursecodeINT315";
    println(a.reverse.toUpperCase())
    
    // print 8th charecter from a
    println(a.charAt(8));
    
    // take input and print it
    val b = readLine("What is your favourite movie of all time?")
    println(b)
    
    // create list with the items 0, 10, 20, 47, -2, 99, -98 and print smallest and largest numeric
    val c = List(0, 10, 20, 47, -2, 99, -98)
    println(c.max)
    println(c.min)
    
    // calculate the total cost for the customer who is buying 10 Dlazed donuts. You can assume that the price of each donut item is at $2.50. Notice the format of the  $25.00 total cost literal, which is essentially at 2 decimal places. OUTPUT: Total cost of 10 Glazed Donuts = $25.00
    
    println(f"Total cost of 10 Glazed Donuts = ${2.5*10}%.2f")
    
    // To parse the corresponding value from the literal vanilla donut is a particular donut, the 10 literal is the quantity purchased,
    val d = "Vanilla donut 10 2.25"
    
    println("Donut Name: " )
    
    
    
  }
}