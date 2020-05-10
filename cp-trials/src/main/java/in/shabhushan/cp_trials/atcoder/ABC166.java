package in.shabhushan.cp_trials.atcoder;

/**
 * Atcoder begineer competition 166
 */
public class ABC166 {
  /**
   * Solution for I hate Factorization
   * Assuming a will always be positive and b could be positive or negative.
   *
   * Note: vise versa is also true. A could be negative and b positive.
   */
  public static long[] problemD(int x) {
    for (int i = 1; i < 178; i++) {
      long a = (long) Math.pow(i, 5);

      for (int j = -178; j < 178; j++) {
        long b = (long) Math.pow(j, 5);

        if (a - b == x) {
          return new long[]{i, j};
        }
      }
    }

    return null;
  }
}
