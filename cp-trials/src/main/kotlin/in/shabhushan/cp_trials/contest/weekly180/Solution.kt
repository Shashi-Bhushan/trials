import kotlin.math.max
import kotlin.math.min

fun luckyNumbers(matrix: Array<IntArray>): List<Int> {
  matrix.indices.forEach { row ->
    matrix[row].indices.forEach { column ->
      var min = Integer.MAX_VALUE
      var max = Integer.MIN_VALUE

      matrix.indices.forEach { k ->
        min = min(matrix[row][k], min)
      }

      matrix[row].indices.forEach { k ->
        max = max(matrix[k][column], max)
      }

      if (min == matrix[row][column] && max == matrix[row][column]) {
        return listOf(matrix[row][column])
      }
    }
  }

  return emptyList()
}
