package `in`.shabhushan.cp_trials.logic

import `in`.shabhushan.cp_trials.logic.TwoSum
import kotlin.test.Test
import kotlin.test.assertEquals

class TwoSumTest {
  @Test
  fun testTwoSum() {
    val solution = TwoSum.twoSum(intArrayOf(2, 7, 11, 15), 9)

    println(solution.contentToString())
    assertEquals(0, solution.first())
    assertEquals(1, solution[1])
  }

  @Test
  fun testTwoSum2() {
    val solution = TwoSum.twoSum(intArrayOf(3, 3), 6)

    println(solution.contentToString())
    assertEquals(0, solution.first())
    assertEquals(1, solution[1])
  }

  @Test
  fun testTwoSum3() {
    val solution = TwoSum.twoSum(intArrayOf(3,2,4), 6)

    println(solution.contentToString())
    assertEquals(1, solution.first())
    assertEquals(2, solution[1])
  }
}
