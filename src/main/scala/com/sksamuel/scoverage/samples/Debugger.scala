package com.sksamuel.scoverage.samples

import scala.language.experimental.macros
import scala.reflect.macros.Context

/** @author Stephen Samuel */
object Debugger {

  def debug(params: Any*) = macro debugImpl

  /**
   * Implementation of the debug macro
   */
  def debugImpl(c: Context)(params: c.Expr[Any]*) = {
    import c.universe._

    val trees = params map {
      param => (param.tree match {
        case Literal(Constant(_)) => reify {
          print(param.splice)
        }
        case _ => reify {
          val variable = c.Expr[String](Literal(Constant(show(param.tree)))).splice
          print(s"$variable = ${param.splice}")
        }
      }).tree
    }

    val separators = (1 until trees.size).map(_ => reify {
      print(", ")
    }.tree) :+ reify {
      println()
    }.tree
    val treesWithSeparators = trees zip separators flatMap {
      p => List(p._1, p._2)
    }

    c.Expr[Unit](Block(treesWithSeparators.toList, Literal(Constant(()))))
  }
}
