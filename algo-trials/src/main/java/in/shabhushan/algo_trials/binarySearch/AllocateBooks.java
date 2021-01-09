package in.shabhushan.algo_trials.binarySearch;

public class AllocateBooks {
  private int[] arr;
  private int[] prefixSum;
  private int B; //num Students

  private int currentMin;

  public int books(int[] arr, int B) {
    if (B > arr.length) return -1;

    this.prefixSum = new int[arr.length + 1];
    this.arr = arr;
    this.B = B;

    for (int i = 1; i <= arr.length; i++) {
      prefixSum[i] += prefixSum[i - 1] + arr[i - 1];
    }

    int min = 0;
    int max = prefixSum[arr.length];

    // assign all books with all pages to one single student as initial solution
    currentMin = max;

    while (min <= max) {
      int mid = min + (max - min) / 2;

      if (feasible(mid)) {
        //currentMax = mid;
        max = mid - 1;
      } else {
        min = mid + 1;
      }
    }

    return currentMin;
  }

  private boolean feasible(int mid) {
    int count = 1; // start assigning books to first student
    int currentIndex = 0;

    int minimumPages = 0;

    while (currentIndex < prefixSum.length - 1) {
      if (count > B) {
        // books are left to be distributed but no students left
        return false;
      }

      int nextIndex = lower(prefixSum[currentIndex] + mid);

      // maximum of the pages assigned to any student in this round
      minimumPages = Math.max(minimumPages, prefixSum[nextIndex] - prefixSum[currentIndex]);

      currentIndex = nextIndex;
      count++;
    }

    // is the maximum pages assigned less than the current selected answer?
    currentMin = Math.min(minimumPages, currentMin);

    return true;
  }

  // find the value in prefix sum lower or equal to this
  private int lower(int val) {
    int min = 0;
    int max = prefixSum.length - 1;

    int ans = 0;

    while (min <= max) {
      int mid = min + (max - min) / 2;

      if (prefixSum[mid] == val) {
        return mid;
      } else if (prefixSum[mid] < val) {
        ans = mid;
        min = mid + 1;
      } else {
        max = mid - 1;
      }
    }

    return ans;
  }
}
