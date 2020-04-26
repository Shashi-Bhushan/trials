package in.shabhushan.algo_trials.trials;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

import java.util.Arrays;

/**
 * Leetcode solution for
 * https://leetcode.com/contest/weekly-contest-186/problems/maximum-points-you-can-obtain-from-cards/
 */
class MaxScore {
  private static int maxScoreRecurCount = 0;

  private interface Score {
    int maxScore(int[] cards, int k);
  }

  private static class LinearScore implements Score {
    /**
     * For input of size 51 and k 5 :: time - 0.000000, Log (time) - -Infinity :: -
     * For input of size 51 and k 10 :: time - 0.000000, Log (time) - -Infinity :: - Ratio (time) NaN, Ratio (Log time), NaN
     * For input of size 51 and k 15 :: time - 0.000000, Log (time) - -Infinity :: - Ratio (time) NaN, Ratio (Log time), NaN
     * For input of size 51 and k 20 :: time - 0.000000, Log (time) - -Infinity :: - Ratio (time) NaN, Ratio (Log time), NaN
     * For input of size 51 and k 25 :: time - 0.000000, Log (time) - -Infinity :: - Ratio (time) NaN, Ratio (Log time), NaN
     * For input of size 51 and k 30 :: time - 0.000000, Log (time) - -Infinity :: - Ratio (time) NaN, Ratio (Log time), NaN
     * For input of size 51 and k 35 :: time - 0.000000, Log (time) - -Infinity :: - Ratio (time) NaN, Ratio (Log time), NaN
     */
    public int maxScore(int[] cards, int k) {
      int n = cards.length;

      int[] c = new int[n + 1];

      for (int i = 0; i < n; i++) {
        c[i + 1] = c[i] + cards[i];
      }

      int ans = 0;

      for (int i = 0; i <= k; i++) {
        // This means at i = 0, I choose 0 coins from left and k - 0 from right
        ans = Math.max(ans, c[i] + c[n] - c[n - (k - i)]);
      }

      return ans;
    }
  }

  /**
   * Backtracking solution, TLE
   */
  private static class ExponentialScore implements Score {
    /**
     * In the exponential solution, since I'm checking for numChoosen > k, Thus the running time only depends on k and not on n.
     * If you will create a tree for the call stack, you would see that the function is called exactly [2^(k+1) - 1] times
     * k = 2, 7 times called
     * k = 3, 15 times called
     * k = 4, 31 times called
     *
     * For input of size 51 and k 5 :: time - 0.000000, Log (time) - -Infinity :: -
     * For input of size 51 and k 10 :: time - 0.001000, Log (time) - -6.907755 :: - Ratio (time) Infinity, Ratio (Log time), Infinity
     * For input of size 51 and k 15 :: time - 0.008000, Log (time) - -4.828314 :: - Ratio (time) 8.000000, Ratio (Log time), 2.079442
     * For input of size 51 and k 20 :: time - 0.091000, Log (time) - -2.396896 :: - Ratio (time) 11.375000, Ratio (Log time), 2.431418
     * For input of size 51 and k 25 :: time - 1.108000, Log (time) - 0.102557 :: - Ratio (time) 12.175824, Ratio (Log time), 2.499452
     * For input of size 51 and k 30 :: time - 24.238000, Log (time) - 3.187922 :: - Ratio (time) 21.875451, Ratio (Log time), 3.085365
     */
    public int maxScore(int[] cardPoints, int k) {
      int answer = score(cardPoints, 0, 0, k);
      System.out.println("Max Score Backtracking solution is called " + maxScoreRecurCount + " times.");
      maxScoreRecurCount = 0;
      return answer;
    }

    private int score(int[] cards, int total, int numChoosen, int k) {
      maxScoreRecurCount++;
      if (numChoosen == k)
        return total;
      if (numChoosen > k || cards.length == 0)
        return 0;

      return Math.max(
          score(Arrays.copyOfRange(cards, 1, cards.length), total + cards[0], numChoosen + 1, k),
          score(Arrays.copyOfRange(cards, 0, cards.length - 1), total + cards[cards.length - 1], numChoosen + 1, k)
      );
    }
  }

