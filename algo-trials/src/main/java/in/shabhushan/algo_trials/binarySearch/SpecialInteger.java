package in.shabhushan.algo_trials.binarySearch;

public class SpecialInteger {
    private int[] arr;
    private int B;

    public int solve(int[] arr, int B) {
        int min = 0;
        int max = arr.length;

        this.arr = arr;
        this.B = B;

        int ans = 0;

        while (min <= max) {
            int mid = min + (max - min) / 2;

            if (feasible(mid)) {
                ans = mid;
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }

        return ans;
    }

    private boolean feasible(int mid) {
        long sum = 0;

        for (int i = 0; i < mid; i++) {
          sum += arr[i];
        }

        for (int i = mid; i < arr.length; i++) {
          if (sum > B) return false;
          else {
            sum -= arr[i - mid];
            sum += arr[i];
          }
        }

        return sum <= B;
    }
}
