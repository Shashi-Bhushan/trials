package in.shabhushan.algo_trials.dynamic_programming.chapter8;

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
 */
public class MinimumChessMoveProblem {

}