  public static void testForK(Score score) {
    int[][] inputCards = new int[][]{
//        {99, 82, 25, 56, 39, 77, 22, 58, 64, 77, 19, 36},
//        {99, 82, 25, 56, 39, 77, 22, 58, 64, 77, 19, 36},
//        {99, 82, 25, 56, 39, 77, 22, 58, 64, 77, 19, 36, 93, 14, 19, 12, 94, 76, 93, 24, 92, 67, 18, 37, 37, 60, 87, 28, 64, 7, 29},
//        {99, 82, 25, 56, 39, 77, 22, 58, 64, 77, 19, 36, 93, 14, 19, 12, 94, 76, 93, 24, 92, 67, 18, 37, 37, 60, 87, 28, 64, 7, 29},
//        {99, 82, 25, 56, 39, 77, 22, 58, 64, 77, 19, 36, 93, 14, 19, 12, 94, 76, 93, 24, 92, 67, 18, 37, 37, 60, 87, 28, 64, 7, 29, 36, 456, 789, 883, 67, 34, 1, 0, 101, 209, 345, 345, 456, 675, 0, 1, 23, 12, 11, 22},
//        {99, 82, 25, 56, 39, 77, 22, 58, 64, 77, 19, 36, 93, 14, 19, 12, 94, 76, 93, 24, 92, 67, 18, 37, 37, 60, 87, 28, 64, 7, 29, 36, 456, 789, 883, 67, 34, 1, 0, 101, 209, 345, 345, 456, 675, 0, 1, 23, 12, 11, 22},
//        {99, 82, 25, 56, 39, 77, 22, 58, 64, 77, 19, 36, 93, 14, 19, 12, 94, 76, 93, 24, 92, 67, 18, 37, 37, 60, 87, 28, 64, 7, 29, 36, 456, 789, 883, 67, 34, 1, 0, 101, 209, 345, 345, 456, 675, 0, 1, 23, 12, 11, 22},
//        {99, 82, 25, 56, 39, 77, 22, 58, 64, 77, 19, 36, 93, 14, 19, 12, 94, 76, 93, 24, 92, 67, 18, 37, 37, 60, 87, 28, 64, 7, 29, 36, 456, 789, 883, 67, 34, 1, 0, 101, 209, 345, 345, 456, 675, 0, 1, 23, 12, 11, 22},
        {99, 82, 25, 56, 39, 77, 22, 58, 64, 77, 19, 36, 93, 14, 19, 12, 94, 76, 93, 24, 92, 67, 18, 37, 37, 60},
        {99, 82, 25, 56, 39, 77, 22, 58, 64, 77, 19, 36, 93, 14, 19, 12, 94, 76, 93, 24, 92, 67, 18, 37, 37, 60, 87, 28, 64, 7, 29, 36, 456, 789, 883, 67, 34},
        {99, 82, 25, 56, 39, 77, 22, 58, 64, 77, 19, 36, 93, 14, 19, 12, 94, 76, 93, 24, 92, 67, 18, 37, 37, 60, 87, 28, 64, 7, 29, 36, 456, 789, 883, 67, 34, 1, 0, 101, 209, 345, 345, 456, 675, 0, 1, 23, 12, 11, 22}
    };

    int[] inputk = new int[]{
        4, 4, 4
    };

    double[] watch = new double[inputk.length];
    for (int i = 0; i < inputk.length; i++) {
      Stopwatch stopwatch = new Stopwatch();
      score.maxScore(inputCards[i], inputk[i]);
      watch[i] = stopwatch.elapsedTime();

      String format = "";
      if (i != 0) {
        double ratio = watch[i] / watch[i - 1];
        format = String.format("Ratio (time) %f, Ratio (Log time), %f", ratio, Math.log(ratio));
      }

      StdOut.println(String.format("For input of size %d and k %d :: time - %f, Log (time) - %f :: - %s",
          inputCards[i].length, inputk[i], watch[i], Math.log(watch[i]), format));
    }
  }

  public static void main(String[] args) {
    testForK(new ExponentialScore());
  }
}
