package `in`.shabhushan.cp_trials.dsbook.`chapter2-recursion`

import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class SortedArrayTest {
  @Test
  fun testSortedArray() {
    assertTrue(intArrayOf(1, 3, 5, 7).isArraySorted())
  }

  @Test
  fun testUnsortedArray() {
    assertFalse(intArrayOf(1, 4, 3, 5, 7).isArraySorted())
  }
}
