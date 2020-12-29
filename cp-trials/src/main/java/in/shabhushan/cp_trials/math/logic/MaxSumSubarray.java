package in.shabhushan.cp_trials.math.logic;

/**
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6
 */
public class MaxSumSubarray {
  public static int sequence(int[] array) {
    int maxSoFar = 0;
    int maxEnding = 0;

    for (int element : array) {
      maxEnding += element;

      if (maxEnding < 0) {
        maxEnding = 0;
      }

      if (maxSoFar < maxEnding) {
        maxSoFar = maxEnding;
      }
    }

    return maxSoFar;
  }

  public static int maxsumSubArrayWithPositiveNegative(int[] array) {
    int maxSoFar = array[0];
    int maxHere = array[0];

    for (int i = 1; i < array.length; i++) {
      maxHere = Math.max(maxHere + array[i], array[i]);
      maxSoFar = Math.max(maxSoFar, maxHere);
    }

    return maxSoFar;
  }
}
