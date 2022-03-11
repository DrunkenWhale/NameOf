package com.nameof.model

final case class MethodType(methodName: String, parameterNameToTypeList: Map[String, String], returnType: String)

given convToMethodType: Conversion[(String, Map[String, String], String), MethodType] = MethodType(_, _, _)
