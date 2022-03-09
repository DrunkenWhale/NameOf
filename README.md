# NameOf

use `macroImpl.nameOf[T](x:T)` to get val name

ps: __this method support param you define val / var__

```scala

val ac = 1
println(nameOf(ac)) // print "ac" in console
val ab = (x:Int)=>x*7
println(nameOf(ab))  // "ab"

```