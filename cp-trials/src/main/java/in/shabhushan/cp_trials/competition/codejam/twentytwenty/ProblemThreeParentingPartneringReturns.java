package in.shabhushan.cp_trials.competition.codejam.twentytwenty;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Codejam solution for
 * https://codingcompetitions.withgoogle.com/codejam/round/000000000019fd27/000000000020bdf9
 */
public class ProblemThreeParentingPartneringReturns {
  private static class Interval implements Comparable<Interval> {
    int start;
    int end;
    int position;

    public Interval(int start, int end, int position) {
      this.start = start;
      this.end = end;
      this.position = position;
    }

    @Override
    public int compareTo(Interval interval) {
      return this.start - interval.start;
    }
  }

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    PrintStream out = System.out;

    int t = Integer.parseInt(input.nextLine());

    for (int i = 1; i <= t; i++) {
      int n = input.nextInt();

      int[][] matrix = new int[n][2];

      Interval[] intervals = new Interval[n];

      for (int row = 0; row < n; row++) {
        for (int j = 0; j < 2; j++) {
          matrix[row][j] = input.nextInt();
        }

        intervals[row] = new Interval(matrix[row][0], matrix[row][1], row);
      }

      out.println(String.format("Case #%d: %s", i, solve(intervals)));
    }
  }

  public static String solve(Interval[] intervals) {
    Arrays.sort(intervals);

    int c = 0;
    int j = 0;

    char[] chars = new char[intervals.length];
    for (Interval interval: intervals) {
      if (c <= interval.start) {
        chars[interval.position] = 'C';
        c = interval.end;
      } else if (j <= interval.start) {
        chars[interval.position] = 'J';
        j = interval.end;
      } else {
        return "IMPOSSIBLE";
      }
    }

    return new String(chars);
  }
}
