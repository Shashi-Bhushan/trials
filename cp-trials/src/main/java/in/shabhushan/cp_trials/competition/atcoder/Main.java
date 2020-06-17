package in.shabhushan.cp_trials.competition.atcoder;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

// Solution
public class Main {
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

  static void solve() {
    int h = ni();
    int w = ni();

    // is this empty space
    boolean[][] arr = new boolean[h][w];
    for (int i = 0; i < h; i++) {
      char[] split = in.next().toCharArray();
      int j = 0;

      for (char s : split) {
        arr[i][j++] = s == '.';
      }
    }

    long[][] dp = new long[h][w];
    dp[0][0] = 1;

    for (int i = 1; i < h; i++)
      dp[i][0] = arr[i][0] ? dp[i - 1][0] : 0;
    for (int j = 1; j < w; j++)
      dp[0][j] = arr[0][j] ? dp[0][j - 1] : 0;

    int mod = (int) 1e9 + 7;

    for (int i = 1; i < h; i++) {
      for (int j = 1; j < w; j++) {
        dp[i][j] = arr[i][j] ? (dp[i][j - 1] % mod + dp[i - 1][j] % mod) % mod : 0;
      }
    }

    out.println(dp[h - 1][w - 1]);
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
    return in.nextInt();
  }

  private static String nt() {
    return in.next();
  }

  private static String ns() {
    return in.nextLine();
  }

  private static long nl() {
    return in.nextLong();
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
