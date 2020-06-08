package in.shabhushan.algo_trials.dynamic_programming.chapter9;

public class CuttingRod {
  /**
   * Given an iron rod of certain length and price of selling rods of different length in the market,
   * how should we cut the rod so as to maximize the profit ?
   */
  public static int cutRod(int[] value, int length) {
    if (length == 0) return 0;

    int cost = 0;

    for (int i = 0; i < length; i++) {
      // length is 1-based
      if (i + 1 <= length) {
        cost = Math.max(cost, value[i] + cutRod(value, length - (i + 1)));
      }
    }

    return cost;
  }

  public static int cutRodDP(int[] value, int length) {
    if (length == 0) return 0;

    int[] dp = new int[length + 1];
    dp[0] = 0;

    for (int len = 1; len <= length; len++) {
      // length is 1-based
      for( int j = 0; j < len; j++) {
        dp[len] = Math.max(dp[len], value[j] + dp[len - (j + 1)]);
      }
    }

    return dp[length];
  }
}
