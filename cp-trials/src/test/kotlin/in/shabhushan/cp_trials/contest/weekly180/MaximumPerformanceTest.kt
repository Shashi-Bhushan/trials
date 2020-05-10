package `in`.shabhushan.cp_trials.contest.weekly180

import kotlin.test.Test
import kotlin.test.assertEquals

class MaximumPerformanceTest {
  @Test
  fun testMaximumPerformance() {
    assertEquals(60,
      maxPerformance(
        6,
        intArrayOf(2, 10, 3, 1, 5, 8),
        intArrayOf(5, 4, 3, 9, 7, 2),
        2
      )
    )
  }
}
