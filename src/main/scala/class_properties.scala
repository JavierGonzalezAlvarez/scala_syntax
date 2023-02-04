//class_properties
package app.structures
object class_properties {

  def main(args: Array[String]): Unit = {
  //constructor
  //-----------------------------------------------
    class Tables1(var name: String, var features: String) {
      println("starts the constructor")
      // some class fields
      private val Dir = System.getProperty("user.home")
      //varibale mutable
      var origin = "Spain"
      //method 1
      override def toString = s"$name has $features and is from $origin"
      //method 2
      def printDir { println(s"HOME = $Dir") }
      //method 3
      def printName { println(this) } // uses toString
      printDir
      printName
      println("we are still in the constructor")
    }
    val table1 = new Tables1("SoftTable", "4 legs")
    println(table1.name)
    println(table1.features)

    //control de visibility of the constructor fields
    //-----------------------------------------------
    /*
    if you want to control the visibility of the fields in a class
    1. if the varibale is declared var, scala generate setters and getters
    2. if the variable is declared val scala only generate getters
    3. if doesn't have variables, neither setters nor getters
    4. val and var can be modified with private keyword
     */
    //constructor
    class Tables2(var name: String, var features: String) {
    }
    val table2 = new Tables2("HardTable", "8 legs")
    //getter
    println(table2.name)
    //setter
    table2.features = "12 legs"
    println(table2.features)

    //constructor private
    //-----------------------------------------------
    class Tables3 private (var name: String, var features: String) {
      override def toString = "manin constructor"
      println(name)
    }
    //it is private, no accesible
    //val table3 = new Tables3("HardTable", "8 legs")
    //a way to access
    object Tables3 {
      val table = new Tables3 ("Table3", "8 legs")
      def getInstance = table
    }
    /*
    singleton object: they are methods and values not associated
    with an instance of a class
    we denote then with "object" keyword
    In the example table 3 is available in all the app
     */
    object Singlenton1 {
      val table3 = Tables3.getInstance
    }
    //we can use the object in all the app
    println(Singlenton1.table3)
    println(Singlenton1.table3.name)

    //not generate getters and setters
    //-----------------------------------------------
    class Animal {
      //generate setters and getters
      var legs = 4: Int
      //field hidden form others classes
      private var ears: Int = _
      //method to control the private var
      def ears1  {
        ears = 2
        println(ears)
      }
    }
    object See {
      val a1 = new Animal
      val p1 = a1.legs
      val p2 = a1.ears1
      //println(a1.ears) // => gives error, cos it's private
    }
    println(See.p1)
    See.p2

    //assign a field to a block or function
    //-----------------------------------------------
    import scala.io.Source
    class Value {
      val text = {
        var line1 = ""
        //try catch
        try {
          line1 = Source.fromFile("data/text.txt")
            .getLines
            .mkString("\n")
        } catch {
          case e: Exception => line1 = "Error"
        }
        line1
      }
      println(text)
    }
    object Rep {
      val f = new Value
    }
    Rep.f

    //extending class
    //-----------------------------------------------
    class Animal1 (var name: String) {
      val legs = 2: Int
    }
    //we must indicate the fields of the main class
    class Bird1 (name: String, var category: String) extends Animal1 (name) {
      val wings = 2
    }
    val bird2 = new Bird1 ("blue", "dove")
    println("wings: " + bird2.wings)
    println("legs: " + bird2.legs)
    println("name: " + bird2.name.capitalize)
    println("category: " + bird2.category.toUpperCase())

    //superclass constructor
    //-----------------------------------------------
    //1º constuctors
    class Animal2 (var name: String, var legs: Int) {
      // 2º constructor
      def this(name: String) {
        this(name, 0)
      }
    }
    //we must indicate the fields of the main class
    class Dog (name: String, legs: Int, category: String) extends Animal2 (name) {
      //auxiliary constructor
      def this (name: String) {
        this(name, 0, null)
      }
      //auxiliary constructor
      def this (name: String, legs: Int) {
        this(name, 4, null)
      }
      //auxiliary constructor
      def this (name: String, category: String) {
        this(name, 0, category)
      }
    }

    //1º auxiliary
    val dog1 = new Dog ("blue")
    println("name: " + dog1.name)
    //2º auxiliary
    val dog2 = new Dog ("red", 4)
    println("name: " + dog2.name)
    //3º auxiliary
    val dog3 = new Dog ("yellow", "par")
    println("legs: " + dog3.legs)  // output => legs: 0

    //abstract class
    //-----------------------------------------------
    /*
    scala has traits which are more flexible than an abstract class
    we use abstract class:
    - we want to create a base class with a constructor
    - the code will be called from java
     */
    //trait Animal2(name: String)
    abstract class Animal3 (name: String) {
      val greeting: String
      val age: Int
      def tellMeAge { println(greeting + " " + name + ", you are : " + age) }
    }
    class Horse (name: String) extends Animal3 (name) {
      val greeting = "hi horse"
      val age = 12
    }
    class Mouse (name: String) extends Animal3 (name) {
      val greeting = "hi mouse"
      val age = 5
    }
    val animal4 =  new Horse("Peter")
    animal4.tellMeAge // output => hi horse Peter, you are 12

  }
}

