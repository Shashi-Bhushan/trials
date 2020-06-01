package in.shabhushan.algo_trials.dynamic_programming.chapter8;

import java.util.Stack;

/**
 * NumWays(x,y) = 1 + min(
 *  NumWays(x +- 2,y -+ 1),
 *  NumWays(x +- 1,y +- 2)
 * );
 *
 * Check "Solution from first principles in Python" here
 * https://stackoverflow.com/a/41225769/2449146
 *
 * Also check
 * https://leetcode.com/problems/escape-a-large-maze
 * https://oeis.org/A065775
 * https://leetcode.com/discuss/interview-question/322837/Google-or-Onsite-interview-or-Knight's-Shortest-Path-on-an-Infinite-Chessboard
 */
public class MinimumChessMoveProblem {
  private static int[][] horseMoves = new int[][]{
      {2, 1},
      {2, -1},
      {1, 2},
      {1, -2}
  };

  public static int getMinimumChessMove(int[] start, int[] finish) {
    Stack<int[]> stack = new Stack<>();
    stack.add(start);

    int count = 0;
    while (!stack.isEmpty()) {
      int[] position = stack.pop();

      for (int[] move: horseMoves) {
        int[] newPosition = new int[2];
        newPosition[0] = position[0] + move[0];
        newPosition[1] = position[1] + move[1];

        /*if (isWithinBounds(newPosition) && newPosition[0] == finish[0] && newPosition[1] == finish[1]) {

        }*/
      }

      count++;
    }

    return count;
  }
}
