package in.shabhushan.cp_trials.math.logic;


/**
 * Leetcode solution for
 * https://leetcode.com/problems/elimination-game/
 *
 * Idea is track start, end and step of the current iteration. when start meets the end, then only one element is remaining
 */
class EliminationGame {
  public int lastRemaining(int n) {
    if (n < 1)
      return 0;

    int head = 1;
    int tail = n;
    int step = 1;
    boolean startFromLeft = true;

    while (head != tail) {
      if (startFromLeft) {
        int temp = tail;
        tail = head + step;
        head = (n % 2 == 1) ? (temp - step) : temp;
      } else {
        int temp = tail;
        tail = head - step;
        head = (n % 2 == 1) ? (temp + step) : temp;
      }

      n = n / 2;
      startFromLeft = !startFromLeft;
      step *= 2;
    }

    return head;
  }
}
