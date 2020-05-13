package in.shabhushan.cp_trials.binarySearch;

/**
 * Leetcode solution for
 * https://leetcode.com/problems/find-peak-element/submissions/
 */
class FindPeakElement {
  /**
   * Based on the fact that
   * 1. if array is size 1, 0 is the answer.
   * 2. if array is size 2, whichever index has max element is the answer.
   * 3. if 0th index is greater than 1st index, that's the answer.
   * 4. if last index is greater than second last index, that's the answer.
   * 5. Else do a binary search and find the element
   *
   * Trick with binary search is find the middle is in an increasing slope of decreasing slope.
   * If it's in increasing slope, go to right to find peak of this slope.
   * if it's in decreasing slope, go to left to find the peak of this slope.
   * you are guaranteed to find the peak since it's increasing or decreasing. (if mid itself is not the peak of courseaaa)
   */
  public static int findPeakElement(int[] nums) {
    if (nums.length == 1)
      return 0;
    else if (nums.length == 2) {
      if (nums[0] > nums[1])
        return 0;
      else return 1;
    }

    if (nums[0] > nums[1])
      return 0;
    if (nums[nums.length - 1] > nums[nums.length - 2])
      return nums.length - 1;

    int low = 0;
    int high = nums.length - 1;

    while (low <= high) {
      int mid = low + (high - low) / 2;

      if (mid == 0) {
        if (nums[mid] > nums[mid + 1])
          return mid;
        else
          return low = mid + 1;
      } else if (mid == nums.length - 1) {
        if (nums[mid] > nums[mid - 1])
          return mid;
        else
          return high = mid - 1;
      }

      if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1])
        return mid;

      else if (nums[mid - 1] < nums[mid] && nums[mid] < nums[mid + 1]) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }

    }

    return -1;
  }
}
