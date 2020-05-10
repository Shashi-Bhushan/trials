package `in`.shabhushan.cp_trials.tree

import `in`.shabhushan.cp_trials.tree.ExpressionUtil.solvePostfixExpression
import `in`.shabhushan.cp_trials.tree.ExpressionUtil.toExpressionTree
import `in`.shabhushan.cp_trials.tree.TraversalUtil.printInOrderIterative
import `in`.shabhushan.cp_trials.tree.TraversalUtil.printInOrderRecursive
import `in`.shabhushan.cp_trials.tree.TraversalUtil.printPostOrderIterative
import `in`.shabhushan.cp_trials.tree.TraversalUtil.printPostOrderRecursive
import `in`.shabhushan.cp_trials.tree.TraversalUtil.printPreorderIterative
import `in`.shabhushan.cp_trials.tree.TraversalUtil.printPreorderRecursive
import kotlin.test.Test

class ExpressionTreeTest {
  companion object {
    const val postOrderString = "359+2*-"
    val expressionRoot = postOrderString.toExpressionTree()

    const val postOrderAlphabetString = "ab+ef*g*-"
    val alphabetExpressionRoot = postOrderAlphabetString.toExpressionTree()
  }

  @Test
  fun testExpressionTree() {
    println("\nIterative Pre order Print solution is ")
    printPreorderIterative(expressionRoot)

    println("\nRecursive Pre order Print solution is ")
    printPreorderRecursive(expressionRoot)

    println("\nIterative In order Print solution is ")
    printInOrderIterative(expressionRoot)

    println("\nRecursive In order Print solution is ")
    printInOrderRecursive(expressionRoot)

    println("\nIterative Post order Print solution is ")
    printPostOrderRecursive(expressionRoot)

    println("\nRecursive Post order Print solution is ")
    printPostOrderIterative(expressionRoot)

    println("\nSolution for the expression is ${postOrderString.solvePostfixExpression()}")
  }
}
