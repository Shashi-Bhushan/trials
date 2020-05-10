package `in`.shabhushan.cp_trials.logic

object TwoSumSorted {
  fun twoSumSorted(
    numbers: IntArray,
    target: Int
  ): IntArray {
    var i = 0;
    var j = numbers.size - 1

    while (i < j) {
      when {
        numbers[i] + numbers[j] == target -> return intArrayOf(i, j)
        numbers[i] + numbers[j] > target -> j -= 1
        else -> i += 1
      }
    }

    throw IllegalArgumentException("err-should-not-happen")
  }
}
