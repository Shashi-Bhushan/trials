package in.shabhushan.cp_trials.prefix_sum;

import java.util.Set;

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
}
