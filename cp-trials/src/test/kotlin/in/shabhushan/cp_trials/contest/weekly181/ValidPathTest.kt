package `in`.shabhushan.cp_trials.contest.weekly181

import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class ValidPathTest {
  @Test
  fun testValidPath() {
    assertTrue(
      hasValidPath(
        arrayOf(
          intArrayOf(2, 4, 3),
          intArrayOf(6, 5, 2)
        )
      )
    )
    assertFalse(
      hasValidPath(
        arrayOf(
          intArrayOf(1, 2, 1),
          intArrayOf(1, 2, 1)
        )
      )
    )
    assertTrue(
      hasValidPath(
        arrayOf(
          intArrayOf(1, 1, 1, 1, 1, 1, 3)
        )
      )
    )
    assertFalse(
      hasValidPath(
        arrayOf(
          intArrayOf(1, 1, 1, 1, 6),
          intArrayOf(1, 1, 1, 1, 2),
          intArrayOf(1, 1, 1, 1, 2),
          intArrayOf(1, 1, 1, 1, 2),
          intArrayOf(1, 1, 1, 1, 2)
        )
      )
    )
  }
}
