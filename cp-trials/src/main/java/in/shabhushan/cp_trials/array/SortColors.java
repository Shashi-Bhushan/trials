package in.shabhushan.cp_trials.array;

/**
 * Leetcode solution for
 * https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/540/week-2-june-8th-june-14th/3357/
 *
 * Dutch National Flag problem
 */
class SortColors {
  public void sortColors(int[] nums) {
    int low = 0;
    int mid = 0;
    int high = nums.length - 1;

    while (mid <= high) {
      if (nums[mid] == 0) {
        swap(nums, low, mid);
        low++;
        mid++;
      } else if (nums[mid] == 1) {
        mid++;
      } else {
        swap(nums, mid, high);
        high--;
      }
    }
  }

  private void swap(int[] nums, int l, int r) {
    int temp = nums[l];
    nums[l] = nums[r];
    nums[r] = temp;
  }
}
