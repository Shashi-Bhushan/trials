package `in`.shabhushan.cp_trials.contest.aprilContest

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class ContestTest {
  @Test
  fun testProblem3() {
    assertEquals(6, maxSubArray3(intArrayOf(-2, 1, -3, 4, -1, 2, 1, -5, 4)))
    assertEquals(-1, maxSubArray3(intArrayOf(-1)))
    assertEquals(1, maxSubArray3(intArrayOf(-2, 1)))
    assertEquals(-2, maxSubArray3(intArrayOf(-2, -4, -2)))
    assertEquals(0, maxSubArray3(intArrayOf(-2, -1, 0, -2, -2)))
  }

  @Test
  fun testProblem2() {
    assertFalse(isHappy(2))
    assertTrue(isHappy(19))
  }

  fun getReverse(string: String, n: Int = 0): String  = if (n == string.length - 1) string[n].toString() else getReverse(string, n + 1) + string[n]

  @Test
  fun getReverse() {
    assertEquals("ihsahS", getReverse("Shashi"))
  }

  @Test
  fun testBackspaceCompare() {
    assertTrue(backspaceCompare("y#fo##f", "y#f#o##f"))
  }
}
