package in.shabhushan.cp_trials.prefix_sum;

/**
 * Given a query [L, R], get sum of all composite numbers in this range.
 *
 * @see <a href="https://www.geeksforgeeks.org/sum-of-all-composite-numbers-lying-in-the-range-l-r-for-q-queries/">GFG</>
 */
public class CompositeNumbersSum {
  private static final int MAX_VALUE_OF_K = 100000;

  private static int[] prefixSum = new int[MAX_VALUE_OF_K];

  static {
    for (int i = 1; i < MAX_VALUE_OF_K; i++) {
      prefixSum[i] = prefixSum[i - 1] + returnIfComposite(i);
    }
  }

  private static int returnIfComposite(int k) {
    if (k == 2 || k == 3 || k == 1)
      return 0;

    if (k < 1 || k % 2 == 0 || k % 3 == 0)
      return k;

    for (int i = 5; i * i <= k; i += 6) {
      if (k % i == 0 || k % (i + 2) == 0)
        return k;
    }

    return 0;
  }

  public static int getCompositeNumbersSum(int leftBound, int rightBound) {
    return prefixSum[rightBound] - prefixSum[leftBound - 1];
  }
}
