package in.shabhushan.cp_trials.string;

import java.util.*;

/**
 * Leetcode solution for
 * https://leetcode.com/problems/repeated-substring-pattern/
 */
class RepeatedSubstringPattern {

  /**
   * Rabin karp method
   * - Instead of moving sliding window by 1, we move it by length of substring pattern
   * - if we reach the end of the string with this sliding window, that means the pattern is repeated here
   *
   * Note that we are using the hashcode method of String here.
   * We do .equals only when we reach the end and hashcode is also equal
   *
   */
  public boolean repeatedSubstringPattern(String s) {
    int n = s.length();
    if (n < 2) return false;
    else if (n == 2) return s.charAt(0) == s.charAt(1);
    else {
      int i = (int)Math.sqrt(n);
      
      while (i > 0) {
        if (n % i == 0) {
          List<Integer> divisors = new ArrayList<>();
          
          divisors.add(i);
          if (i != 1)
            divisors.add(n / i);
          
          for (int l: divisors) {
            String firstString = s.substring(0, l);
            int firstHash = firstString.hashCode();
            
            int currentHash = firstHash;
            int start = l;
            
            String temp = firstString;
            while (start != n && currentHash == firstHash) {
              temp = s.substring(start, start + l);
              currentHash = temp.hashCode();
              start += l;
            }
            
            if (start == n && currentHash == firstHash && firstString.equals(temp))
              return true;
          }
        }
        
        i--;
      }
      
      return false;
    }
  }

  /**
   * The key to KMP is the partial match table, often called lookup table, or failure function table. It stores the length of the longest prefix that is also a suffix.
   */
  public boolean repeatedSubstringPatternKMP(String s) {
    int n = s.length();
    if (n < 2) return false;
    else if (n == 2) return s.charAt(0) == s.charAt(1);
    else {
      int[] dp = new int[n];

      dp[0] = 0;

      for (int i = 1; i < n; i++) {
        int j = dp[i - 1];

        while (j > 0 && s.charAt(i) != s.charAt(j))
          j = dp[j - 1];

        if (s.charAt(i) == s.charAt(j))
          j++;

        dp[i] = j;
      }

      return dp[n - 1] != 0 && n % (n - dp[n - 1]) == 0;
    }
  }
}
