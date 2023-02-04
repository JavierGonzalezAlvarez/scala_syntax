//controls_structures
package app.structures

object controls_structures {

  def main(args: Array[String]): Unit = {

    //controls structures are similar to Java, but ...
    // a few differences
    val a = 2
    var x = if (a == 1) print ("it's if") else print ("it's else")
    println(x)

    //for : capitalize a list
    val colletion1 = List("javier", "peter", "seat")
    val p = for (n <- colletion1) yield n.capitalize
      println(p)

    //looping with for
    val array1 = Array("ship", "magazine", "hose")
    for (i <- array1)
      println(i)  //clean iteration

    //returning values from a for
    //when we want to build a new colletion form the input collection
    // we use YIELD
    val array2 = for (e <- array1) yield {
      val s = e.toUpperCase
      println(s)
    }

    //counter inside the loop fior an array
    for (i <- 0 until array1.length) {
      println(s"$i is ${array1(i)}")
    }

    //the same but with zipWithIndex
    for ((e, count) <- array1.zipWithIndex) {
      println(s"$count is $e")
    }

    //for and range with a "guard" Embedded if Statements
    for (j <- 1 to 10 if j < 8) println(j)

    //for and looping a map
    val names = Map("name" -> "javier", "lname" -> "gonzalez")
    for ((k,v) <- names)
      println(s"(key: $k, value: $v)")

    //foreach
    array1.foreach(println)
    array1.foreach(e => println(e.toUpperCase))
    array1.foreach { e =>
      val s = e.toUpperCase
      println(s)
    }

    //for and range
    1.to(5).foreach(((i) => println(i)))

    // a {value} in for, conditional if
    for {i <- 1 to 5
         if i != 1
         if i % 2 == 0
         }
      println(i)   //output: 2, 4

    //map as a for: vectors
    val p1 = 1.to(5).map(((i) => i))
    println(p1)   //output: Vector(1, 2, 3, 4, 5)

    //multiple counters
    for (i <- 1 to 3; j <- 1 to 2) println(s"i = $i, j = $j")

    for {
      i <- 1 to 2
      j <- 2 to 3
    } println(s"i = $i, j = $j")
    /*
     output
      i = 1, j = 1
      i = 1, j = 2
      i = 2, j = 1
      i = 2, j = 2
      i = 3, j = 1
      i = 3, j = 2
      i = 1, j = 2
      i = 1, j = 3
      i = 2, j = 2
      i = 2, j = 3
    */

    //even numbers with guards Embedded if Statements
    for (i <- 1 to 10 if i % 2 == 0) println(i)

    //match expresion
    val i: Int = 2
    i match {
      case 1 => println("January")
      case 2 => println("February")
      case 3 => println("March")
      case 4 => println("April")
      case 5 => println("May")
      case 6 => println("June")
      case 7 => println("July")
      case 8 => println("August")
      case 9 => println("September")
      case 10 => println("October")
      case 11 => println("November")
      case 12 => println("December")
      case whoa => println("Unexpected case: " + whoa.toString)
    }

    val j: Int = 4
    j match {
      case 1 => println(1)
      case 2 => println(2)
      case 3 => println(3)
      case _ => println("otro")

    }

    //map working as a match
    val monthNumberToName = Map(
      1 -> "January",
      2 -> "February",
      3 -> "March",
      4 -> "April",
      5 -> "May",
      6 -> "June",
      7 -> "July",
      8 -> "August",
      9 -> "September",
      10 -> "October",
      11 -> "November",
      12 -> "December"
    )
    val monthName = monthNumberToName(7)
    println(monthName) // prints "July"

    //to assign a match to a variable
    val Number: Int = 4
    val evenOrOdd = Number match {
      case 1 | 3 | 5 | 7 | 9 => println("odd")
      case 2 | 4 | 6 | 8 | 10 => println("even")
    }

    //some an any in match expressions
    def toInt(s: String): Option[Int] = {
      try {
        Some(Integer.parseInt(s.trim))
      } catch {
        case e: Exception => None
      }
    }

    toInt("w2") match {
      case Some(i) => println(i)
      case None => println("It's not an Integer")
    }

    //match expresions and Guard (if statement)
    val number1: Int = 2
    number1 match {
      case x if x == 1 => println("one")
      case x if (x == 2 || x == 3) => println(x)
      case _ => println("other value")
    }

    //try catch finnaly => similar to Java
    //print the error
    val s = "hello"
    try {
      val pp = s.toInt
    } catch {
      case e: Exception => e.printStackTrace
    }

    // while loop execution
    //must be inmutable
    var a1 = 1
    while ({a1 < 5}) {
      println("a1 is: " + a1)
      a1 = a1 + 1
    }

    // do loop execution
    var a2 = 1;
    do {
      println( "a2 is: " + a2 );
      a2 = a2 + 1;
    }
    while(a2 < 5)

  }

}
