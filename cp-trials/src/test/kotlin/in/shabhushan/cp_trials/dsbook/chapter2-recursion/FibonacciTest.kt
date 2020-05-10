package `in`.shabhushan.cp_trials.dsbook.`chapter2-recursion`

import org.junit.Assert.assertArrayEquals
import kotlin.test.Test

class FibonacciTest {
  @Test
  fun testFibonacci() {
    val result = fibonacciSequence(0, 1, 10)

    assertArrayEquals(arrayOf(0, 1, 1, 2, 3, 5, 8, 13, 21, 34), result.toTypedArray())
  }
}
