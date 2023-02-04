//strings scala
package app.structures
object strings {

  def main(args: Array[String]): Unit = {
    //variable inmutable
    val hello = "hello world"

    //length
    val l = hello.length
    println("the string is : " + hello + " and has "
              + l  + " chars")

    //concatenate
    val s = "hello"
    val h = " world"
    val c = s + h
    println("concatenate: ", c)

    //iterate
    "javier".foreach(print)
    println()

    //string as a sequence of chars
    for (c <- "javier") {
      println(c)
    }

    //string as sequence of bytes
    "javier".getBytes.foreach(println)

    //filtering a char
    val f_filter = "javier".filter(_ !='v')
    println(f_filter)

    //drop chars on the left
    "javier".drop(2).foreach(println)
    println()

    //take 3 chars n the right
    "javier".take(3).foreach(print)
    println()

    //capitalize
    "javier".capitalize.foreach(print)
    println()

    //on the left an right
    "javier".drop(1).take(3).foreach(println)
    println()

    //comparation of string
    val str1 = "hello"
    val str2 = "Hello"
    println(str1 == str2)
    println(str1.capitalize == str2)

    //multiple strings
    val str3 = """more than one string"""
    println("multiple strings: ", str3)

    //margin
    val str4 =
      """more than
      /one string""".stripMargin('/')
    println(str4)

    //stripLineEnd
    val str5 =
      """more than one string\n""".stripLineEnd
    println("finish: " + str5)

    //split
    val str6 = "hello world everybody".split(" ").
              foreach(println)

    //string interpolation
    val name = "javier"
    val age = "25"
    val size = 1.90
    println(s"my name is $name and I am $age years " +
            s"old and $size.2f tall")

    //with decimals
    println(f"my name is $name and I am $age " +
            f"years old and $size%.2f tall")

    //uppercase with MAP METHOD
    val upper1 = "hello wold".map(c => c.toUpper)
    println(upper1)

    //uppercase with FOREACH
    val upper2 = "hello wold".toUpperCase.foreach(println)

    //find patterns in strings. .r means groups of strings
    val numPattern = "[0-9]+".r
    val str7 = "number 256 in Oxford street 78"
    val match1 = numPattern.findFirstIn(str7)
    println(match1)

    //find allin in a list
    val match2 = numPattern.findAllIn(str7).toList
    println("find allin in a list: ", match2)

    //replacing patterns in a string
    val str8 = "number 256 in Oxford street 78".
          replaceAll("[0-9]", "j")
    println(str8)

    //patterns with groups
    val pattern = "([0-9]+) ([A-Za-z]+)".r
    val pattern(count, fruit) = "23 apples"
    println(count)
    println(fruit)

    //char in a string
    var char1 = "hello world".charAt(3)
    println("char in a string", char1)

  }

}
