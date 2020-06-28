package in.shabhushan.cp_trials.string;

import java.util.*;

/**
 * Leetcode solution for
 * https://leetcode.com/problems/remove-duplicate-letters/submissions/
 *
 * Same as in/shabhushan/cp_trials/string/SmallestSubsequence.java
 * with more test cases
 */
class RemoveDuplicateString {
  public String removeDuplicateLetters(String text) {
    if (text.length() < 2) 
      return text;
    
    char[] arr = text.toCharArray();
    
    int[] freq = new int[26];
    boolean[] visited = new boolean[26];
    
    for (char c: arr) {
      freq[c - 'a']++;
    }
    
    StringBuilder sb = new StringBuilder();
    
    for (int i = 0; i < arr.length; i++) {
      freq[arr[i] - 'a']--;
      
      if (!visited[arr[i] - 'a']) {
        char lastChar = (sb.length() > 0) ? sb.charAt(sb.length() - 1) : ' ';
        
        while (sb.length() > 0 && arr[i] < lastChar && freq[lastChar - 'a'] > 0) {
          visited[lastChar - 'a'] = false;
          sb.deleteCharAt(sb.length() - 1);

          lastChar = (sb.length() > 0) ? sb.charAt(sb.length() - 1) : ' ';
        }

        sb.append(arr[i]);
        visited[arr[i] - 'a'] = true;
      }
    }
    
    return sb.toString();
  }

  public String removeDuplicateLetters2(String text) {
    if (text.length() < 2)
      return text;

    boolean[] hasAll = hasAll(text);

    int minIndex = 0;

    for (int i = 1; i < text.length(); i++) {
      if (hasAll[i] && text.charAt(i) < text.charAt(minIndex))
        minIndex = i;
    }

    String cur = String.valueOf(text.charAt(minIndex));

    return cur + removeDuplicateLetters(text.substring(minIndex + 1).replaceAll(cur, ""));
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
