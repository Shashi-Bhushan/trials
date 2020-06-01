package in.shabhushan.cp_trials.dynamic_programming;

import java.util.Arrays;

public class CoinChange {
  public static int coinChangeRecursiveWithMemoization(int[] coins, int x) {
    int[] memory = new int[x + 1];
    Arrays.fill(memory, -1);
    memory[0] = 0;

    return solve(coins, x, memory);
  }

  private static int solve(int[] coins, int x, int[] memory) {
    //System.out.println("Solve called for " + x);
    if (x < 0) {
      return 100_00_00; // prevents overflow
    } else if (x == 0) {
      return 0;
    } else if (memory[x] != -1) {
      return memory[x];
    }

    int best = Integer.MAX_VALUE;
    for (int coin: coins) {
      best = Math.min(best, solve(coins, x - coin, memory) + 1);
    }

    memory[x] = best;
    //System.out.println("Solving for x " + x + " best " + best);
    return best;
  }

  public static int coinChangeIterative(int[] coins, int x) {
    int[] memory = new int[x + 1];
    memory[0] = 0;

    for (int i = 1; i <= x; i++) {
      memory[i] = 100_00_00;

      // for each coin, check the min value required
      for (int coin: coins) {
        if (i - coin >= 0) {
          memory[i] = Math.min(memory[i], memory[i - coin] + 1);
        }
      }
    }

    return memory[x];
  }

  public static CoinChangeSolution coinChangeIterativeWithCounting(int[] coins, int target) {
    int[] memory = new int[target + 1];
    memory[0] = 0;

    int[] sequence = new int[target + 1];

    for (int i = 1; i <= target; i++) {
      memory[i] = 100_00_00;

      // for each coin, check the min value required
      for (int coin: coins) {
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
   * Total number of ways to form the target
   */
  public static int totalWaysCoinChange(int[] coins, int target) {
    int[] memory = new int[target + 1];
    memory[0] = 1;

    for (int i = 1; i <= target; i++) {
      for (int coin: coins) {
        if (i - coin >= 0) {
          memory[i] += memory[i - coin];
        }
      }
    }

    return memory[target];
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

      for (int coin: coins) {
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

      for (int coin: coins) {
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

    for (int coin: coins) {
      for (int amt = 1; amt <= target; amt++) {
        if (amt >= coin) {
          dp[amt] += dp[amt - coin];
        }
      }
    }

    return dp[target];
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
      for (int coin: coins) {
        if (amt >= coin) {
          dp[amt] += dp[amt - coin];
        }
      }
    }

    return dp[target];
  }
}
