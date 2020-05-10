package in.shabhushan.cp_trials.math.fundamental;

/**
 * Solution for
 * https://leetcode.com/problems/product-of-array-except-self/solution/
 */
public class ProductExceptSelf {
  public int[] productExceptSelf(int[] nums) {
    int mult = 0;

    for(int num: nums) {
      mult *= num;
    }

    final int mult2= mult;

    return java.util.Arrays.stream(nums).map(num -> mult2 / num).toArray();
  }

  /**
   * What if there are 0's in the array
   *
   * If there is a single zero in the list, every other elements will be zero expect for that
   * If there are more than one zero in the list, every element will be zero
   * Else we calculate prod = product of every element, answer is product divided by individual items
   */
  public int[] productExceptSelf2(int[] nums) {
    int product = 1;
    int numberOfZeros = 0;

    for (int num: nums) {
      if (num == 0)
        numberOfZeros++;

      product *= num;
    }

    int[] answer = new int[nums.length];

    for (int i = 0; i < nums.length; i++) {
      if (numberOfZeros == 0)
        answer[i] = product / nums[i];
      else if (numberOfZeros == 1 && nums[i] == 0)
        nums[i] = product;
      // else nums[i] will stay zero
    }

    return answer;
  }
}
