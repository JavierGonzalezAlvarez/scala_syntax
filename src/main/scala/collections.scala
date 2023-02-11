package app.structures

object collections {

  def main(args: Array[String]): Unit = {

    //predicate: get values and returns a boolean
    def isEven (i: Int) = if (i % 4 == 0) true else false
    println(isEven(4))

    val list = List.range(1, 10)
    println(list)

    val cal = list.filter(_ % 2 == 0)
    println(cal)

    //using vectors
    //Traversable -> Iterable -> seq(IndexedSeq/LinearSeq)/Set/Map
    val v = Vector(1, 20, 3, 87, 2)
    println(v.sum)
    println(v.filter(_ > 5))
    println(v.map(_ * 2))

    println("-----------------------------------------------")
    //IndexedSeq create an Vector indexed
    val x = IndexedSeq(1,2,3,4,10)
    println("indexing", x)

    //LinearSeq creates a List
    val seq = scala.collection.immutable.LinearSeq(1,2,3,4,12)
    println(seq)

    //Map creating an inmutable map -> Map
    val m1 = Map(1 -> "a", 2 -> "b")
    println("map", m1)

    //Map creating a mutable map -> HashMap
    val m2 = collection.mutable.Map(1 -> "a", 2 -> "b")
    println(m2)

    //Set is a collection of unique elements
    //Set -> BitSet/HasSet/listSet/SortedSet(TreeSet)
    //Set
    val set = Set(1, 2, 3, 12)
    println(set)

    //a mutable set -> HashSet
    val s = collection.mutable.Set(1, 2, 3)
    println(s)

    //choosing a scala collection
    /*
    Sequence
    Map
    Set
     */

    /*
    -Sequence: is a linear collection of elements and may be indexed or linear (a linked list).
    -A map contains a collection of key / value pairs.
    -Set is a collection that contains no duplicate elements
     */

    println("-----------------------------------------------")
    var v1 = Vector[Int]()
    for (i <- 1 to 10) v1 = v1 :+ i
    println(v1)
    println("print first element", v1.head)
    println("produce a new sequence except first element", v1.tail)
    println("indexing, show position i (5)", v1.apply((5)))
    //println("print first element", v1.update("123"))
    println("add an element to the fornt of the sequence", v1.prepended(55))
    println("add an elment at the end of the sequence", v1.appended(87))
    println("print i element", v1.toIndexedSeq(4))

    println("-----------------------------------------------")
    //declaring type when create a collection
    val x1 = List(1, 2.0, 33D, 400L)
    println("type1", x1)
    val x2: List[Double] = List(1.0, 2.0, 33.0, 400.0)
    println("type2", x2)
    val x3 = List[AnyVal](1, 2.0, 33D, 400L)
    println("type3", x3)

    println("-----------------------------------------------")
    trait Animal
    trait FurryAnimal extends Animal
    case class Dog(name: String) extends Animal
    case class Cat(name: String) extends Animal
    //create a sequence of dogs and cats
    val x4 = Array(Dog("Fido1"), Cat("Felix1"))
    println("length",x4.length)
    println("first element",x4(0))

    val x5 = Array[Animal](Dog("Fido2"), Cat("Felix2"))
    println("second element",x5(1))
    //clone an array
    val x6 = x5.clone()
    println("one element", x6(1))
    //convert to a list
    println("convert to a list", x6.toList)

  }

}

/*
output:

true
List(1, 2, 3, 4, 5, 6, 7, 8, 9)
List(2, 4, 6, 8)
113
Vector(20, 87)
Vector(2, 40, 6, 174, 4)
-----------------------------------------------
(indexing,Vector(1, 2, 3, 4, 10))
List(1, 2, 3, 4, 12)
(map,Map(1 -> a, 2 -> b))
HashMap(1 -> a, 2 -> b)
Set(1, 2, 3, 12)
HashSet(1, 2, 3)
-----------------------------------------------
Vector(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
(print first element,1)
(produce a new sequence except first element,Vector(2, 3, 4, 5, 6, 7, 8, 9, 10))
(indexing, show position i (5),6)
(add an element to the fornt of the sequence,Vector(55, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10))
(add an elment at the end of the sequence,Vector(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 87))
(print i element,5)
-----------------------------------------------
(type1,List(1.0, 2.0, 33.0, 400.0))
(type2,List(1.0, 2.0, 33.0, 400.0))
(type3,List(1, 2.0, 33.0, 400))
-----------------------------------------------
(length,2)
(first element,Dog(Fido1))
(second element,Cat(Felix2))
(one element,Cat(Felix2))
(convert to a list,List(Dog(Fido2), Cat(Felix2)))
 */