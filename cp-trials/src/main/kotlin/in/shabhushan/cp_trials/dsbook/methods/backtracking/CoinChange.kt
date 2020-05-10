package `in`.shabhushan.cp_trials.dsbook.methods.backtracking

object CoinChange {
  /**
   * Given a candidates of coins, deduce whether a target amount could be derived
   * as change of these coins
   */
  fun coinChangePossible(
    candidates: IntArray,
    target: Int,
    currentChange: Int = 0
  ): Boolean {
    if (currentChange == target)
      return true

    for (candidate in candidates) {
      if (currentChange + candidate <= target && coinChangePossible(candidates, target, currentChange + candidate))
        return true
    }

    return false
  }

  /**
   * Greedily I could find if it's possible to have this target amount in change
   * But, If i have to find target change amount as minimum number of coins
   * I could not do this greedily. For, 1, 3, 4, If I greedily choose the largest coin, I would get 4, 1, 1 as possible solution.
   * But, the solution for this is [3, 3]
   */
  fun coinChangeMinimumCoins(
    candidates: IntArray,
    target: Int
  ): Int {
    val dp = IntArray(target + 1) { Integer.MAX_VALUE }
    dp[0] = 0

    (1..target).forEach { i ->
      for(x in candidates) {
        if (0 <= i - x)
          dp[i] = Math.min(dp[i], dp[i - x] + 1)
      }
      println("Array : ${dp.contentToString()}")
    }

    return dp[target]
  }

  fun coinChangeTotalCanonicallySimilarWays(
    candidates: IntArray,
    target: Int
  ): Int {
    val dp = IntArray(target + 1)
    dp[0] = 1

    println("Array : ${dp.contentToString()}")
    for(candidate in candidates) {
      (1..target).forEach { current ->
        if (0 <= current - candidate)
          dp[current] += dp[current - candidate]
      }
      println("Array : ${dp.contentToString()}")
    }
    println()

    return dp[target]
  }

  fun coinChangeTotalWays(
    candidates: IntArray,
    target: Int
  ): Int {
    val dp = IntArray(target + 1)
    dp[0] = 1

    println("Array : ${dp.contentToString()}")
    (1..target).forEach { current ->
      for(candidate in candidates) {
        if (0 <= current - candidate)
          dp[current] += dp[current - candidate]
      }
      println("Array : ${dp.contentToString()}")
    }
    println()

    return dp[target]
  }
}
