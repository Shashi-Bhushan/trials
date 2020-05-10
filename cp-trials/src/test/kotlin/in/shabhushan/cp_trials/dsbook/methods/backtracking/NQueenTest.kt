package `in`.shabhushan.cp_trials.dsbook.methods.backtracking

import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class NQueenTest {
  @Test
  fun testIsSafe() {
    val board = arrayOf(
      arrayOf(0, 0, 0),
      arrayOf(0, 0, 0),
      arrayOf(1, 0, 0)
    )

    assertTrue(isSafe(board, 0, 1))
    assertFalse(isSafe(board, 1, 1))
    assertTrue(isSafe(board, 1, 2))
  }

  @Test
  fun testSolveNQueen() {
    val board = arrayOf(
      arrayOf(0, 0, 0, 0),
      arrayOf(0, 0, 0, 0),
      arrayOf(0, 0, 0, 0),
      arrayOf(0, 0, 0, 0)
    )

    assertTrue(solveNQueen(board))

    val secondBoard = arrayOf(
      arrayOf(0, 0, 0),
      arrayOf(0, 0, 0),
      arrayOf(0, 0, 0)
    )

    assertFalse(
      solveNQueen(
        secondBoard
      )
    )
  }

  @Test
  fun testSolveNQueenWithPlacement() {
    val board = arrayOf(
      arrayOf(0, 0, 0, 0),
      arrayOf(0, 0, 0, 0),
      arrayOf(0, 0, 0, 0),
      arrayOf(0, 0, 0, 0)
    )

    val result = solveNQueenAlgo(4)
    assertTrue(result.first)
  }
}
