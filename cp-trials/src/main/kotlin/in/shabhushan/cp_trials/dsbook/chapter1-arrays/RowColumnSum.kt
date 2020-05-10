package `in`.shabhushan.cp_trials.dsbook.`chapter1-arrays`

fun findRowColumnSum(
  matrix: Array<Array<Int>>
): Pair<IntArray, IntArray> {
  val rowSum = Array<Int>(matrix.size) { 0 }
  val columnSum = Array<Int>(matrix[0].size) { 0 }

  matrix.indices.forEach { row ->
    matrix[row].indices.forEach { column ->
      rowSum[row] += matrix[row][column]
      columnSum[column] += matrix[row][column]
    }
  }

  return Pair(rowSum.toIntArray(), columnSum.toIntArray())
}
