package `in`.shabhushan.cp_trials.contest.weekly181

/**
 * Kotlin solution for https://leetcode.com/contest/weekly-contest-181/
 */
enum class Directions(val direction: Pair<Int, Int>) {
  DOWN(1 to 0),
  UP(-1 to 0),
  RIGHT(0 to 1),
  LEFT(0 to -1)
}

typealias CURRENT_DIRECTION = Int
typealias NEW_DIRECTION = Directions
typealias VALIDSTREETS = Int

private val validStreet: Map<CURRENT_DIRECTION, Map<NEW_DIRECTION, List<VALIDSTREETS>>> = mapOf(
  1 to mapOf(
    Directions.RIGHT to listOf(1, 3, 5),
    Directions.LEFT to listOf(1, 4, 6)
  ),
  2 to mapOf(
    Directions.DOWN to listOf(2, 5, 6),
    Directions.UP to listOf(2, 3, 4)
  ),
  3 to mapOf(
    Directions.DOWN to listOf(5, 6, 2),
    Directions.LEFT to listOf(1, 4, 6)
  ),
  4 to mapOf(
    Directions.RIGHT to listOf(1, 3, 5),
    Directions.DOWN to listOf(2, 5, 6)
  ),
  5 to mapOf(
    Directions.UP to listOf(2, 3, 4),
    Directions.LEFT to listOf(1, 4, 6)
  ),
  6 to mapOf(
    Directions.UP to listOf(2, 3, 4),
    Directions.RIGHT to listOf(1, 3, 5)
  )
)

fun hasValidPath(
  grid: Array<IntArray>,
  prevRow: Int = -1,
  prevColumn: Int = -1,
  currentRow: Int = 0,
  currentColumn: Int = 0
): Boolean {
  if (currentRow == grid.size - 1 && currentColumn == grid[0].size - 1) return true else {
    // search in all directions
    Directions.values().forEach { d ->
      val newRow = currentRow + d.direction.first
      val newColumn = currentColumn + d.direction.second

      if (newRow in grid.indices && newColumn in grid[0].indices &&
        !(newRow == prevRow && newColumn == prevColumn)
      ) {
        val element = grid[currentRow][currentColumn]
        val nextElement = grid[newRow][newColumn]

        validStreet[element]?.let {
          // get current direction's valid streets from map
          it[d]?.let { validStreets ->
            if (nextElement in validStreets) {
              return hasValidPath(
                grid,
                currentRow,
                currentColumn,
                newRow,
                newColumn
              )
            }
          }
        }
      }
    }
    return false
  }
}
