//numbers.scala

package app.structures

//singleton object
object numbers {

  def main(args: Array[String]): Unit = {
    //ranges of Scala's types
    //------------------------------
    println(Short.MinValue)
    println(Short.MaxValue)
    println(Int.MinValue)
    println(Int.MaxValue)
    //parsing a number form string with to methods
    println("120".toInt)
    println("121".toDouble)
    println("122".toFloat)
    println("123".toLong)
    println("124".toShort)
    println("125".toByte)
    //converting numeric types with to methods
    println(24.56.toInt)
    println(25.toFloat)
    println(26.toDouble)
    println(27.toLong)
    //overriding the default numeric type
    //f => double
    val num1 = 2f
    println(num1)
    //d => float
    val num2 = 3d
    println(num2)
    //another way
    val num3 = 4: Float
    println(num3)
    //operators ++ and -- (does not exist in scala)
    //way to do it
    var num4 = 5
    num4 += 1
    println(num4)

    var num5 = 5
    num5 -= 1
    println(num5)

    var num6 = 5
    num6 *= 2
    println(num6)

    var num7 = 5f  //f => double
    num7 /= 2
    println(num7.toDouble)

    //check presision
    //receives 2 parameters and output a boolean
    def equals(x: Double, y: Double, precision: Double) : Boolean = {
      if ((x-y).abs<precision)
        true
      else
        false
    }
    val a = 0.3
    val b = 0.5
    println(equals(a, b, 0.001))

    //large numbers
    //create a BigInt
    //------------------------------
    var num8 = BigInt(123456789)
    var num9 = BigDecimal(123456.789)
    println(num8 + " and num8 + num 9: " + num8+num9)
    println(num9)
    println(num8.isValidDouble)
    println(num9.isValidInt)

    //generating ramdonm numbers
    //------------------------------
    var ramdomNumber1 = scala.util.Random
    println(ramdomNumber1.nextInt())
    println(ramdomNumber1.nextInt)
    println(ramdomNumber1.nextDouble())
    println(ramdomNumber1.nextFloat())
    //create an object
    //------------------------------
    var ramdomNumber2 =  new scala.util.Random(100)
    //random range
    //------------------------------
    var range = 0 to ramdomNumber2.nextInt(20)
    println(ramdomNumber2.nextInt())
    println(range)

    //range, list, array of numbers
    var range1 = 1 to 10
    println(range1)
    var range2 = 1 to 10 by 2
    println(range2)
    var range3 = 1 to 10 by 3
    println(range3)

    //range in for
    for (i <- range1)
      println(i)
    for (j <- range2)
      println(j)   // output: 1,3,5,7,9
    for (j <- range3)
      println(j)   // output: 1,4,7,10

    //Array
    val ar = (1 to 5).toArray
    println(ar)

    val li = (1 to 5).toList
    println(li)

    //numbers an currency
    val pi = scala.math.Pi
    println(f"$pi%1.5f")  //3,14159
    println(f"$pi%06.2f")  //003,14

    //points an decimals
    val locale = new java.util.Locale("de", "DE")

    val formatter1 = java.text.NumberFormat.getIntegerInstance(locale)
    println(formatter1.format(334500))  // 334.500
    println(formatter1.format(76334.34))  //73.334

    val formatter2 = java.text.NumberFormat.getInstance
    println(formatter2.format(76334.34))  //73.334,34

    val formatter3 = java.text.NumberFormat.getCurrencyInstance
    println(formatter3.format(76334.34))  //73.334,34 €

  }

}
