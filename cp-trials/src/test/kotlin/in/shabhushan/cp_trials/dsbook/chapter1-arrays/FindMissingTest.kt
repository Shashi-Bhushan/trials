package `in`.shabhushan.cp_trials.dsbook.`chapter1-arrays`

import org.junit.Assert.assertArrayEquals
import kotlin.test.Test
import kotlin.test.assertTrue
import kotlin.test.assertFalse

class FindMissingTest {
  @Test
  fun testMissing() {
    assertArrayEquals(intArrayOf(5, 6), findMissing(intArrayOf(1, 2, 3, 4, 4, 7)))
    assertArrayEquals(intArrayOf(4, 7, 8), findMissing(intArrayOf(1, 2, 3, 5, 6, 6, 6, 9, 9, 9)))
  }
}
