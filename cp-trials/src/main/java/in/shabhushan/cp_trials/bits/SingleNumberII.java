package in.shabhushan.cp_trials.bits;

/**
 * Leetcode solution for
 * https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/542/week-4-june-22nd-june-28th/3368/
 *
 * check this for reference
 * https://www.youtube.com/watch?v=IoF-FIQuFT0
 */
class SingleNumberII {
  public int singleNumber(int[] nums) {
    int result = 0;

    for (int bit = 0; bit < 32; bit++) {
      // set bit of mask
      int mask = (1 << bit);
      int bitCount = 0;

      for (int num: nums) {
        if ((num & mask) != 0) {
          bitCount++;
        }
      }

      if (bitCount % 3 != 0) {
        // set bit of result
        result = (result | mask);
      }
    }

    return result;
  }
}
