//methods.scala
package app.structures
import javax.sound.sampled.{LineUnavailableException, UnsupportedAudioFileException}
import scala.io.Source

// scalar methods are public by default
//we control them in the same way as we control java

object methods {
  //private method
  //we mark with this before declaration
  private[this] def isPrivate = true

  def isPublic(x: Boolean): Unit = {
    println("isPublic:" + x)
  }
  // scalar methods are public by default
  //we control them in the same way as we control java
  println("isPrivate: " + isPrivate)
  isPublic(false)
  //
  class Casa {
    private def armarios1 {}
    //if we define protected that makes the methods available to subclases
    protected[this] def armarios2: Unit = {
      println("protected")
    }
  }
  class Chalet extends Casa {
    //armarios1  //wont' compile with private
    armarios2  //we need extends from Casa to compile with protected
  }

  //calling methods with superclasses
  //------------------------------------
  //we use "super" to refer to the parent class
  class Hi2 {
    def saludar {
      val hello = "hello world"
      println(hello)
    }
  }

  class Hi extends Hi2 {
    //implements a features in a methods of the main class with override
    override def saludar() {
      super.saludar // print=> hello world
      //saludar // print=> hello world
    }
  }

  //traits
  //--------------------------------
  //traits are like interfaces in java
  trait Animal {
    def animal = "Hi I'm an animal"
    println(animal)
  }

  trait Cat extends Animal{
    override def animal = "Hi I'm a cat"
    println(animal)
  }

  trait Dog extends Animal{
    override def animal = "Hi I'm a dog"
    println(animal)
  }

  class Puppy extends Animal with Cat with Dog {
    def printAnimal = super.animal
    def printCat = super[Cat].animal
    def printDog = super[Dog].animal
  }

  //methods with tuples
  //--------------------------------
  def stickInformation = {
    ("javier", 24, 1.90, 4.56)
  }
  //call the methods assigning values
  val (name, old, meassure, width) = stickInformation

  //methods with tuples
  //--------------------------------
  def getInfo = ("indeed", 20)
  val (value, price) = getInfo

  //methods with variable-argument fields
  //-----------------------------------------
  //if a want to have a method with a varible number of arguments
  //we use * character after the field
  def printNow(strings: String*) {
    strings.foreach(println)
  }
  //we use _* to adapt a sequence
  val chairs = List("2 legs","3 legs","4 legs")

  def printNow1(numbers: Int*) {
    numbers.foreach(println)
    //println(numbers.getClass)
  }

  //throw an exception in a method
  //-----------------------------
  //in case I want ot notice that a method twrhow a exception
  //we use @throws annotation to declare the exception(s)
  //this indicate que a method can throw a exception
  @throws(classOf[Exception])
   def getError {
    val error = "error"
  }

  @throws(classOf[Exception])
  @throws(classOf[LineUnavailableException])
  @throws(classOf[UnsupportedAudioFileException])
  def getAudio {
  }

  import java.io._
  import scala.io.Source
  class Reader(name: String) {
    //private val in = new BufferedReader(new FileReader(name))
    private val inside = new BufferedReader(new FileReader(name))
    @throws(classOf[IOException])
    //def read() = in.read()
    def read(): Unit = {
      println("buffer: " + inside.read())   //print: 116
      val lines = Source.fromFile(name)
        .getLines
        .mkString("\n")
      println("file")
      println("------")
      println(lines)  //print the content of the file
    }
  }

  //main function
  //--------------------------------------------
  def main(args: Array[String]): Unit = {
    val arm =  new Chalet  //outcome => protected. Print the method armarios2
    val salute =  new Hi //outcome => protected. Print the method armarios2

    val anim = new Puppy
    salute.saludar()
    //3 ways to call animal method
    //anim.printAnimal //=> print 3 times: "Hi, I'm a dog"
    //anim.printCat //=> print 3 times: "Hi, I'm a dog"
    anim.animal //=> print 3 times: "Hi, I'm a dog"

    println(stickInformation._1)  // print the tuple, position 0: javier
    println(stickInformation._2)  // print the tuple, position 1: 24

    println(getInfo._2) //print tuple, position 1: 20

    printNow("nacho", "javier", "carla")

    printNow(chairs: _*)

    printNow1(10, 24, 63)  //outcome => 10, 24, 63

    val file = new Reader("data/text.txt")
    file.read()
  }

}

/*
output

isPrivate: true
isPublic:false
protected
Hi I'm a dog
Hi I'm a dog
Hi I'm a dog
hello world
javier
24
20
nacho
javier
carla
2 legs
3 legs
4 legs
10
24
63
buffer: 116
file
------
testing io.source
line 2
line 3
 */