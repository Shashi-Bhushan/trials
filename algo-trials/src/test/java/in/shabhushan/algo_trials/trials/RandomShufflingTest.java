package in.shabhushan.algo_trials.trials;

import edu.princeton.cs.algs4.StdOut;
import org.junit.Test;

import java.util.Arrays;

import static in.shabhushan.algo_trials.trials.RandomShuffling.*;

public class RandomShufflingTest {

  @Test
  public void testRandomNumberGenerator() {
    int[] result = pseudoRandomNumberGenerator(100, 3, 5);

    StdOut.println(Arrays.toString(result));
  }

  @Test
  public void testEBadShuffle() {
    int numTrials = 200000;
    int n = 5;
    int[][] positions = nonRandomShuffle(numTrials, n);

    StdOut.println("BAD SHUFFLE RESULT :: ");
    StdOut.println(String.format("N = %d, M = %d, N/M = %3.3f", numTrials, n, (double)numTrials / n));
    printTable(positions, (double)numTrials / n);
  }

  @Test
  public void testEmpiricalShuffle() {
    int numTrials = 200000;
    int n = 5;
    int[][] positions = empiricalShuffle(numTrials, n);

    StdOut.println("GOOD SHUFFLE RESULT :: ");
    StdOut.println(String.format("N = %d, M = %d, N/M = %3.3f", numTrials, n, (double)numTrials / n));
    printTable(positions, (double)numTrials / n);
  }

  private static void printTable(int[][] positions, double numTrialsByM) {
    StdOut.println("TABLE");

    for (int i = 0; i < positions.length; i++) {
      StdOut.printf("%c  ", 'A' + i);

      for (int j = 0; j < positions[0].length; j++) {
        StdOut.printf("%04.3f ", (positions[i][j]/ numTrialsByM) * 100);
      }
      StdOut.println();
    }
  }
}
