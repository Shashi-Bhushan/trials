package in.shabhushan.cp_trials.competition.leetcode;

import java.util.ArrayList;
import java.util.List;

public class BiWeekly24 {
  /**
   * Leetcode Solution for
   * https://leetcode.com/contest/biweekly-contest-24/problems/find-the-minimum-number-of-fibonacci-numbers-whose-sum-is-k/
   */
  public static int findMinFibonacciNumbers(int k) {
    List<Integer> fib = getFibonacci(k);

    int i = 0;
    int j = fib.size() - 1;

    // subtract terms from k
    while (k > 0) {
      i += (k / fib.get(j));
      k %= fib.get(j);

      j--;
    }

    return i;
  }

  private static List<Integer> getFibonacci(int k) {
    List<Integer> fib = new ArrayList<Integer>();

    fib.add(1);
    fib.add(1);

    int index = 1;
    while (true) {
      int nextTerm = fib.get(index - 1) + fib.get(index);

      if (nextTerm <= k) {
        fib.add(nextTerm);
        index++;
      } else
        break;
    }

    return fib;
  }
}
