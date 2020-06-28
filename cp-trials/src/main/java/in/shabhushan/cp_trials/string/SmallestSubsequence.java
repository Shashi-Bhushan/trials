package in.shabhushan.cp_trials.string;

import java.util.*;

/**
 * Leetcode solution for
 * https://leetcode.com/problems/smallest-subsequence-of-distinct-characters/
 *
 * Check this for reference
 * https://leetcode.com/problems/smallest-subsequence-of-distinct-characters/discuss/675261/Java-Two-solutions-explained.-Clean-java-code
 */
class SmallestSubsequence {
  public String smallestSubsequence(String text) {
    if (text.length() < 2)
      return text;
    
    boolean[] hasAll = hasAll(text);
    
    int minIndex = 0;
    
    for (int i = 1; i < text.length(); i++) {
      if (hasAll[i] && text.charAt(i) < text.charAt(minIndex))
        minIndex = i;
    }
    
    String cur = String.valueOf(text.charAt(minIndex));
    
    return cur + smallestSubsequence(text.substring(minIndex + 1).replaceAll(cur, ""));
  }
  
  private boolean[] hasAll(String text) {
    boolean[] hasAll = new boolean[text.length()];
    
    int distinct = (int)text.chars().distinct().count();
    Set<Character> set = new HashSet<>();
    
    for (int i = text.length() - 1; i >= 0; i--) {
      set.add(text.charAt(i));
      
      if (set.size() == distinct) {
        // set all from 0 to i to true now
        while (i >= 0) {
          hasAll[i] = true;
          i--;
        }
      }
    }
    
    return hasAll;
  }
}
