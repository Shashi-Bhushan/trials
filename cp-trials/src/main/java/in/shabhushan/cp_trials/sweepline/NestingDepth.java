package in.shabhushan.cp_trials.sweepline;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * Codejam Twenty Twenty Problem two -
 * https://codingcompetitions.withgoogle.com/codejam/round/000000000019fd27/000000000020bdf9
 */
public class NestingDepth {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    PrintStream out = System.out;

    int t = Integer.parseInt(input.nextLine());

    for (int i = 1; i <= t; i++) {
      String[] split = input.nextLine().split("");
      int[] array = Arrays.stream(split).mapToInt(Integer::valueOf).toArray();

      out.println(String.format("Case #%d: %s", i, solve(array)));
    }
  }

  public static String solve(int[] array) {
    StringBuilder sb = new StringBuilder();

    int a = 0;
    for (int i = 0; i < array.length; i++) {
      if (a < array[i]) {
        IntStream.range(0, array[i] - a).forEach(x -> sb.append("("));
        sb.append(array[i]);
      } else {
        IntStream.range(0, a - array[i]).forEach(x -> sb.append(")"));
        sb.append(array[i]);
      }

      a = array[i];
    }

    IntStream.range(0, a).forEach(x -> sb.append(")"));

    return sb.toString();
  }
}
