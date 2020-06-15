package in.shabhushan.cp_trials.competition.atcoder;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

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
    int items = ni();
    int capacity = ni();
    int[][] arr = new int[items][2];

    for (int i = 0; i < items; i++) {
      for (int j = 0; j < 2; j++) {
        arr[i][j] = ni();
      }
    }

    // dp[item][weight] i.e. row is items (empty item set to all item set) and column is weight (0 to capacity)
    // For each item, solve for weight 1, then weight 2 then 3 etc
    long[][] dp = new long[items + 1][capacity + 1];

    for (int i = 1; i <= items; i++) {
      for (int j = 1; j <= capacity; j++) {
        int[] currentElement = arr[i - 1];

        // current weight <= capacity weight
        if (currentElement[0] <= j) {
          // check if the value increases by adding this item's value
          dp[i][j] = Math.max(
              dp[i - 1][j], // previous value i.e. current item is not added in knapsack
              // remove current item weight from knapsack and add current item value to it
              currentElement[1] + dp[i - 1][j - currentElement[0]]
          );
        } else {
          // i.e. current item weight is more, can't add this item. choose ans from previous item selection
          dp[i][j] = dp[i - 1][j];
        }
      }
    }

    out.println(dp[items][capacity]);
    //out.println(helper(arr, capacity));
  }

  /*
   * weight is how much more i can carry
   */
  static int helper(int[][] arr, int weight) {
    if (weight == 0) {
      return 0;
    }

    int maxValue = 0;

    for (int i = 0; i < arr.length; i++) {
      if (arr[i][0] <= weight) {
        // update arr
        List<List<Integer>> n = Arrays.stream(arr).map(x -> Arrays.stream(x).boxed().collect(Collectors.toList())).collect(Collectors.toList());
        n.remove(i);

        int[][] ints = n.stream()
            .map(l -> l.stream().mapToInt(Integer::intValue).toArray())
            .toArray(int[][]::new);

        // Add current value, ask the helper again by removing current entry from arr and reducing weight
        maxValue = Math.max(maxValue, arr[i][1] + helper(ints, weight - arr[i][0]));
      }
    }

    return maxValue;
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
