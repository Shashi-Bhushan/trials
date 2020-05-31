package in.shabhushan.algo_trials.dynamic_programming.chapter6;

import java.util.Arrays;

/**
 * Example 6.1
 * Find the length of longest substring of a given string of digits,
 * such that sum of digits in the first half and the second half is equal.
 *
 * Also see solutions on https://www.geeksforgeeks.org/longest-even-length-substring-sum-first-second-half/
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

  public static int maxSubstringLengthDP(String string) {
    char[] chars = string.toCharArray();

    int[][] sum = new int[chars.length][chars.length];

    for (int i = 0; i < chars.length; i++) {
      sum[i][i] = chars[i] - '0';
    }

    int maxLength = 0;
    for (int len = 2; len <= chars.length; len++) {
      int mid = len / 2;

      for (int i = 0; i < chars.length - len + 1; i++) {
        int j = i + len - 1;
        // Both give same result
        //sum[i][j] = sum[i][j - 1] + sum[i + len - 1][j];
        sum[i][j] = sum[i][j - mid] + sum[j - mid + 1][j];

        if (len % 2 == 0 && len > maxLength) {
          if (sum[i][j - mid] == sum[j - mid + 1][j])
            maxLength = len;
        }
      }
    }

    return maxLength;
  }
}
