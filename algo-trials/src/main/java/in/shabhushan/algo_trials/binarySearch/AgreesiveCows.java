package in.shabhushan.algo_trials.binarySearch;

import java.util.Arrays;

public class AgreesiveCows {
  private int[] arr;
  private int B;

  /**
   * O[
   *  NlogN + // sorting
   *  log(10^9) * [B * log (10^9)] // searching
   * ]
   *
   * 10^9 is maximum size of the array ARR
   */
  public int solve(int[] arr, int B) {
    Arrays.sort(arr);

    int n = arr.length;
    this.arr = arr;
    this.B = B;

    int min = 0;
    int max = (arr[n - 1] - arr[0]) / (B - 1);

    int ans = min;

    while (min <= max) {
      int mid = min + (max - min) / 2;

      if (isFeasible(mid)) {
        ans = mid;
        min = mid + 1;
      } else {
        max = mid - 1;
      }
    }

    return ans;
  }

  /**
   * O[B * log(10^9)]
   * @param mid
   * @return
   */
  private boolean isFeasible(int mid) {
    int count = 1;
    int currentIndex = 0;

    //System.out.println("mid " + mid);

    while (count < B) {
      int nextIndex = higher(arr[currentIndex] + mid);

      if (nextIndex == -1) return false;

      currentIndex = nextIndex;
      count++;
    }

    return true;
  }

  /**
   * Equal or higher element
   * O(log(10^9))
   */
  private int higher(int val) {
    int min = 0;
    int max = arr.length - 1;

    int ans = -1;

    while (min <= max) {
      int mid = min + (max - min) / 2;

      if (arr[mid] == val) {
        return mid;
      } else if (arr[mid] > val) {
        ans = mid;
        max = mid - 1;
      } else {
        min = mid + 1;
      }
    }

    return ans;
  }
}
