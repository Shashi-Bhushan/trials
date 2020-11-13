package in.shabhushan.algo_trials.clrs.chapter15;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

  public static Map.Entry<Integer, List<Integer>> rodCuttingWithSizes(int[] price) {
    int n = price.length;

    int[] dp = new int[n + 1];
    // s is index, where last cut was made for this size
    int[] s = new int[n + 1];

    dp[0] = 0;
    s[0] = 0;

    for (int i = 1; i <= n; i++) {
      int maxCutPrice = -1;

      int initialIndex = i - 1;

      for (int j = 0; j < i; j++) {
        int currentPrice = price[j] + dp[initialIndex - j];

        if (currentPrice > maxCutPrice) {
          maxCutPrice = currentPrice;
          s[i] = j + 1; // corresponding -1 in getRodList() when adding this to list
        }
      }

      dp[i] = maxCutPrice;
    }

    return Map.entry(dp[n], getRodList(s));
  }

  // s will hold where the last rod was cut
  private static List<Integer> getRodList(int[] rods) {
    int n = rods.length - 1;

    List<Integer> rodCuts = new ArrayList<>();

    while (n > 0) {
      rodCuts.add(rods[n] - 1);

      // go to n - rods[n] position to fetch largest cut made at that position
      n = n - rods[n];
    }

    return rodCuts;
  }
}
