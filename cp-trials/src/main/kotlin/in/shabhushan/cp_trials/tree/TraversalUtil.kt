package `in`.shabhushan.cp_trials.tree

import java.util.*


object TraversalUtil {
  fun printPreorderIterative(node: ExpressionNode<*>?) = node?.let {
    val stack = Stack<ExpressionNode<*>>()

    stack.push(it)

    while (stack.isNotEmpty()) {
      val item = stack.pop()

      processData(item)
      if (item.right != null) stack.push(item.right)
      if (item.left != null) stack.push(item.left) // left has to be popped first, so it's going last
    }
  }

  fun printPreorderRecursive(node: ExpressionNode<*>?) {
    if (node != null) {
      processData(node)
      printPreorderRecursive(node.left)
      printPreorderRecursive(node.right)
    }
  }

  /**
   * Keep going left till you don't reach end of path
   * then pop from stack, Traverse right and keep going left
   * Do this until you don't reach end of stack
   */
  fun printInOrderIterative(node: ExpressionNode<*>) {
    val stack = Stack<ExpressionNode<*>>()

    var current: ExpressionNode<*>? = node

    while (current != null || stack.isNotEmpty()) {
      while (current != null) {
        stack.push(current)
        current = current.left
      }

      // current is null at this point
      val node = stack.pop()
      // process left node
      processData(node)

      current = node.right
    }
  }

  fun printInOrderRecursive(node: ExpressionNode<*>?) {
    if (node != null) {
      printInOrderRecursive(node.left)
      processData(node)
      printInOrderRecursive(node.right)
    }
  }

  fun printPostOrderIterative(root: ExpressionNode<*>) {
    val stack = Stack<ExpressionNode<*>>()

    var current: ExpressionNode<*>? = root

    while (current != null) {
      if (current.right != null) stack.push(current.right)
      stack.push(root)

      current = current.left
    }

    current = stack.pop()

    //if (current.right != null)
  }

  fun printPostOrderRecursive(node: ExpressionNode<*>?) {
    if (node != null) {
      printPostOrderRecursive(node.left)
      printPostOrderRecursive(node.right)
      processData(node)
    }
  }

  /**
   * From an unsorted array to a Binary Tree
   */
  fun IntArray.toBinaryTree() {
    val root = ExpressionNode(this.first())

    this.drop(1).forEach {
      val node = ExpressionNode(it)

      val current = root

      //while(current.left)
    }
  }

  private fun processData(node: ExpressionNode<*>) =
    print("${node.data} ")

}
