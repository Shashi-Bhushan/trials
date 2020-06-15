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

  // Problem 3 - Recursive and iterative DP
  static void problem3() {
    int n = ni();
    int[][] arr = new int[n][3];

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < 3; j++) {
        arr[i][j] = ni();
      }
    }

//    out.println(Math.max(
//        helper(arr, n - 2, 0, arr[n-1][0]),
//        Math.max(
//            helper(arr, n - 2, 1, arr[n-1][1]),
//            helper(arr, n - 2, 2, arr[n-1][2])
//        )
//    ));

    int[][] dp = new int[n + 1][3];

    // dp[i] = dp[i-1] + max(a[i],b[i],c[i])

    for (int i = 1; i <= n; i++) {
      for (int j = 0; j < 3; j++) {
        // Add arr[i - 1][0] to all the previous 3 dp and check which one is max

        for (int prev = 0; prev < 3; prev++) {
          if (j == prev) continue; // if prev is same, don't add

          dp[i][j] = Math.max(dp[i][j], dp[i - 1][prev] + arr[i - 1][j]);
        }
      }
    }

    out.println(Math.max(
        dp[n][0],
        Math.max(dp[n][1], dp[n][2])
    ));
  }

  static int helper(int[][] arr, int row, int choice, int max) {
    if (row < 0) {
      return max;
    }

    if (choice == 0) {
      return Math.max(
          helper(arr, row - 1, 1, max + arr[row][1]),
          helper(arr, row - 1, 2, max + arr[row][2])
      );
    } else if (choice == 1) {
      return Math.max(
          helper(arr, row - 1, 0, max + arr[row][0]),
          helper(arr, row - 1, 2, max + arr[row][2])
      );
    } else {
      return Math.max(
          helper(arr, row - 1, 0, max + arr[row][0]),
          helper(arr, row - 1, 1, max + arr[row][1])
      );
    }
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
