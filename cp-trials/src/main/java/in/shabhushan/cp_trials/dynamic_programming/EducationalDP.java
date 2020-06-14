package in.shabhushan.cp_trials.dynamic_programming;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

// Solution
public class EducationalDP {
  private static Scanner in;
  private static PrintWriter out;
  private static final String INPUT = ""; // input file name

  /**
   * Interactive get next command
   */
  static int get(int pos) {
    out.println(pos + 1);
    out.flush();
    return ni();
  }

  static void solve() { }

  // Problem 1
  static void problem1() {
    int n = ni();
    int[] arr = new int[n];

    for (int i = 0; i < n; i++) {
      arr[i] = ni();
    }

    int[] dp = new int[n];
    dp[0] = 0;
    dp[1] = Math.abs(arr[1] - arr[0]);

    for (int i = 2; i < n ; i++) {
      dp[i] = Math.min(
          dp[i - 2] + Math.abs(arr[i] - arr[i - 2]),
          dp[i - 1] + Math.abs(arr[i] - arr[i - 1])
      );
    }

    out.println(dp[n - 1]);
  }

  // Problem 2
  static void problem2() {
    int n = ni();
    int k = ni();
    int[] arr = new int[n];

    for (int i = 0; i < n; i++) {
      arr[i] = ni();
    }

    int[] dp = new int[n];
    dp[0] = 0;
    dp[1] = Math.abs(arr[1] - arr[0]);

    for (int i = 1; i < n; i++) {
      int min = Integer.MAX_VALUE;

      for (int j = 1; j <= k; j++) {
        min = Math.min(min, dp[i - j] + Math.abs(arr[i] - arr[i - j]));

        if (i - j == 0)
          break;
      }

      dp[i] = min;
    }

    out.println(dp[n - 1]);
  }

  public static void main(String[] args) throws Exception {
    long S = System.currentTimeMillis();
    in = INPUT.isEmpty() ? new Scanner(System.in) : new Scanner(INPUT);
    out = new PrintWriter(System.out);

    solve();
    out.flush();
    long G = System.currentTimeMillis();
    tr(G - S + "ms");
  }

  private static int gcd(int a, int b) {
    while (b != 0) {
      int t = b;
      b = a % b;
      a = t;
    }

    return a;
  }

  private static int ni() {
    return Integer.parseInt(in.next());
  }

  private static long nl() {
    return Long.parseLong(in.next());
  }

  // Math Utils
  private static int pi(int num, int pow) {
    int result = 1;

    while (pow > 0) {
      if (pow % 2 == 1) {
        result *= num;
      }

      num *= num;
      pow /= 2;
    }

    return result;
  }

  private static int pim(int num, int pow, int mod) {
    int result = 1;

    while (pow > 0) {
      if (pow % 2 == 1) {
        // keep collecting `odd` num in result
        result = (result * num) % mod;
      }

      num = (num * num) % mod;
      pow /= 2;
    }

    return result;
  }

  private static long pl(long num, long pow) {
    long result = 1;

    while (pow > 0) {
      if (pow % 2 == 1) {
        result *= num;
      }

      num *= num;
      pow /= 2;
    }

    return result;
  }

  private static long plm(long num, long pow, long mod) {
    long result = 1;

    while (pow > 0) {
      if (pow % 2 == 1) {
        // keep collecting `odd` num in result
        result = (result * num) % mod;
      }

      num = (num * num) % mod;
      pow /= 2;
    }

    return result;
  }

  static void tr(Object... o) {
    if (!INPUT.isEmpty())
      out.println(Arrays.deepToString(o));
  }
}
