package `in`.shabhushan.cp_trials.dsbook.methods.backtracking

fun isSafe(
  board: Array<Array<Int>>,
  row: Int,
  col: Int
): Boolean {
  var upperDiagonal = row - 1
  var lowerDiagonal = row + 1

  for (column in col - 1 downTo 0) {
    if (
      board[row][column] == 1 ||
      (upperDiagonal >= 0 && board[upperDiagonal--][column] == 1) ||
      (lowerDiagonal < board.size && board[lowerDiagonal++][column] == 1)
    ) return false

  }

  return true
}

/**
 * Also see the explanation at https://www.geeksforgeeks.org/n-queen-problem-backtracking-3/
 * ans https://www.youtube.com/watch?v=wGbuCyNpxIg
 */
fun solveNQueen(
  board: Array<Array<Int>>,
  col: Int = 0
): Boolean = if (col >= board.size) /* All queens are placed */ true else {
  board.indices.forEach { row ->
    if (isSafe(board, row, col)) {
      board[row][col] = 1

      if (solveNQueen(board, col + 1)) {
        return true
      } else {
        board[row][col] = 0
      }
    }
  }

  false
}
