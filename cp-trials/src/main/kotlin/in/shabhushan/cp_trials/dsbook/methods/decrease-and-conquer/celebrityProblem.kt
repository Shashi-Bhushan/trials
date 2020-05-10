package `in`.shabhushan.cp_trials.dsbook.methods.`decrease-and-conquer`

import java.util.Stack

fun isCelebrity(
  matrix: Array<Array<Int>>
): Int {
  val stack = Stack<Int>()

  matrix.indices.forEach { index ->
    stack.push(index)
  }

  while (stack.size != 1) {
    val a = stack.pop()
    val b = stack.pop()

    // if A knows B, A is not the celebrity
    if (matrix[a][b] == 1) {
      stack.push(b)
    } else {
      stack.push(a)
    }
  }

  // Only one left at this point
  val celebrity = stack.pop()

  matrix.indices.forEach { personIndex ->
    // if celebrity knows the person or person doesn't know celebrity
    if (personIndex != celebrity && (matrix[celebrity][personIndex] == 1 || matrix[personIndex][celebrity] == 0))
      return -1
  }

  return celebrity
}
