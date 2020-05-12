package in.shabhushan.cp_trials.math.logic;

import java.util.ArrayDeque;

/**
 * Leetcode Solution for
 * https://leetcode.com/problems/daily-temperatures/
 */
public class DailyTemperature {
  public static int[] dailyTemperatures(int[] T) {
    int[] temp = new int[T.length];
    int x = T[T.length - 1];

    for (int i = 0; i < temp.length; i++) {
      temp[i] = T[i] - x;
    }

    int[] m = new int[T.length];

    for (int i = 0; i < temp.length; i++) {
      for (int j = i + 1; j < temp.length; j++) {
        if (temp[j] > temp[i]) {
          m[i] = j - i;
          break;
        }
      }
    }

    return m;
  }

  /**
   * Stack based approach
   *
   * The idea is consider an increasing and decreasing temperature as hills.
   * If i'm at a position in Hill and the hill is decreasing, I would blindly select the position just before me.
   * If I'm at a position which is increasing, I would need to get a position that I had visited earlier, which is either equal to or greater than my height.
   * That's where the stack will come into picture. Instead of doing a linear search, as in first case, I keep the height in stack.
   */
  public static int[] dailyTemperatures2(int[] temp) {

    int[] answer = new int[temp.length];

    ArrayDeque<Integer> s = new ArrayDeque<>();

    for (int i = temp.length - 1; i >=0; i--) {
      while (!s.isEmpty() && temp[i] >= temp[s.peek()])
        s.pop();

      answer[i] = s.isEmpty() ? 0 : s.peek() - i;

      s.push(i);
    }

    return answer;
  }
}
