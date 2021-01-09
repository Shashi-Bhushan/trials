package in.shabhushan.algo_trials.binarySearch;

public class PainterProblem {
  private int[] arr;
  private long[] prefixSum;
  private int A;
  private int B;

  private static final long MOD = 10000003;

  public int paint(int A, int B, int[] arr) {
    this.arr = arr;
    this.B = B;
    this.A = A;

    this.prefixSum = new long[arr.length + 1];

    for (int i = 1; i <= arr.length; i++) {
      prefixSum[i] = (prefixSum[i - 1] + arr[i - 1]) % MOD;
    }

    long low = 0;
    long high = (prefixSum[prefixSum.length - 1] * B);

    long ans = high % MOD;

    while (low <= high) {
      long mid = low + (high - low) / 2;

      boolean feasible = feasible(mid);
      // if all painters can finish the job given `mid` amount of time
      if (feasible) {

        ans = mid % MOD;
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }

    return (int) (ans % MOD);
  }

  private boolean feasible(long mid) {
    long temp = mid / B;

    int i = 0;
    int count = 1; // first painter starts painting

    while (i < arr.length) {
      if (count > A) {
        return false;
      }

      // if this boat will take lesser time to paint
      if (arr[i] <= temp) {
        // reduce this time from painter's time
        temp -= arr[i];
        i++;
      } else {
        count++;
        temp = mid / B;
      }
    }

    return true;
  }

  public int paint2(int A, int B, int[] arr) {
    int n = arr.length;

    this.arr = arr;
    this.prefixSum = new long[n + 1];
    this.A = A;
    this.B = B;

    for (int i = 1; i <= n; i++) {
      prefixSum[i] = prefixSum[i - 1] + arr[i - 1];
    }

    // no painter will do the job, hence 0 time
    long low = 0;
    // all jobs to be finished by only one painter, hence the total sum
    long high = prefixSum[n] * B;

    int ans = (int)(high % MOD);

    while (low <= high) {
      // can all painters finish all jobs in `mid` amount of time
      long mid = low + (high - low) / 2;

      if (feasible2(mid / B)) {
        ans = (int)(mid % MOD);
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }

    return ans;
  }

  private boolean feasible2(long mid) {
    int currentIndex = 0;
    int count = 1; // first painter start painting the boat

    while (currentIndex < prefixSum.length - 1) {
      if (count > A) return false;

      int nextIndex = lower(prefixSum[currentIndex] + mid);

      currentIndex = nextIndex;
      count++;
    }

    return true;
  }

  /**
   * index of the element lower than or equal to element
   */
  private int lower(long element) {
    int low = 0;
    int high = prefixSum.length - 1;

    // index of the element lower than or equal to element
    int ans = 0;

    while (low <= high) {
      int mid = low + (high - low) / 2;

      if (prefixSum[mid] == element) {
        return mid;
      } else if (prefixSum[mid] < element) {
        ans = mid;
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }

    return ans;
  }
}
