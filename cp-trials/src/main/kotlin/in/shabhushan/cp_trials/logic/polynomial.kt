package `in`.shabhushan.cp_trials.logic

/**
 * Solve polynomial using horner method
 * 5x^4 - 6x^3 + 7x^2 + 8x - 9
 * => (((5x - 6)x + 7)x + 8)x - 9
 */
fun horner(
  coefficientArray: IntArray,
  xValue: Int,
  eval: Int = coefficientArray.size - 1 // second last
): Int = if (eval == 0) coefficientArray[eval] else {
  val horner = horner(coefficientArray, xValue, eval - 1)
  horner * xValue + coefficientArray[eval]
}
