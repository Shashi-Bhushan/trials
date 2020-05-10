package `in`.shabhushan.cp_trials.logic

import org.junit.Assert.assertArrayEquals
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class ArraysTest {
  @Test
  fun testContainsDuplicate() {
    assertTrue(containsDuplicate(intArrayOf(1, 2, 3, 1)))
  }

  @Test
  fun testContainsNearbyDuplicate() {
    assertTrue(containsNearbyDuplicate(intArrayOf(1, 2, 3, 1), 3))
    assertTrue(containsNearbyDuplicate(intArrayOf(1, 0, 1, 1), 1))
    assertFalse(containsNearbyDuplicate(intArrayOf(1, 2, 3, 1, 2, 3), 2))
    assertFalse(containsNearbyDuplicate(intArrayOf(), 0))
    assertFalse(containsNearbyDuplicate(intArrayOf(1), 1))
    assertFalse(containsNearbyDuplicate(intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), 15))
  }

  @Test
  fun testContainsNearbyAlmostDuplicate() {
    assertTrue(containsNearbyAlmostDuplicate(intArrayOf(1, 2, 3, 1), 3, 0))
    assertTrue(containsNearbyAlmostDuplicate(intArrayOf(1, 3, 1, 1), 1, 2))
    assertFalse(containsNearbyAlmostDuplicate(intArrayOf(1, 5, 9, 1, 5, 9), 2, 3))
    assertFalse(
      containsNearbyAlmostDuplicate(
        intArrayOf(-1, 2147483647),
        1,
        2147483647
      )
    )
  }

  @Test
  fun testRemoveDuplicates_KeepingTwoOfSame() {
    val input = intArrayOf(1,1,1,2,2,3)

    val output = removeDuplicates(input)

    assertArrayEquals(arrayOf(1,1,2,2,3), input.take(output).toTypedArray())
  }

  @Test
  fun testHornerMethod() {
    assertEquals(5, horner(intArrayOf(5, -6, 7, 8, -9), 1))
    assertEquals(67, horner(intArrayOf(5, -6, 7, 8, -9), 2))
  }
}
