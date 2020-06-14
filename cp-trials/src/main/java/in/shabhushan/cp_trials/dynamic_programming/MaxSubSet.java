package in.shabhushan.cp_trials.dynamic_programming;

import java.util.*;

class MaxSubSet {
  // Recursive Solution
  public static int maxSubsetSumNoAdjacent(int[] array) {
    if (array.length == 0) return 0;
    else if (array.length == 1) return array[0];
    else if (array.length == 2) return Math.max(array[0], array[1]);

    return Math.max(
        array[0] + maxSubsetSumNoAdjacent(Arrays.copyOfRange(array, 2, array.length)),
        array[1] + maxSubsetSumNoAdjacent(Arrays.copyOfRange(array, 3, array.length))
    );
  }

  // dp solution, O(N) Space
  public static int maxSubsetSumNoAdjacent2(int[] array) {
    if (array.length == 0) return 0;
    else if (array.length == 1) return array[0];

    int[] dp = new int[array.length];
    dp[0] = array[0];
    dp[1] = Math.max(array[0], array[1]);

    for (int i = 2; i < array.length; i++) {
      dp[i] = Math.max(dp[i - 1], dp[i - 2] + array[i]);
    }

    return dp[array.length - 1];
  }

  // dp solution, O(1) Space
  public static int maxSubsetSumNoAdjacent3(int[] array) {
    if (array.length == 0) return 0;
		else if (array.length == 1) return array[0];

		int first = array[0];
		int second = Math.max(array[0], array[1]);

		for (int i = 2; i < array.length; i++) {
			int temp = Math.max(second, array[i] + first);
			first = second;
			second = temp;
		}

		return second;
  }
}
