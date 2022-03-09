import model.MethodType

@main def main(): Unit = {
  val test = 1
  println(macroImpl.nameOf(test))
  case class Person(name: String, age: Int, gender: Boolean)
  val person = Person("114", 514, true)
  println(macroImpl.nameOf(person))
  val lambda = (x: Int) => x * 7

  def m(x: Any): Unit = {
    println(macroImpl.nameOf(x))
  }

  m(lambda)
  println(macroImpl.nameOf(lambda))
}

@main def test(): Unit = {
  import model.convToMethodType
  def mac(a: Int, b: String, c: Long) = {
    a * b.hashCode * c
  }

  case class a(name:String)
  val text :MethodType= macroImpl.methodNameTypeOf(mac)
  println(text)
}