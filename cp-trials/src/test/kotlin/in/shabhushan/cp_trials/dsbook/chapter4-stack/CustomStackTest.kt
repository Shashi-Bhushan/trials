package `in`.shabhushan.cp_trials.dsbook.`chapter4-stack`

import `in`.shabhushan.cp_trials.dsbook.`chapter4-stack`.StackUtil.isBalanced
import `in`.shabhushan.cp_trials.dsbook.`chapter4-stack`.StackUtil.isValidStackOperation
import `in`.shabhushan.cp_trials.dsbook.`chapter4-stack`.StackUtil.largestRectangleInHistogram
import `in`.shabhushan.cp_trials.dsbook.`chapter4-stack`.StackUtil.span
import org.junit.Assert.assertArrayEquals
import java.util.*
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class CustomStackTest {
  @Test
  fun testCustomStack() {
    val stack = ArrayBackedCustomStack<Int>(4)

    stack.push(4)
    stack.push(3)

    assertArrayEquals(stack.array.filter { it !is Unit }.toTypedArray(), arrayOf(4, 3))
  }

  @Test
  fun testBalancedExpression_withCustomStack() {
    assertTrue(isBalanced("(A + B)", ArrayBackedCustomStack(4)))
    assertFalse(isBalanced("(A ) B)", ArrayBackedCustomStack(4)))
  }

  @Test
  fun testBalancedExpression_withCustomList() {
    assertTrue(isBalanced("(A + B)", ListBackedCustomStack(4)))
    assertFalse(isBalanced("(A ) B)", ListBackedCustomStack(4)))
  }

  @Test
  fun testBalancedExpression_withOOTBStack() {
    assertTrue(isBalanced("(A + B)", Stack()))
    assertFalse(isBalanced("(A ) B)", Stack()))
  }

  @Test
  fun testGetMinimumStack() {
    val minStack = MinStackUtil()

    minStack.push(6)
    minStack.push(3)
    minStack.push(4)
    minStack.push(2)

    assertEquals(2, minStack.getMinimum())
    minStack.pop()
    assertEquals(3, minStack.getMinimum())

    minStack.push(1)
    assertEquals(1, minStack.getMinimum())

    minStack.pop()
    minStack.pop()

    assertEquals(4, minStack.minStack.array.filter {it != Unit}.size)
    // has repeated values, hence space inefficient
    assertArrayEquals(arrayOf(6, 3, 3, 1), minStack.minStack.array.filter {it != Unit}.toTypedArray())
  }

  @Test
  fun testGetMinimumSpaceEfficientStack() {
    val minStack = SpaceEfficientMinStackUtil()

    minStack.push(6)
    minStack.push(3)
    minStack.push(4)
    minStack.push(2)

    assertEquals(2, minStack.getMinimum())
    minStack.pop()
    assertEquals(3, minStack.getMinimum())

    minStack.push(1)
    assertEquals(1, minStack.getMinimum())

    minStack.pop()
    minStack.pop()

    assertEquals(3, minStack.minStack.array.filter {it != Unit}.size)
    assertArrayEquals(arrayOf(6, 3, 1), minStack.minStack.array.filter {it != Unit}.toTypedArray())
  }

  @Test
  fun testValidOperations() {
    assertTrue(isValidStackOperation("SSX"))
    assertFalse(isValidStackOperation("SXX"))
    assertTrue(isValidStackOperation("SX"))
    assertFalse(isValidStackOperation("XS"))
  }

  @Test
  fun testSpan() {
    val result = span(arrayOf(6, 3, 4, 5, 2))

    assertArrayEquals(arrayOf(1, 1, 2, 3, 1), result)
    assertArrayEquals(arrayOf(1, 1, 1, 1), span(arrayOf(1, 1, 1, 1)))
    assertArrayEquals(arrayOf(1, 1, 1, 1), span(arrayOf(100, 80, 60, 70, 60, 75, 85)))
  }

  @Test
  fun testMaxAreaUnderHistogram() {
    val maxArea = largestRectangleInHistogram(arrayOf(6, 2, 5, 4, 5, 1, 6))

    assertEquals(12, maxArea)
  }
}
