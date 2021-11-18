package in.shabhushan.algo_trials.dynamic_programming.knapsack;

import java.util.Map;

public class Knapsack {
  /**
   * Check recursive solution
   * First iteration is on value.length
   * then recursive call with reduced capacity
   *
   * Thus, dp[value.length][capacity] is memoized solution
   * youtube.com/watch?v=kvyShbFVaY8&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=3
   */
  public static int knapsack(int[] value, int[] weight, int capacity) {
    return knapsack(weight, value, value.length - 1, capacity);
  }

  public static int knapsack(int[] weights, int[] values, int n, int capacity) {
    //Your code goes here
    if (n < 0 || capacity == 0) return 0;

    if (weights[n] <= capacity) {
      return Math.max(
          values[n] + knapsack(weights, values, n - 1, capacity - weights[n]),
          knapsack(weights, values, n - 1, capacity)
      );
    } else {
      return knapsack(weights, values, n - 1, capacity);
    }
  }

  private boolean isAllZeros(Map<Character, Integer> map) {
    return map.entrySet().stream().allMatch(val -> val.getValue() == 0);
  }

  public static int knapsackDP(int[] value, int[] weight, int capacity) {
    if (capacity == 0) return 0;

    int[][] dp = new int[value.length + 1][capacity + 1];

    for (int i = 1; i <= value.length; i++) {
      for (int j = 1; j <= capacity; j++) {
        if (weight[i - 1] <= j) {
          dp[i][j] = Math.max(
              value[i - 1] + dp[i - 1][j - weight[i - 1]],
              dp[i - 1][j]
          );
        } else {
          dp[i][j] = dp[i - 1][j];
        }
      }
    }

    return dp[value.length][capacity];
  }
}
