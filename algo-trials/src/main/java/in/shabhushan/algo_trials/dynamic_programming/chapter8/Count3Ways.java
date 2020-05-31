package in.shabhushan.algo_trials.dynamic_programming.chapter8;

/**
 * Given an empty plot of size 3 * n, we want to place tiles such that the entire plot is covered.
 * Each tile is of size 2 * 1 and can be placed either horizontally or vertically.
 * Find total number of ways to place such tiles
 *
 * https://algorithmist.com/wiki/UVa_10918_-_Tri_Tiling
 * https://cs.stackexchange.com/questions/42170/why-do-these-recurrences-determine-the-number-of-ways-of-tiling-a-3xn-rectangle
 */
public class Count3Ways {
  public static int count3Ways(int n) {
    if (n < 0) return 0;
    else return f(n);
  }

  private static int f(int n) {
    if (n == 0) return 1;
    else if (n == 1) return 0;
    else return f(n - 2) + 2 * g(n - 1);
  }

  private static int g(int n) {
    if (n == 0) return 0;
    else if (n == 1) return 1;
    else return f(n - 1) + g(n - 2);
  }

  public static int count3WaysIterative(int n) {
    if (n < 0)
      return 0;

    int[] f = new int[31];
    int[] g = new int[31];

    f[0] = 1;
    f[1] = 0;
    g[0] = 0;
    g[1] = 1;

    for (int i = 2; i <= n; i++) {
      f[i] = f[i - 2] + 2 * g[i - 1];
      g[i] = f[i - 1] + g[i - 2];
    }

    return f[n];
  }
}
