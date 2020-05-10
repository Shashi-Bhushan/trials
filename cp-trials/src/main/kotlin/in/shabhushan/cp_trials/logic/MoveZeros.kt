package `in`.shabhushan.cp_trials.logic

object MoveZeros {
  fun moveZeroes(nums: IntArray): IntArray {
    val newArray = IntArray(nums.size) { 0 }
    var top = 0

    nums.forEach {
      if (it != 0) {
        newArray[top] = it
        top++
      }
    }

    return newArray
  }

  fun moveZeroesInPlace(nums: IntArray): Unit {
    nums.indices.forEach { index ->
      if (nums[index] == 0){
        var nonZeros = index
        while (nonZeros + 1 < nums.size && nums[nonZeros] == 0)
          nonZeros++

        // swap zeros and non zeros
        nums[index] = nums[nonZeros]
        nums[nonZeros] = 0
      }
    }
  }

  fun moveZeroesInPlace2(nums: IntArray): Unit {
    var lastNonZeroFoundAt = 0

    nums.indices.forEach { index ->
      if (nums[index] != 0){
        nums[lastNonZeroFoundAt++] = nums[index]
      }
    }

    (lastNonZeroFoundAt until nums.size).forEach { index ->
      nums[index] = 0
    }
  }
}
