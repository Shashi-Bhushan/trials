package `in`.shabhushan.cp_trials.dsbook.methods.backtracking


fun combinationSum(
  candidates: IntArray,
  target: Int
): List<List<Int>> = if (candidates.isEmpty()) emptyList() else {
  mutableListOf<List<Int>>().apply {
    combinationSumWithCaching(candidates, 0, 0, target, this)
  }
}


private fun combinationSumWithoutCaching(
  candidates: IntArray,
  index: Int,
  currentSum: Int,
  target: Int,
  result: MutableList<List<Int>>,
  tempList: List<Int>
): Unit {
  // constraint
  if (index >= candidates.size) return;

  if (currentSum == target) {
    result.add(tempList)
    return;
  }

  candidates.forEachIndexed { i, candidate ->
    if (currentSum + candidate <= target) {
      // make a choice
      combinationSumWithoutCaching(candidates, i, currentSum + candidate, target, result, tempList + candidate)
    }
  }
}

/**
 * TODO: Caching :D
 */
private fun combinationSumWithCaching(
  candidates: IntArray,
  index: Int,
  currentSum: Int,
  target: Int,
  result: MutableList<List<Int>>,
  tempList: List<Int> = emptyList(),
  memo: MutableMap<Int, List<List<Int>>> = mutableMapOf()
): List<Int> {
  // constraint
  if (index >= candidates.size) return emptyList();

  if (currentSum == target) {
    result.add(tempList)
    return tempList;
  }

  memo[currentSum]?.let { sum ->
    result.map { result ->
      sum.flatMap { sum ->
        result + sum
      }
    }
  }

  val sumList = mutableListOf<List<Int>>()
  candidates.forEachIndexed { i, candidate ->
    if (currentSum + candidate <= target) {
      // make a choice
      val r = combinationSumWithCaching(candidates, i, currentSum + candidate, target, result, tempList + candidate, memo)

      if(r.isNotEmpty())
        sumList.add(r)
    }
  }

  memo.putIfAbsent(currentSum, sumList)
  return emptyList()
}

object CombinationSum4 {
  /**
   * Forward DFS is when sum grows towards target
   * It's a Top Down approach
   *
   * Find 1 entry of solution, then find other entry of solution and build the list this way
   * 1, 1, 1
   */
  fun forwardDFSWithoutCaching(
    candidates: IntArray,
    target: Int,
    index: Int = 0,
    currentSum: Int = 0
  ): Int {
    if (index >= candidates.size)
      return 0

    if (currentSum == target)
      return 1

    var res = 0
    candidates.indices.forEach { i ->
      if (currentSum + candidates[i] <= target)
        res += forwardDFSWithoutCaching(candidates, target, i, currentSum + candidates[i])
    }

    return res
  }

  fun forwardDFSWithCaching(
    candidates: IntArray,
    target: Int,
    index: Int = 0,
    currentSum: Int = 0,
    memo: IntArray = IntArray(target + 1) { -1 }
  ): Int {
    if (index >= candidates.size)
      return 0

    if (currentSum == target)
      return 1

    if (memo[target] != -1)
      return memo[target]

    var res = 0
    candidates.indices.forEach { i ->
      if (currentSum + candidates[i] <= target)
        res += forwardDFSWithCaching(candidates, target, i, currentSum + candidates[i])
    }

    return res.also {
      memo[target] = res
    }
  }

  /**
   * Backward DFS is when target shrink towards 0
   *
   * This is a bottom up solution.
   * find the solution for say target = 1. then using this, find solution for target = 2.
   *
   * The rationale here is suppose we need to solve for [1, 2, 3] and target is 4
   * Now, if I choose 1 as first entry, then I would call candidates again with new target as 4 - 1 = 3
   * Suppose, we take the case when we choose 1, 1 and target is now 2
   * Hence, using 1, 1 as root and 2 as target, all combinations will be
   * 1, 1, [1, 1]
   * 1, 1, [2]
   *
   * I know now that if the target is 2, the total number of possible solutions would be 2.
   * In the next recursion tree, when I choose 2 as base again target would be 2.
   * Now, if I had cached the previous result, I would know that for target 2, there are only 2 possible solutions.
   * -> 1, 1
   * -> 2
   *
   * if we somehow find, how many ways a number can be participant in our solution set then we can re-utilize that solution
   * [this is what we did in above memo based solution
   *
   * combinationSum4(intArrayOf(4, 2, 1), 32) would not be possible without this optimization
   */
  fun backwardDFSWithoutCaching(
    candidates: IntArray,
    target: Int,
    index: Int = 0
  ): Int {
    // constraint
    if (index >= candidates.size) return 0

    if (0 == target)
      return 1

    var result = 0
    candidates.indices.forEach { i ->
      if (target - candidates[i] >= 0) {
        result += backwardDFSWithoutCaching(candidates, target - candidates[i], i)
      }
    }

    return result
  }

