package `in`.shabhushan.cp_trials.dsbook.`chapter4-stack`

import `in`.shabhushan.cp_trials.dsbook.`chapter3-linkedlist`.CustomLinkedList
import java.util.*
import kotlin.math.max
import kotlin.math.min

abstract class CustomStack<T> {
  //////////////////
  // Main Operations
  //////////////////

  /**
   * Inserts data into stack
   */
  abstract fun push(data: T)

  /**
   * Removes and return the last inserted element from the stack
   * @throws IllegalStateException if stack is empty
   */
  abstract fun pop(): T

  ///////////////////////
  // Auxiliary Operations
  ///////////////////////

  /**
   * Return the last inserted element without removing it
   * @throws IllegalStateException if stack is empty
   */
  abstract fun peek(): T

  /**
   * Returns the number of elements stored in the stack
   */
  abstract fun size(): Int

  /**
   * Indicates whether any elements are stored in the stack or not
   */
  abstract fun isEmpty(): Boolean

  /**
   * Indicates whether the stack is full or not
   */
  abstract fun isFull(): Boolean
}

class ArrayBackedCustomStack<T> public constructor(capacity: Int) : CustomStack<T>() {

  var array: Array<Any?> = Array(capacity) {}
  var top: Int = -1


  override fun push(data: T) {
    top++
    ensureCapacity()
    array[top] = data
  }

  override fun pop(): T {
    val item = array[top]

    top--
    return item as T
  }

  override fun peek(): T = array[top] as T

  override fun size(): Int = array.size

  override fun isEmpty(): Boolean = top == -1

  override fun isFull(): Boolean = top + 1 == size()

  private fun ensureCapacity() {
    if (isFull()) {
      // TODO: Finish Scope
    }
  }
}

class ListBackedCustomStack<T> public constructor(capacity: Int) : CustomStack<T>() {

  var list = CustomLinkedList<T>()
  private var top: Int = -1

  override fun push(data: T) {
    top++
    ensureCapacity()
    list.pushToFront(data)
  }

  override fun pop(): T = list.removeFromFront() ?.let {
    top--

    it.data
  } ?: throw IllegalAccessException("err-empty-stack")

  override fun peek(): T = list.peek() ?.let {
    top--

    it.data
  } ?: throw IllegalAccessException("err-empty-stack")

  override fun size(): Int = list.length

  override fun isEmpty(): Boolean = top == -1

  override fun isFull(): Boolean = top + 1 == size()

  private fun ensureCapacity() {
    if (isFull()) {
      // TODO: Finish Scope
    }
  }
}

class MinStackUtil(val stack: ArrayBackedCustomStack<Int> = ArrayBackedCustomStack(4)) {
  val minStack = ArrayBackedCustomStack<Int>(stack.array.size)

  fun push(n: Int) {
    if (stack.isEmpty() || minStack.peek() > n) {
      minStack.push(n)
    }  else {
      minStack.push(minStack.peek())
    }

    stack.push(n)
  }

  fun pop(): Int = stack.pop().also {
    minStack.pop()
  }

  fun peek(): Int = stack.peek()

  fun getMinimum() = minStack.peek()
}

class SpaceEfficientMinStackUtil(val stack: ArrayBackedCustomStack<Int> = ArrayBackedCustomStack(4)) {
  val minStack = ArrayBackedCustomStack<Int>(stack.array.size)

  // Don't push EVERY TIME, only when less than equal
  fun push(n: Int) {
    if (stack.isEmpty() || minStack.peek() >= n) {
      minStack.push(n)
    }

    stack.push(n)
  }

  fun pop(): Int = stack.pop().also {
    // If minStack top value is equal to what's in the Top of stack, pop this from min stack as well
    if (it == minStack.peek())
      minStack.pop()
  }

  fun peek(): Int = stack.peek()

  fun getMinimum() = minStack.peek()
}

object StackUtil {

  // Given a closing bracket, give it's opening bracket
  private val closingToOpening = mapOf(
    ')' to '(',
    '}' to '{',
    ']' to '['
  )

  private val validOpeningBrackets = setOf('(', '{', '[')
  private val validBrackets = setOf(')', '}', ']')

  /**
   * Returns true if symbols are balanced
   */
  fun isBalanced(
    expression: String,
    stack: CustomStack<Char> = ArrayBackedCustomStack(4)
  ) = expression.all {
    when (it) {
        in closingToOpening.values -> {
          stack.push(it)
          true
        }
        in closingToOpening.keys -> {
          if (stack.isEmpty())
            false
          else
            closingToOpening[it] == stack.pop()
        }
        else -> {
          true
        }
    }
  }

  fun isBalanced(
    expression: String,
    stack: Stack<Char>
  ) = expression.all {
    when (it) {
      in closingToOpening.values -> {
        stack.push(it)
        true
      }
      in closingToOpening.keys -> {
        if (stack.isEmpty())
          false
        else
          closingToOpening[it] == stack.pop()
      }
      else -> {
        true
      }
    }
  }

  fun isValidStackOperation(
    operations: String
  ): Boolean {
    val stack = Stack<Char>()

    operations.forEach {
      if (it == 'S')
        stack.push('S')
      else {
        if (stack.isEmpty())
          return false
        else
          stack.pop()
      }
    }

    return true
  }

  /**
   * https://leetcode.com/problems/online-stock-span/
   */
  fun span(
    array: Array<Int>
  ): Array<Int> = Array(array.size) { 0 }.let { spans ->
    val stack = Stack<Int>()

    array.indices.forEach { index ->
      // stack is not empty and current value is more than top value in stack
      while (stack.isNotEmpty() && array[index] > array[stack.peek()])
        stack.pop()

      val p = if (stack.isEmpty()) -1 else stack.peek()

      spans[index] = index - p
      stack.push(index)
    }

    spans
  }

  fun largestRectangleInHistogram(
    array: Array<Int>
  ): Int {
    var maxArea = 0
    array.indices.forEach { i ->
      var minHeight = Integer.MAX_VALUE
      (i until array.size).forEach { j ->
        minHeight = min(minHeight, array[j])
        maxArea = max(maxArea, (j - i + 1) * minHeight)
      }
    }

    return maxArea
  }
}
