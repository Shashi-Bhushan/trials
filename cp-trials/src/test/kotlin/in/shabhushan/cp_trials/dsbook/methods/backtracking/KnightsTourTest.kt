package `in`.shabhushan.cp_trials.dsbook.methods.backtracking

import kotlin.test.Test

class KnightsTourTest {
  @Test
  fun testKnightsTour() {
    val board = knightsTour(6)

    board.indices.forEach { row ->
      board[row].indices.forEach { column ->
        print("${board[row][column]} ")
      }
      println("")
    }
  }
}
