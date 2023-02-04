//objects.scala

package app

package object structures {
  val number1 = 23
  //create a method
  def exit(a: Any) {
    println(a)
  }
  // enumeration
  object Margins extends Enumeration {
    type Margins = Value
    val arriba, abajo, izquierda, derecha = Value
  }

}
