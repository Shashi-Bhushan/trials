package in.shabhushan.cp_trials.math.logic;

public class SingleElementInSortedArray {
  /**
   * Try to deduce the logic from these four examples
   *
   * Mid & Mid - 1 are equal
   * 1, 1, 2, 3 ,3 ,4 ,4, 5 ,5
   * 1, 1, 2, 2, 3, 3, 4
   *
   * Mid & Mid + 1 are equal
   * 1, 1, 2, 2, 3, 3, 4, 5, 5
   * 1, 1, 2, 3, 3, 4, 4, 5, 5
   */
  public static int singleNonDuplicate(int[] nums) {
    int low = 0;
    int high = nums.length - 1;

    while (low <= high) {
      int mid = low + (high - low) / 2;

      if (mid + 1 <= high && nums[mid] == nums[mid + 1]) {
        if (mid % 2 == 0)
          low = mid + 2;
        else
          high = mid - 1;
      } else if (low <= mid - 1 && nums[mid] == nums[mid - 1]) {
        if (mid % 2 == 0)
          high = mid - 2;
        else
          low = mid + 1;
      } else {

        return nums[mid];
      }
    }

    return -1;
  }
}
