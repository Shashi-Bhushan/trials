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
    if (capacity == 0) return 0;

    int maxValue = 0;

    for (int i = 0; i < value.length; i++) {
      if (weight[i] <= capacity) {
        // Remove i from weight and value array
        List<Integer> updatedWeights = Arrays.stream(weight).boxed().collect(Collectors.toList());
        updatedWeights.remove(i);

        List<Integer> updatedValues = Arrays.stream(value).boxed().collect(Collectors.toList());
        updatedValues.remove(i);

        maxValue = Math.max(maxValue, value[i] +
            knapsack(updatedValues.stream().mapToInt(x -> x).toArray(), updatedWeights.stream().mapToInt(x -> x).toArray(), capacity - weight[i])
        );
      }
    }

    return maxValue;
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
