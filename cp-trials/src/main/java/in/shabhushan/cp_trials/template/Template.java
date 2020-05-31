package in.shabhushan.cp_trials.template;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

// Solution
public class Template {
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
    int T = ni();

    for (int cas = 1; T > 0; T--, cas++) {
      // solve each test case
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

  static int ni() {
    return Integer.parseInt(in.next());
  }

  static void tr(Object... o) {
    if (!INPUT.isEmpty()) System.out.println(Arrays.deepToString(o));
  }
}
