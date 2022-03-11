import com.nameof.model.MethodType

//@main def main(): Unit = {
//  val test = 1
//  println(macroImpl.nameOf(test))
//  case class Person(name: String, age: Int, gender: Boolean)
//  val person = Person("114", 514, true)
//  println(macroImpl.nameOf(person))
//  val lambda = (x: Int) => x * 7
//
//  def m(x: Any): Unit = {
//    println(macroImpl.nameOf(x))
//  }
//
//  m(lambda)
//  println(macroImpl.nameOf(lambda))
//}

import com.nameof.model.convToMethodType
import com.nameof.macroImpl.methodNameTypeOf
import com.nameof.macroImpl.className
@main def test(): Unit = {
  def mac(a: Int, b: String, c: Long) = {
    a * b.hashCode * c
  }

  case class a(name: String)
  val text: MethodType = methodNameTypeOf(mac)
  println(text)
}


@main def test1(): Unit = {
  case class A(name: String, age: Int)
  class B {
    val name: String = "114514"
    val age: Int = 114514
  }
  println(className[B])
}