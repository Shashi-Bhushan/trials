package in.shabhushan.cp_trials.competition.codejam.twentytwenty;

import java.io.PrintStream;
import java.util.*;

public class ProblemOneVestigium {

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    PrintStream out = System.out;

    int t = input.nextInt();

    for (int i = 1; i <= t; i++) {
      int n = input.nextInt();

      int[][] matrix = new int[n][n];

      for (int row = 0; row < n; row++) {
        for (int j = 0; j < n; j++) {
          matrix[row][j] = input.nextInt();
        }
      }

      int[] ans = solve(matrix);

      StringJoiner joiner = new StringJoiner(" ");
      Arrays.stream(ans).forEach(s -> joiner.add(String.valueOf(s)));

      out.println(String.format("Case #%d: %s", i, joiner.toString()));
    }
  }

  public static int[] solve(int[][] matrix) {
    int trace = 0;

    for (int i = 0; i < matrix.length; i++) {
      trace += matrix[i][i];
    }

    return new int[]{trace, count(matrix, (m, i, j) -> m[i][j]), count(matrix, (m, i, j) -> m[j][i])};
  }

  private static int count(int[][] matrix, TwoArgIntOperator supplier) {
    int count = 0;

    for (int i = 0; i < matrix.length; i++) {
      Set<Integer> set = new HashSet<>();

      for (int j = 0; j < matrix[i].length; j++) {
        set.add(supplier.op(matrix, i, j));
      }

      if (set.size() != matrix.length)
        count++;
    }

    return count;
  }

  public interface TwoArgIntOperator {
    public int op(int[][] matrix, int a, int b);
  }
}
