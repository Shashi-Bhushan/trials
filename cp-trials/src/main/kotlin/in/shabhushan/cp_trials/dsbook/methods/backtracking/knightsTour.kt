package `in`.shabhushan.cp_trials.dsbook.methods.backtracking

private val nextMoves = arrayOf(
  2 to 1,
  1 to 2,
  -2 to 1,
  -1 to 2,
  2 to -1,
  1 to -2,
  -2 to -1,
  -1 to -2
)

fun isBoardSafe(
  board: Array<Array<Int>>,
  row: Int,
  col: Int
): Boolean = (0 <= row && row < board.size && 0 <= col && col < board[0].size && board[row][col] == -1)

fun knightsTour(
  boardSize: Int
): Array<Array<Int>> {
  val board = Array(boardSize) {
    Array(boardSize) { -1 }
  }

  board[0][0] = 0
  solveKnightsTour(board)

  return board
}

/**
 * Also, See https://www.geeksforgeeks.org/the-knights-tour-problem-backtracking-1/
 */
fun solveKnightsTour(
  board: Array<Array<Int>>,
  xPosition: Int = 0,
  yPosition: Int = 0,
  moveCount: Int = 1
): Boolean {
  if (moveCount == board.size * board.size)
    return true
  else {
    for (move in nextMoves) {
      if (isBoardSafe(
          board,
          xPosition + move.first,
          yPosition + move.second
        )
      ) {
        board[xPosition + move.first][yPosition + move.second] = moveCount
        if (solveKnightsTour(
            board,
            xPosition + move.first,
            yPosition + move.second,
            moveCount + 1
          )
        ) {
          return@solveKnightsTour true
        } else {
          board[xPosition + move.first][yPosition + move.second] = -1
        }
      }
    }
    return false
  }
}
