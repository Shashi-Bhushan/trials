package `in`.shabhushan.cp_trials.tree

import java.util.*


data class ExpressionNode<T>(
  val data: T,
  var left: ExpressionNode<T>? = null,
  var right: ExpressionNode<T>? = null
) {
  override fun toString(): String {
    return "ExpressionNode(data= $data )"
  }
}

object ExpressionUtil {
  private val operators = listOf('+', '-', '*', '/', '^')

  private fun Char.isOperator(): Boolean = this in operators

  fun String.toExpressionTree(): ExpressionNode<Char> = this.toCharArray().let { split ->
    Stack<ExpressionNode<Char>>().apply {
      split.forEach { character ->
        if (character.isOperator()) {
          val right = this.pop()
          val left = this.pop()

          this.push(ExpressionNode(character, left, right))
        } else {
          this.push(ExpressionNode(character))
        }
      }
    }.pop() // Only Element will be root of expression tree
  }

  fun String.solvePostfixExpression(): Int = this.toCharArray().let { split ->
    Stack<ExpressionNode<Int>>().apply {
      split.forEach { character ->
        if (character.isOperator()) {
          val right = this.pop()
          val left = this.pop()

          this.add(
            ExpressionNode(
              when (character) {
                '+' -> left.data + right.data
                '-' -> left.data - right.data
                '*' -> left.data * right.data
                '/' -> left.data / right.data
                '^' -> left.data.times(right.data)
                else -> throw IllegalArgumentException("Operation ${character} not supported")
              }
            )
          )
        } else {
          this.add(ExpressionNode(Integer.parseInt(character.toString())))
        }
      }
    }.pop().data
  }
}
