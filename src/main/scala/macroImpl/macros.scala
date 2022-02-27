package macroImpl

import scala.quoted.*

inline def nameOf[T](inline x: T) = $ {
    nameOfImpl('x)
}

private def nameOfImpl[T](xExpr: Expr[T])(using quotes: Quotes, tpe: Type[T]) = {
    import quotes.reflect.*
    val text = xExpr.asTerm match {
        case Inlined(_, _, Ident(name)) => name
    }
//    val text = xExpr.asTerm
    Expr(text.toString)
}
