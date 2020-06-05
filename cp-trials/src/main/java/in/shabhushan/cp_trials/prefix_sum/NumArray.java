package in.shabhushan.cp_trials.prefix_sum;

/**
 * Leetcode solution for
 * https://leetcode.com/problems/range-sum-query-immutable/
 */
class NumArray {

  private int[] pSum;

  public NumArray(int[] nums) {
    pSum = new int[nums.length + 1];

    for (int i = 1; i <= nums.length; i++) {
      pSum[i] = pSum[i - 1] + nums[i - 1];
    }
  }

  public int sumRange(int i, int j) {
    return pSum[j + 1] - pSum[i];
  }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */
