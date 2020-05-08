package in.shabhushan.algo_trials.algorithms.chapter1.section1.exercise;

import edu.princeton.cs.algs4.StdOut;
import org.junit.Test;

import static in.shabhushan.algo_trials.algorithms.chapter1.section1.exercise.Exercise36.empiricalShuffle;

public class Exercise36Test {
  @Test
  public void testEmpiricalShuffle() {
    int n = 200000;
    int m = 5;
    int[][] positions = empiricalShuffle(200000, 5);

    StdOut.println(String.format("N = %d, M = %d, N/M = %3.3f", n, m, (double)n / m));
    printTable(positions);
  }

  private static void printTable(int[][] positions) {
    StdOut.println("TABLE");

    for (int i = 0; i < positions.length; i++) {
      StdOut.printf("%3d  ", i);

      for (int j = 0; j < positions[0].length; j++) {
        StdOut.printf("%4d ", positions[i][j]);
      }
      StdOut.println();
    }
  }
}
