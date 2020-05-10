package `in`.shabhushan.cp_trials.logic

import `in`.shabhushan.cp_trials.logic.MoveZeros.moveZeroes
import `in`.shabhushan.cp_trials.logic.MoveZeros.moveZeroesInPlace
import `in`.shabhushan.cp_trials.logic.MoveZeros.moveZeroesInPlace2
import org.junit.Assert.assertArrayEquals
import kotlin.test.Test

class MoveZerosTest {
  @Test
  fun testMoveZeros() {
    assertArrayEquals(intArrayOf(1, 2, 3, 4, 9, 0, 0, 0), moveZeroes(intArrayOf(1, 2, 0, 3, 0, 4, 9, 0)))
  }

  @Test
  fun testMoveZerosInPlace() {
    val input = intArrayOf(1, 2, 0, 3, 0, 4, 9, 0)
    moveZeroesInPlace(input)

    assertArrayEquals(intArrayOf(1, 2, 3, 4, 9, 0, 0, 0), input)

    val input2 = intArrayOf(1, 2, 0, 3, 0, 4, 9, 12)
    moveZeroesInPlace(input2)

    assertArrayEquals(intArrayOf(1, 2, 3, 4, 9, 12, 0, 0), input2)

    val input3 = intArrayOf(0, 0, 0, 0, 0, 0, 0, 0)
    moveZeroesInPlace(input3)

    assertArrayEquals(intArrayOf(0, 0, 0, 0, 0, 0, 0, 0), input3)
  }

  @Test
  fun testMoveZerosInPlace2() {
    val input = intArrayOf(1, 2, 0, 3, 0, 4, 9, 0)
    moveZeroesInPlace2(input)

    assertArrayEquals(intArrayOf(1, 2, 3, 4, 9, 0, 0, 0), input)

    val input2 = intArrayOf(1, 2, 0, 3, 0, 4, 9, 12)
    moveZeroesInPlace2(input2)

    assertArrayEquals(intArrayOf(1, 2, 3, 4, 9, 12, 0, 0), input2)

    val input3 = intArrayOf(0, 0, 0, 0, 0, 0, 0, 0)
    moveZeroesInPlace2(input3)

    assertArrayEquals(intArrayOf(0, 0, 0, 0, 0, 0, 0, 0), input3)
  }
}
