package app.structures

object functional {

  def modMethod(i: Int) = i % 2 == 0

  def runFunction(callback: () => Unit) {
    callback()
  }

  val Hello = () => { println("Hi") }

  def main(args: Array[String]): Unit = {
    //anonymous functions => function literal
    val p = List.range(1, 10)
    val result = p.filter((q: Int) => q % 2 == 0)
    println(result)

    //foreach
    val z = p.foreach((i:Int) => println(i))

    //use functions as variables
    val double = (p: Int) => { p * 2 }
    println("result: ", double(10))
    println("result: ", double(20))
    val list = List.range(1, 10)
    println(list)
    val list1 = list.map(double)
    println(list1)

    //use a moethod like an anonymous function
    val list2 = list.filter(modMethod)
    println(list2)

    //callbacks
    runFunction(Hello)

    //clousures
    val isAge = (age: Int) => age >= 20
    println("age1: ", isAge(14))
    println("age2: ",isAge(22))

    //clousures
    def Result(f: Int => Boolean, x: Int) {
      println("result: ", f(x))
    }
    Result(isAge, 20)

  }

}


/*
result

List(2, 4, 6, 8)
1
2
3
4
5
6
7
8
9
(result: ,20)
(result: ,40)
List(1, 2, 3, 4, 5, 6, 7, 8, 9)
List(2, 4, 6, 8, 10, 12, 14, 16, 18)
List(2, 4, 6, 8)
Hi
(age1: ,false)
(age2: ,true)
(result: ,true)
 */