  fun backwardDFSWithCaching(
    candidates: IntArray,
    target: Int,
    index: Int = 0,
    memo: IntArray = IntArray(target + 1) { -1 }
  ): Int {
    // constraint
    if (index >= candidates.size) return 0

    if (0 == target)
      return 1

    if (memo[target] != -1)
      return memo[target]

    var result = 0
    candidates.indices.forEach { i ->
      if (target - candidates[i] >= 0) {
        result += backwardDFSWithCaching(candidates, target - candidates[i], i, memo)
      }
    }

    return result.also {
      memo[target] = it
    }
  }

  /**
   * This is purely recursive solution
   * Recurrence relation
   *   combination[target] = {
   *     sum(combination[target - nums[i]]) target>=nums[i]
   *     1: when target=0,
   *   }
   *
   * combination[4] = combination[4-1] + combination[4-2] + combination[4-3] = combination[3] + combination[2] + combination[1]
   *
   * in base case, combination[1] = 0
   * The base case is when target = 0 and we do not choose any number from candidates
   * Add a 1 to signify that we have found one solution where we need not choose further
   */
  fun backwardRecursiveWithoutCaching(
    candidates: IntArray,
    target: Int
  ): Int {
    if (target == 0)
      return 1

    var res = 0
    candidates.forEach { candidate ->
      if (target >= candidate) {
        res += backwardRecursiveWithoutCaching(candidates, target - candidate)
      }
    }

    return res
  }

  fun backwardRecursiveWithCaching(
    candidates: IntArray,
    target: Int,
    memo: IntArray = IntArray(target + 1) { -1 }
  ): Int {
    if (target == 0)
      return 1

    if (memo[target] != -1)
      return memo[target]

    var res = 0
    candidates.forEach { candidate ->
      if (target >= candidate) {
        res += backwardRecursiveWithCaching(candidates, target - candidate, memo)
      }
    }

    return res.also {
      memo[target] = it
    }
  }

  fun backwardDynamicProgramming(
    candidates: IntArray,
    target: Int,
    dp: IntArray = IntArray(target + 1) { -1 }
  ): Int {
    if (target == 0)
      return 1

    if (dp[target] != -1)
      return dp[target]

    var res = 0
    candidates.forEach { candidate ->
      if (target >= candidate) {
        res += backwardDynamicProgramming(candidates, target - candidate, dp)
      }
    }

    return res.also {
      dp[target] = res
    }
  }

  /**
   * There is only one way to get the sum 0
   * this is donated by dp[0] = 1
   *
   * This is the same approach as currentSum reaching up to sum.
   * Let's take candidates = [1, 2, 4] and target = 4
   * dp[0] = 1 denotes only one way to get sum = 0
   * At this moment, dp = [1, 0, 0, 0, 0]
   *
   * For number 1, dp = [1, 1, 0, 0, 0]
   * For number 2, dp = [1, 1, 2, 0, 0]
   * For number 3, dp = [1, 1, 2, 3, 0]
   * For number 4, dp = [1, 1, 2, 3, 6]
   *
   * Hence, solution for this is 6
   *
   * For each number from 1 to target:
   * __ Get all candidates which are less than equal to this number
   * __ get { dp[number - candidates] }.sum()
   */
  fun iterativeDynamicProgramming(
    candidates: IntArray,
    target: Int
  ): Int {
    if (candidates.isEmpty())
      return 0

    val dp = IntArray(target + 1)
    dp[0] = 1

    (1..target).forEach { i ->
      // Similar to dp[i] = candidates.filter { i >= it }.sumBy { dp[i - it] }
      for(candidate in candidates) {
        if (0 <= i - candidate)
          dp[i] += dp[i - candidate]
      }
    }

    return dp[target]
  }

  /**
   * Forward or push DP works a bit different.
   * It pushed the initial result to next candidates and update them.
   * For the same case of candidates [1, 2, 4] and target 1
   *
   * initially, dp = [1, 0, 0, 0, 0]
   * for number 0, dp = [1, 1, 1, 1, 0]
   * for number 1, dp = [1, 1, 2, 2, 1]
   * for number 2, dp = [1, 1, 2, 3, 3]
   * for number 3, dp = [1, 1, 2, 3, 6]
   */
  fun forwardOrPushIterativeDynamicProgramming(
    candidates: IntArray,
    target: Int
  ): Int {
    if (candidates.isEmpty())
      return 0

    val dp = IntArray(target + 1)
    dp[0] = 1

    (0 until target).forEach { i ->
      // Similar to dp[i] = candidates.filter { i >= it }.sumBy { dp[i - it] }
      for(candidate in candidates) {
        if (i + candidate <= target)
          dp[i + candidate] += dp[i]
      }
    }

    return dp[target]
  }
}
