package in.shabhushan.cp_trials.search;

public class BinarySearch {
  /**
   * Leetcode solution for https://leetcode.com/problems/search-in-rotated-sorted-array/discuss/587138/Java-Binary-search-over-sorted-circular-array
   *
   * Given input = [4,5,6,7,0,1,2], find the index of target = 0
   * Given input = [3, 1], find the index of target = 0
   * @param nums
   * @param target
   * @return
   */
  public int searchOverSortedCircularArray(int[] nums, int target) {
    int left = 0;
    int right = nums.length - 1;

    while (left <= right) {
      int mid = left + (right - left) / 2;

      if (nums[mid] == target)
        return mid;
      else if (nums[mid] < nums[right]) {
        // This means right side is the sorted side
        // Check if the target exist in this range
        if (nums[mid] < target && target <= nums[right])
          left = mid + 1;
        else
          right = mid - 1;
      } else {
        // This means left side is the sorted side
        // check if target exist in this range
        if (nums[left] <= target && target < nums[mid])
          right = mid - 1;
        else
          left = mid + 1;
      }
    }

    return -1;
  }
}
