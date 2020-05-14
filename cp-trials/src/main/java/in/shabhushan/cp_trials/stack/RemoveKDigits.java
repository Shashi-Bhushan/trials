package in.shabhushan.cp_trials.stack;

import java.util.*;

/**
 * Leetcode solution for
 * https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/535/week-2-may-8th-may-14th/3328/
 *
 * Check https://www.youtube.com/watch?v=BbNS_sKBAqo for reference
 */
class RemoveKDigits {
  public static String removeKdigits(String num, int k) {
    ArrayDeque<Integer> stack = new ArrayDeque<>();

    for (char c: num.toCharArray()) {
      int x = c - '0';
      while (k > 0 && !stack.isEmpty() && stack.peek() > x) {
        stack.pop();
        k--;
      }

      if (stack.isEmpty() && x == 0) {
        // do nothing
      }
      else
        stack.push(x);
    }

    while (k-- > 0 && !stack.isEmpty())
      stack.pop();

    StringBuilder sb = new StringBuilder();

    while (!stack.isEmpty()) {
      sb.append(String.valueOf(stack.pop()));
    }

    sb.reverse();
    return (sb.length() == 0) ? "0" : sb.toString();
  }
}
