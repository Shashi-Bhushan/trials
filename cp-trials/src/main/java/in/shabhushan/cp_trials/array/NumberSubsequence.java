package in.shabhushan.cp_trials.array;

import java.util.*;


/**
 * Leetcode solution for
 * https://leetcode.com/contest/weekly-contest-195/problems/number-of-subsequences-that-satisfy-the-given-sum-condition/
 * <p>
 * Check this for reference
 * https://www.youtube.com/watch?v=nxWT_mG-x54
 */
class NumberSubsequence {
  public int numSubseq(int[] a, int target) {
    Arrays.sort(a);

    int n = a.length;
    int p = n - 1;

    long ans = 0;
    long mod = 1000000007;

    for (int i = 0; i < n; i++) {
      while (p >= 0 && a[i] + a[p] > target)
        p--;

      if (i > p)
        break;

      ans += pow(2, p - i, mod);
    }

    return (int) (ans % mod);
  }

  public long pow(long a, long n, long mod) {
    //		a %= mod;
    long ret = 1;
    int x = 63 - Long.numberOfLeadingZeros(n);
    for (; x >= 0; x--) {
      ret = ret * ret % mod;
      if (n << 63 - x < 0)
        ret = ret * a % mod;
    }
    return ret;
  }
}
