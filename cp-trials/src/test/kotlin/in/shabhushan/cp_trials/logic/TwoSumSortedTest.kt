package `in`.shabhushan.cp_trials.logic

import kotlin.test.Test
import kotlin.test.assertEquals

class TwoSumSortedTest {
  @Test
  fun testTwoSumSorted() {
    val result = TwoSumSorted.twoSumSorted(intArrayOf(2, 3, 5, 7, 13, 14), 12)

    assertEquals(2, result.first())
    assertEquals(3, result[1])

  }
}
