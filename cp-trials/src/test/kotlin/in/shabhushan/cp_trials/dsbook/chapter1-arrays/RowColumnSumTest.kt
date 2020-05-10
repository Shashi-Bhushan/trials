package `in`.shabhushan.cp_trials.dsbook.`chapter1-arrays`

import org.junit.Assert.assertArrayEquals
import kotlin.test.Test
import kotlin.test.assertTrue
import kotlin.test.assertFalse

class RowColumnSumTest {
  @Test
  fun testRowColumnSum() {
    val matrix = arrayOf(
      arrayOf(1, 2, 3),
      arrayOf(4, 5, 6),
      arrayOf(7, 8, 9)
    )

    val result = findRowColumnSum(matrix)

    assertArrayEquals(intArrayOf(6, 15, 24), result.first)
    assertArrayEquals(intArrayOf(12, 15, 18), result.second)
  }

  @Test
  fun testRowColumnSum_forNonSquareMatrix() {
    val matrix = arrayOf(
      arrayOf(1, 2, 3),
      arrayOf(4, 5, 6),
      arrayOf(7, 8, 9),
      arrayOf(1, 2, 3)
    )

    val result = findRowColumnSum(matrix)

    assertArrayEquals(intArrayOf(6, 15, 24, 6), result.first)
    assertArrayEquals(intArrayOf(13, 17, 21), result.second)
  }
}
