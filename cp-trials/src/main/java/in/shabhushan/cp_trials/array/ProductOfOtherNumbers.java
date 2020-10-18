package in.shabhushan.cp_trials.array;

public class ProductOfOtherNumbers {
  public static int[] productOfOtherNumbers(int[] arr) {
    int[] ans = new int[arr.length];

    int prod = 1;
    for (int i = 0; i < arr.length; i++) {
      ans[i] = prod;

      prod *= arr[i];
    }

    prod = 1;
    for (int i = arr.length - 1; i >= 0; i--) {
      ans[i] *= prod;

      prod *= arr[i];
    }

    return ans;
  }
}
