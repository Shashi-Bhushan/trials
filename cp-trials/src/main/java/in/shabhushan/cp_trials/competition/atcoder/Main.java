package in.shabhushan.cp_trials.competition.atcoder;

import java.io.PrintWriter;
import java.util.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.mapping;

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
    int n = ni();
    int m = ni();

    Map<Integer, Set<Integer>> adj = new HashMap<>();

    for (int i = 1; i <= n; i++) {
      adj.put(i, new HashSet<>());
    }

    for (int i = 0; i < m; i++) {
      adj.get(ni()).add(ni());
    }

    boolean[] visited = new boolean[n];
    int[] score = new int[n];
    int max = 0;


    for (int i = 1; i <= n; i++) {
      max = Math.max(max, helper(adj, i, visited, score));
    }

    out.println(max);
  }

  static int helper(Map<Integer, Set<Integer>> adj, int index, boolean[] visited, int[] score) {
    if (!visited[index - 1]) {
      int max = 0;

      // get all adjacents of index
      for (int neighbour: adj.get(index)) {
        max = Math.max(max, 1 + helper(adj, neighbour, visited, score));
      }

      visited[index - 1] = true;
      score[index - 1] = max;
    }

    return score[index - 1];
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

  private static String ns() {
    return in.nextLine();
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
