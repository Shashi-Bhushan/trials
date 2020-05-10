package `in`.shabhushan.cp_trials.contest

import java.math.BigDecimal
import java.util.*


// Problem 1

fun minSubsequence(nums: IntArray): List<Int> {
  val sorted = nums.sortedDescending()
  val sum = nums.sum()

  var tempSum = 0
  val resultList = mutableListOf<Int>()
  sorted.forEachIndexed { index, item ->
    tempSum += item
    resultList.add(item)

    if (tempSum > (sum - tempSum)) {
      return resultList
    }
  }

  return emptyList()
}

// Problem 2
fun numStepsIntVersion(s: String): Int {
  var r = 0
  var x = 0

  for (c in s) {
    x = 2 * x + if (c == '0') 0 else 1
  }

  while (x > 0) {
    r++

    x = if (x and 1 == 0) x shr 1 else x + 1
  }

  return r
}

fun numStepsBigDecimalVersion(s: String): Int {
  var r = 0
  var x: BigDecimal = BigDecimal.ZERO

  for (c in s) {
    x = x * BigDecimal.valueOf(2) + if (c == '0') BigDecimal.ZERO else BigDecimal.ONE
  }

  val TWO = BigDecimal.valueOf(2)
  while (x.compareTo(BigDecimal.ONE) == 1) {
    r++

    x = if (x % TWO == BigDecimal.ZERO)
      x.divide(TWO) else x + BigDecimal.ONE
  }

  return r
}
