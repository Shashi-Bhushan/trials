package `in`.shabhushan.cp_trials.dsbook.`chapter1-arrays`

fun findMissing(
  array: IntArray
): IntArray = mutableListOf<Int>().let { missing ->

  (1 until array.size).forEach { current ->
    if (array[current] - array[current - 1] !in 0..1) {
      (array[current - 1] + 1 until array[current]).forEach {
        missing.add(it)
      }
    }
  }

  missing.toIntArray()
}
