package `in`.shabhushan.cp_trials.dsbook.`chapter2-recursion`

/**
 * Input: 2
 * Output:
 * 0 0
 * 0 1
 * 1 0
 * 1 1
 */
fun binaryStrings(n: Int): List<String> = if (n == 1) listOf("0", "1") else {
  binaryStrings(n - 1).flatMap {
    // for each entry, append 0 and 1
    listOf("0$it", "1$it")
  }
}
