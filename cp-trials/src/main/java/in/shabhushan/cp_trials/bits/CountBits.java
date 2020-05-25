package in.shabhushan.cp_trials.bits;

/**
 * Leetcode solution for
 * https://leetcode.com/problems/counting-bits/submissions/
 */
class CountBits {
  public static int[] countBits(int num) {
    int[] n = new int[num + 1];

    for (int i = 1; i < num + 1; i++) {
      if (i % 2 == 0) {
        n[i] = n[i / 2];
      } else {
        n[i] = n[i/2] + 1;
      }
    }

    return n;
  }
}
