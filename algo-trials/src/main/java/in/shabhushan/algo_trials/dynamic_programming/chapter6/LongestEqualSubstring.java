package in.shabhushan.algo_trials.dynamic_programming.chapter6;

/**
 * Example 6.1
 * Find the length of longest substring of a given string of digits,
 * such that sum of digits in the first half and the second half is equal.
 */
public class LongestEqualSubstring {
  public static int getLongestEqualString(String string) {
    char[] chars = string.toCharArray();

    int maxLength = 0;

    // start of substring
    for (int i = 0; i < chars.length; i++) {
      // end of substring(j included)
      for (int j = i + 1; j < chars.length; j += 2) {
        int currentLength = j - i + 1;

        if (maxLength < currentLength) {
          int mid = currentLength / 2;

          int leftSum = 0;
          int rightSum = 0;
          for (int k = i; k < i + mid; k++) {
            leftSum += chars[k] - '0';
            rightSum += chars[mid + k] - '0';
          }

          if (leftSum == rightSum) {
            maxLength = currentLength;
          }
        }
      }
    }

    return maxLength;
  }
}
