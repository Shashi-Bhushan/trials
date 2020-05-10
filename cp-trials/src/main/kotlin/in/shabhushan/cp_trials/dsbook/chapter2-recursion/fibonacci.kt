package `in`.shabhushan.cp_trials.dsbook.`chapter2-recursion`

import java.util.*

fun fibonacciSequence(
  first: Int,
  second: Int,
  limit: Int
): List<Int> = if (limit == 2) listOf(first, second) else {
  println("fibonaci of ${first} and ${second}")
  listOf(first, *fibonacciSequence(second, first + second, limit - 1).toTypedArray())
}

//fun fibonacci(
//  number: Int
//): Int = if (number == 1)

fun fibonacciStack(
  first: Int,
  second: Int,
  limit: Int
): List<Int> {
  val stack = Stack<Int>()

  stack.push(first)
  stack.push(second)

  var current = limit - 2
  var a = first
  var b = second
  var c: Int

  while (current != 0) {
    c = a + b
    stack.push(c)

    a = b
    b = c
    current = current - 1
  }

  return stack.toList()
}



