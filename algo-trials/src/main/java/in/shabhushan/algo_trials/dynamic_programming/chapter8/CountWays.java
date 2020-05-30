package in.shabhushan.algo_trials.dynamic_programming.chapter8;

/**
 * Given an empty plot of size 2 * n, we want to place tiles such that the entire plot is covered.
 * Each tile is of size 2 * 1 and can be placed either horizontally or vertically.
 * Find total number of ways to place such tiles
 */
public class CountWays {

  public static int countWays(int n) {
    if (n == 0 || n == 1 ||n == 2)
      return n;
    else {
      return countWays(n - 1) + countWays(n - 2);
    }
  }

  public static int countWaysDP(int n) {
    if (n == 0 || n == 1 ||n == 2)
      return n;

    int a = 1;
    int b = 2;
    for (int i = 2; i < n; i++) {
      b = a + b;
      a = b - a;
    }

    return b;
  }
}
