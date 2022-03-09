package macroImpl

import model.MethodType

import scala.quoted.*

inline def nameOf[T](inline x: T): String = $ {
  nameOfImpl('x)
}

private def nameOfImpl[T](xExpr: Expr[T])(using quotes: Quotes, tpe: Type[T]): Expr[String] = {
  import quotes.reflect.*
  val name = xExpr.asTerm match {
    case Inlined(_, _, Ident(name)) => name
  }
  Expr(name)
}



inline def methodNameTypeOf[T](inline x: T) = $ {methodNameTypeOfImpl('x)}

//private inline def methodNameTypeOfMiddle[T](inline x: T): (String, Map[String, String], String) = $ {
//  methodNameTypeOfImpl('x)
//}

private def methodNameTypeOfImpl[T](xExpr: Expr[T])(using quotes: Quotes, tpe: Type[T]): Expr[(String, Map[String, String], String)] = {
  import quotes.reflect.*
  val applyOpt = xExpr.asTerm match {
    case Inlined(_, _, x) => x match {
      case Block(k, _) => k.head match {
        case DefDef(_, _, _, opt) => opt
      }
    }
  }
  val (methodName, methodParameterNameList) = applyOpt.get match {
    case Apply(Ident(name), nameList) => (name, nameList.map {
      case Ident(name) => name
    })
  }
  val typeList = xExpr.asTerm.tpe match {
    case AppliedType(_, list) => list.map {
      case TypeRef(_, tpe) => tpe
    }
  }
  val (parameterTypeList, returnType) = typeList.splitAt(typeList.length - 1)
  val map: Map[String, String] = (methodParameterNameList zip parameterTypeList).toMap
  Expr(methodName, map, returnType.head)
}

