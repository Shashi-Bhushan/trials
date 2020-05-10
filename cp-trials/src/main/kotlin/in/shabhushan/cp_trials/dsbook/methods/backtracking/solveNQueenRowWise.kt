package `in`.shabhushan.cp_trials.dsbook.methods.backtracking

/**
 * Solves the N queen row wise
 *
 * @param row signifies the row number for which the placement is being made
 * @return List<Int> having the placements
 */
typealias Row = Int
typealias Column = Int

fun solveNQueenAlgo(
  boardSize: Int,
  row: Int = 0,
  placements: Set<Pair<Row, Column>> = emptySet()
): Pair<Boolean, Set<Pair<Row, Column>>> {
  if (row == boardSize) return true to placements else {
    val totalColumns = boardSize

    (0 until totalColumns).forEach { column ->
      val newPlacement = placements + setOf(row to column)
      if (boardSize.isValidPlacement(newPlacement)) {
        val result = solveNQueenAlgo(boardSize, row + 1, newPlacement)

        if (result.first)
          return result
        // else new placement is invalid, do next iteration
      }
    }

    return false to emptySet()
  }
}

/**
 * @param placements Set of <Row, Column> as Int values
 */
fun Int.isValidPlacement(
  placements: Set<Pair<Row, Column>>
): Boolean {
  val element = placements.last()

  var leftDiagonal = element.second - 1
  var rightDiagonal = element.second + 1

//  for (row in element.first - 1 downTo 0) {
//    if (
//      placements.contains(row to element.second) ||
//      (leftDiagonal >= 0 && placements.contains(row to leftDiagonal--)) ||
//      (rightDiagonal < this@isValidPlacement.size && placements.contains(row to rightDiagonal++))
//    ) return false
//
//  }
//  return true

  return !(element.first - 1 downTo 0).any { row ->
    placements.contains(row to element.second) ||
        (leftDiagonal >= 0 && placements.contains(row to leftDiagonal--)) ||
        (rightDiagonal < this@isValidPlacement && placements.contains(row to rightDiagonal++))
  }
}
