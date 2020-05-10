package `in`.shabhushan.cp_trials.dsbook.`chapter2-recursion`

fun IntArray.isArraySorted(): Boolean = if (this.size == 1) true else {
  this[0] < this[1] && this.drop(1).toIntArray().isArraySorted()
}
