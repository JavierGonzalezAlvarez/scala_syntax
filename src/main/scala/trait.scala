package app.structures

object traitExample {
  trait Dog {
    var legs: Int
    def speak(whatToSay: String)
    def canWalk(enabled: Boolean)
  }

  trait PizzaTrait {
    var numToppings: Int
    var size = 14
    val maxNumToppings = 10
  }

  trait Pet {
    def jump {
      println("I can jump")
    }

    def comeHere
  }

  class DogExample extends Dog {
    def speak(whatToSay: String): Unit = {
      println(whatToSay)
    }
    override def canWalk(enabled: Boolean): Unit = {
      println(enabled)
    }
    var legs: Int = 4
  }

  class Pizza extends PizzaTrait {
    //no need override in numToppings
    var numToppings = 0
    size = 16
    override val maxNumToppings = 10
  }

  class Cat extends Pet {
    // we don't need to implement 'jump' if you don't need to
    def comeHere {
      println("Fetch the ball to the pet")
    }
  }
  abstract class FlyPet extends Pet {
    def fly {
      println("I can fly")
    }
  }
  def main(args: Array[String]): Unit = {
    val dog = new DogExample
    dog.speak("guau1")
    println("legs: ", dog.legs)
    dog.legs=2
    println("legs: ", dog.legs)
    dog.speak(("guau2"))
    dog.canWalk(true)
    dog.canWalk(false)

    //concrete fiedds in traits
    val pizza = new Pizza
    println(pizza.maxNumToppings == 12)
    println(pizza.numToppings == 12)

    //use a trait an abstract class
    val animal = new FlyPet  {
      override def comeHere: Unit = ???
    }
    animal.fly
    animal.jump

  }

}

/*
result

guau1
(legs: ,4)
(legs: ,2)
guau2
true
false
false
false
I can fly
I can jump
 */