package in.shabhushan.algo_trials.algorithms.chapter1.section4;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;
import org.junit.Ignore;
import org.junit.Test;

import static in.shabhushan.algo_trials.algorithms.chapter1.section4.ThreeSum.count;

/**
 * For my machine this prints
 *
 * elapsed time for n = 1000 is 0.309
 * 74
 * elapsed time for n = 2000 is 2.439
 * 497
 * elapsed time for n = 4000 is 19.178
 * 3956
 * elapsed time for n = 8000 is 152.076
 * 32042
 * elapsed time for n = 250 is 0.005
 * 1
 * elapsed time for n = 500 is 0.038
 * 9
 *
 * Clearly, there is significant difference when n is 2000 and when n is 4000, more so when it's 8000
 */
public class ThreeSumTest {
  private static final int MAXIMUM_INTEGER = 1000000;

  @Test
  public void testThreeSumFor250() {
    int n = 250;

    performTrial(n);
  }

  @Test
  public void testThreeSumFor500() {
    int n = 500;

    performTrial(n);
  }

  @Test
  public void testThreeSumFor1000() {
    int n = 1000;

    performTrial(n);
  }

  @Ignore
  @Test
  public void testThreeSumFor2000() {
    int n = 2000;

    performTrial(n);
  }

  @Ignore
  @Test
  public void testThreeSumFor4000() {
    int n = 4000;

    performTrial(n);
  }

  @Ignore
  @Test
  public void testThreeSumFor8000() {
    int n = 8000;

    performTrial(n);
  }

  private void performTrial(int n) {
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = StdRandom.uniform(-MAXIMUM_INTEGER, MAXIMUM_INTEGER);
    }

    Stopwatch timer = new Stopwatch();
    int count = count(a);
    StdOut.println("elapsed time for n = " + n + " is " + timer.elapsedTime());
    StdOut.println(count);
  }
}
