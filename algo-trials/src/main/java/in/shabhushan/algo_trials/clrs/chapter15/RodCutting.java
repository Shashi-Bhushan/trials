package in.shabhushan.algo_trials.clrs.chapter15;

public class RodCutting {
  public static int rodCutting(int[] price) {
    int n = price.length;

    int[] dp = new int[n + 1];
    dp[0] = 0;

    for (int i = 1; i <= n; i++) {
      // price of cutting a rod at this length
      int maxCutPrice = -1;

      int initialIndex = i - 1;

      // j signifies i'm cutting rod at jth position. Rod sizes will be
      // [1, i - 1](if cut at 0th position), [2, i - 2], [3, i - 3]
      for (int j = 0; j < i; j++) {
        maxCutPrice = Math.max(maxCutPrice, price[j] + dp[initialIndex - j]);
      }

      dp[i] = maxCutPrice;
    }

    return dp[n];
  }
}
