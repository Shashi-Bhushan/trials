package in.shabhushan.cp_trials.dynamic_programming;

import java.util.*;

public class CoinChange {
  /**
   * Given a set of coins, fetch minimum number of coins needed to make up the combinations for a target amount.
   * Eg. 1, 3, 4 as coins and 6 as target amount, as answer would be 3 + 3, return 2 for this pair.
   */
  public static int minimumCoinChange(int[] coins, int target) {
    if (target == 0 || coins.length == 0) return 0;

    int min = Integer.MAX_VALUE;

    // iterate over candidates first
    for (int coin: coins) {
      if (target >= coin)
        min = Math.min(min, minimumCoinChange(coins, target - coin) + 1);
    }

    return min == Integer.MAX_VALUE || min == Integer.MIN_VALUE || min == 0 ? -1 : min;
  }

  public static int coinChangeIterative(int[] coins, int target) {
    if (target == 0 || coins.length == 0) return 0;

    int[] dp = new int[target + 1];
    dp[0] = 0;

    for (int amt = 1; amt <= target; amt++) {
      dp[amt] = Integer.MAX_VALUE;

      for (int coin: coins) {
        if (amt >= coin) {
          dp[amt] = Math.min(dp[amt], dp[amt - coin] + 1);
        }
      }
    }

    return dp[target] == Integer.MAX_VALUE || dp[target] == Integer.MIN_VALUE ? -1 : dp[target];
  }

  public static CoinChangeSolution coinChangeIterativeWithCounting(int[] coins, int target) {
    int[] memory = new int[target + 1];
    memory[0] = 0;

    int[] sequence = new int[target + 1];

    for (int i = 1; i <= target; i++) {
      memory[i] = 100_00_00;

      // for each coin, check the min value required
      for (int coin : coins) {
        if (i - coin >= 0 && memory[i - coin] + 1 < memory[i]) {
          memory[i] = memory[i - coin] + 1;
          sequence[i] = coin;
        }
      }
    }

    CoinChangeSolution solution = new CoinChangeSolution();
    solution.solution = memory[target];
    solution.sequence = sequence;
    return solution;
  }

  public static class CoinChangeSolution {
    public int solution;
    public int[] sequence;
  }

  /**
   * Given a set of coins, Give Total number of ways to form the target amount
   */
  public static int totalWaysCoinChangeRecursive(int[] coins, int target) {
    if (target == 0)
      return 1;

    int total = 0;

    for (int coin: coins) {
      if (target >= coin)
        total += totalWaysCoinChangeRecursive(coins, target - coin);
    }

    return total;
  }

  public static int totalWaysCoinChange(int[] coins, int target) {
    int[] dp = new int[target + 1];
    dp[0] = 1;

    for (int i = 1; i <= target; i++) {
      for (int coin : coins) {
        if (i - coin >= 0) {
          dp[i] += dp[i - coin];
        }
      }
    }

    return dp[target];
  }

  /**
   * Leetcode Solution for https://leetcode.com/problems/coin-change/
   * Minimum number of coins required to make target sum
   */
  public static int coinChangeMinimumCoins(int[] coins, int target) {
    int[] dp = new int[target + 1];
    Arrays.fill(dp, -1);
    dp[0] = 0;

    int best = coinChangeMinimumCoinshelper(coins, target, dp);

    if (best < 0 || best == Integer.MAX_VALUE) return -1;
    else return best;
  }

  public static int coinChangeMinimumCoinshelper(int[] coins, int target, int[] dp) {
    if (coins.length == 0 || target == 0) return 0;
    else if (target < 0) return Integer.MIN_VALUE;
    else if (dp[target] != -1) return dp[target];
    else {
      int best = Integer.MAX_VALUE;

      for (int coin : coins) {
        int min = coinChangeMinimumCoinshelper(coins, target - coin, dp);

        if (min != Integer.MIN_VALUE) {
          best = Math.min(best, min + 1);
        }
      }

      dp[target] = best;
      return best;
    }
  }

  // reduce 1 coin at a time (not amount/coin i.e. greedy solution won't work)
  public static int coinChangeMinimumCoinsDP(int[] coins, int target) {
    int[] dp = new int[target + 1];
    dp[0] = 0;

    for (int amt = 1; amt <= target; amt++) {
      int min = Integer.MAX_VALUE;

      for (int coin : coins) {
        if (amt >= coin && dp[amt - coin] != Integer.MAX_VALUE) {
          min = Math.min(min, dp[amt - coin] + 1);
        }
      }

      dp[amt] = min;
    }

    if (dp[target] != Integer.MAX_VALUE) return dp[target];
    else return -1;
  }

  /**
   * Leetcode solution for
   * https://leetcode.com/problems/coin-change-2/
   * Total number of unique ways to make the sum, Note that 1 + 2 + 1 is considered same than 2 + 1 + 1
   */
  public static int change(int[] coins, int target) {
    int[] dp = new int[target + 1];
    dp[0] = 1; // one way to make 0 sum

    for (int coin : coins) {
      for (int amt = 1; amt <= target; amt++) {
        if (amt >= coin) {
          dp[amt] += dp[amt - coin];
        }
      }
    }

    return dp[target];
  }

  public static int changeRecursive(int[] coins, int target) {
    if (coins == null) return 0;
    return changeHelper(target, coins, 0, 0);
  }

  private static int changeHelper(
      int amount, int[] coins, int sum, int index
  ) {
    if (sum == amount) {
      return 1;
    }
    int result = 0;
    // for each coin, starting from index
    for (int i = index; i < coins.length; i++) {
      int coin = coins[i];
      if (sum + coin <= amount)
        result += changeHelper(amount, coins, sum + coin, i);
    }

    return result;
  }

  /**
   * Leetcode solution for
   * https://leetcode.com/problems/combination-sum-iv/submissions/
   * Total number of ways to generate a target, Note that 1 + 2 + 1 is considered different than 2 + 1 + 1
   */
  public int combinationSum4(int[] coins, int target) {
    int[] dp = new int[target + 1];
    dp[0] = 1; // one way to make 0 sum


    for (int amt = 1; amt <= target; amt++) {
      for (int coin : coins) {
        if (amt >= coin) {
          dp[amt] += dp[amt - coin];
        }
      }
    }

    return dp[target];
  }

  /**
   * Leetcode Solution for
   * https://leetcode.com/problems/perfect-squares/
   *
   * Note that here we need to create our own list of candidate answers i.e. squares
   */
  public static int numSquares(int n) {
    int[] dp = new int[n + 1];
    Arrays.fill(dp, Integer.MAX_VALUE);

    dp[0] = 0;

    List<Integer> list = new ArrayList<>();

    for (int i = 1; i * i <= n; i++) {
      list.add(i * i);
    }

    for (int i: list) {
      for (int j = 1; j <= n ;j++) {
        if (j >= i) {
          // minimum of previous solution or add one to [j - i]
          dp[j] = Math.min(dp[j], dp[j - i] + 1);
        }
      }
    }

    return dp[n];
  }
}
