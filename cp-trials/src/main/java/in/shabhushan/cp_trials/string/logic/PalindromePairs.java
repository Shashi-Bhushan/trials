package in.shabhushan.cp_trials.string.logic;

import java.util.*;

/**
 * Solution for Leetcode problem 336
 * https://leetcode.com/problems/palindrome-pairs/
 */
public class PalindromePairs {
  public static List<List<Integer>> palindromePairs(String[] words) {

    Map<String, Integer> m = new HashMap<>();

    for (int i = 0; i < words.length; i++) {
      m.put(words[i], i);
    }

    List<List<Integer>> answer = new ArrayList<>();

    for (int i = 0; i < words.length; i++) {
      String word = words[i];
      String reverse = reverse(word);

      for (int j = 0; j < reverse.length(); j++) {
        String suffix = reverse.substring(j);

        if (m.containsKey(suffix) && m.get(suffix) != i && isPalindrome(word + suffix)) {
          List<Integer> l = List.of(i, m.get(suffix));
          if (!answer.contains(l))
            answer.add(l);
        }

        String prefix = reverse.substring(0, j + 1);

        if (m.containsKey(prefix) && m.get(prefix) != i && isPalindrome(prefix + word)) {
          List<Integer> l = List.of(m.get(prefix), i);
          if (!answer.contains(l))
            answer.add(l);
        }
      }

      if (m.containsKey("") && m.get("") != i && isPalindrome(word)) {
        answer.add(List.of(m.get(""), i));
        answer.add(List.of(i, m.get("")));
      }
    }

    //answer.sort((a, b) -> a.get(0).compareTo(b.get(0)));

    return answer;
  }

  private static boolean isPalindrome(String string) {
    for (int i = 0; i < string.length() / 2; i++) {
      if (string.charAt(i) != string.charAt(string.length() - i - 1))
        return false;
    }

    return true;
  }

  private static String reverse(String string) {
    return new StringBuilder(string).reverse().toString();
  }

  public static List<List<Integer>> palindromePairs2(String[] words) {
    List<List<Integer>> answer = new ArrayList<>();

    for (int i = 0; i < words.length - 1; i++) {
      for (int j = i + 1; j < words.length; j++) {
        if (isPalindrome2(words[i], words[j])) {
          answer.add(List.of(i, j));
        }

        if (isPalindrome2(words[j], words[i])) {
          answer.add(List.of(j, i));
        }
      }
    }

    return answer;
  }

  /**
   * Based on the idea that in order to check if the combination of two strings are palindrome,
   * I don't actually need to create a new String. I could get the individual characters and compare.
   */
  private static boolean isPalindrome2(String firstWord, String secondWord) {
    int start = 0;
    int end = firstWord.length() + secondWord.length() - 1;

    while (start <= end) {
      char a = (start < firstWord.length()) ? firstWord.charAt(start) : secondWord.charAt(start - firstWord.length());
      char b = (firstWord.length() <= end) ? secondWord.charAt(end - firstWord.length()) : firstWord.charAt(end);

      if (a != b)
        return false;


      start++;
      end--;
    }

    return true;
  }
}
