package in.shabhushan.cp_trials.string;

import java.util.Arrays;

/**
 * Leetcode solution for
 * https://leetcode.com/problems/letter-tile-possibilities/
 */
class LetterTilePossibilities {
  public int numTilePossibilities(String tiles) {
    if (tiles == null || tiles.length() == 0)
      return 0;
    
    char[] c = tiles.toCharArray();
    
    boolean[] visited = new boolean[c.length];
    
    Arrays.sort(c);

    // subtract by 1 to remove empty sequence from result
    return helper(c, visited) - 1;
  }
  
  private int helper(char[] c, boolean[] visited) {
    int ans = 1;
    for (int i = 0; i < c.length; i++) {
      if (visited[i])
        continue;
      
      visited[i] = true;
      
      ans = ans + helper(c, visited);
      
      visited[i] = false;
      
      while (i + 1 < c.length && c[i] == c[i + 1])
        i++;
    }
    
    return ans;
  }

  /**
   * Since we are asked sequences and not the sub sequence of the original String, we could shuffle the characters in original string to get a new String
   * Hence, we only need consider the frequencies of the letter involved
   */
  public int numTilePossibilities2(String tiles) {
    if (tiles == null || tiles.length() == 0)
      return 0;

    int[] freq = new int[26];

    for (char c: tiles.toCharArray()) {
      freq[c - 'A']++;
    }

    return helper(freq) - 1;
  }

  private int helper(int[] freq) {
    int ans = 1;
    for (int i = 0; i < 26; i++) {
      if (freq[i] > 0) {
        freq[i]--;

        ans += helper(freq);

        freq[i]++;
      }
    }

    return ans;
  }
}
