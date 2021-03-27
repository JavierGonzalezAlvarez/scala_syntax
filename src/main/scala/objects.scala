package app.structures

object objects extends App { //(1)
  //object to refer to an instance of scala or it's a keyword

  def print_All(numbers: Int*) {
    println("the class: " + numbers.getClass)
  }

  //1. object as an instance of a class
  //print the result of using getClass
  print_All(12) //the class: class scala.collection.immutable.ArraySeq$ofInt
  print_All() //the class: class scala.collection.immutable.Nil$

  /*
    set up an app with an object:
      that means to start an app with a main method (1)
      we use... extends aApp
    */

  if (args.length == 1)
    println(s"Hi, ${args(0)}")
  else
    println("I couldn't get your name")
  //if we compile: scala object Javier => output => Hi javier

  //2. object as a keyword to create singletons or scala app
  //the aim is to ensure that the only one instance of a class exist
  //un objeto en scala define una clase y una instancia con el mismo nombre
  //a. clase e instancia con el mismo nombre
  object State {
    def sum1 { println("sum1") }
    def sum2 { println("sum2") }
  }
    State.sum1
    State.sum2

  //b
  //create a class that has an instance methods and static methods
  // House class
  class House (var tipo: String) {
    override def toString = "C is " + tipo
  }
  //the companion object
  object House {
    val C_produce1 = "produce1"
    val C_produce2 = "produce1"
    //def getFoo = "Foo"
  }
  println(House.C_produce1)  //produce1
  println(House.C_produce2)  //produce2

  //c
  //If we want to create a common code in the package object
  //in case we want to make functions, other code without requiring a class object
  //Create a package object in intellij
  //this variable is in file package, in another file => scala/package
  exit(number1)  //output => 23
  print(Margins.derecha)

  //d
  //create an object instance and not use the new keyword
  class Building {
    var name: String = _
  }
  object Building {
    //the method apply takes the parameter
    def apply(name: String): Building = {
      var pi = new Building
      pi.name = name
      pi
    }
  }
  val pi = Array(Building("A"), Building("B"))
  println(pi)

}
