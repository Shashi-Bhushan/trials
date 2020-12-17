package in.shabhushan.algo_trials.dynamic_programming.chapter9;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Knapsack {
  /**
   * Check recursive solution
   * First iteration is on value.length
   * then recursive call with reduced capacity
   *
   * Thus, dp[value.length][capacity] is memoized solution
   */
  public static int knapsack(int[] value, int[] weight, int capacity) {
    return knapsack(weight, value, value.length, capacity);
  }

  public static int knapsack(int[] weights, int[] values, int n, int maxWeight) {
    //Your code goes here
    if (n == 0) return 0;
    else if (maxWeight == 0) return 0;

    int val = 0;

    for (int i = 0; i < n; i++) {
      if (weights[i] <= maxWeight) {
        int w = weights[i];
        int v = values[i];

        values[i] = 0;
        weights[i] = Integer.MAX_VALUE;

        val = Math.max(val, knapsack(weights, values, n - 1, maxWeight - w) + v);

        values[i] = v;
        weights[i] = w;
      }
    }

    return val;
  }

  public static int knapsackDP(int[] value, int[] weight, int capacity) {
    if (capacity == 0) return 0;

    int[][] dp = new int[value.length + 1][capacity + 1];

    for (int i = 1; i <= value.length; i++) {
      for (int j = 1; j <= capacity; j++) {
        if (weight[i - 1] <= j) {
          dp[i][j] = Math.max(dp[i - 1][j], value[i - 1] + dp[i - 1][j - weight[i - 1]]);
        } else {
          dp[i][j] = dp[i - 1][j];
        }
      }
    }

    return dp[value.length][capacity];
  }
}
