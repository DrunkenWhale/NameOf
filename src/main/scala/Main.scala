@main def main(): Unit = {
    val test = 1
    println(macroImpl.nameOf(test))
    case class Person(name: String, age: Int, gender: Boolean)
    val person = Person("114", 514, true)
    println(macroImpl.nameOf(person))
    println(macroImpl.nameOf(Person("114", 514, true)))
    val lambda = (x: Int) => x * 7
    println(macroImpl.nameOf(lambda))
}
