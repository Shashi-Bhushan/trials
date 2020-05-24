package in.shabhushan.cp_trials.prefix_sum;

import java.util.Set;

/**
 * Leetcode solution for
 * https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/
 */
public class MaximumNumberVowels {
  private static Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');

  public static int maxVowels(String s, int k) {
    int[] rank = new int[s.length() + 1];

    for (int i = 0; i < s.length(); i++) {
      rank[i + 1] = rank[i] + ((vowels.contains(s.charAt(i))) ? 1 : 0);
    }

    int max = 0;
    for (int i = k; i <= s.length(); i++) {
      max = Math.max(max, rank[i] - rank[i - k]);
    }

    return max;
  }

  public static int maxVowels2(String s, int k) {
    int t = 0;
    int max = 0;

    for (int i = 0; i < k; i++) {
      if (vowels.contains(s.charAt(i))) {
        t++;
      }
    }

    int last = 0;
    max = Math.max(max, t);

    for (int i = k; i < s.length(); i++) {
      if (vowels.contains(s.charAt(last))) {
        t--;
      }

      if (vowels.contains(s.charAt(i))) {
        t++;
      }

      last++;
      max = Math.max(max, t);
    }

    return max;
  }
}
