package in.shabhushan.cp_trials.binarySearch;

/**
 * Leetcode solution for
 * https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/submissions/
 *
 * Binary search over height and check how many are more than the given height
 */
class Mbouquet {
  public int minDays(int[] bloomDay, int m, int k) {
    if (m * k > bloomDay.length) return -1;

    int low = 0, high = Integer.MAX_VALUE;

    for (int i: bloomDay) {
        high = Math.max(high, i);
        low = Math.min(low, i);
    }

    while (low < high) {
      int mid = (low + high) >> 1;

      if (highEnough(mid, bloomDay, m, k)) {
        high = mid;
      } else {
        low = mid + 1;
      }
    }

    return high;
  }

  private boolean highEnough(int h, int[] arr, int m, int k) {
    int count = 0;
    int finalCount = 0;

    for (int a: arr) {
      if (a <= h) {
        count++;

        if (count == k) {
          finalCount++;
          count = 0;
        }
      } else {
        count = 0; // not adjacent
      }
    }

    return finalCount >= m;
  }
}
