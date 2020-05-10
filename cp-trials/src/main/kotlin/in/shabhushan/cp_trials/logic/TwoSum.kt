package `in`.shabhushan.cp_trials.logic

object TwoSum {
  fun twoSum2(
    nums: IntArray,
    target: Int
  ): IntArray {
    val map = nums.mapIndexed { index, element ->
      element to index
    }.toMap()

    val keys = map.keys

    nums.forEachIndexed { index, element ->
      val otherNumber = target - element

      if (otherNumber in keys && map[otherNumber] != index)
        return intArrayOf(index, map[otherNumber] ?: error("err-other-number-not-found"))
    }

    throw IllegalArgumentException("err-no-two-sum-solution")
  }

  fun twoSum(
    nums: IntArray,
    target: Int
  ): IntArray {
    val map = mutableMapOf<Int, Int>()

    nums.forEachIndexed { index, element ->
      val otherNumber = target - element

      if (otherNumber in map.keys)
        return intArrayOf(map[otherNumber] ?: error("err-other-number-not-found"), index)

      map[element] = index
    }

    throw IllegalArgumentException("err-no-two-sum-solution")
  }
}
