package in.shabhushan.algo_trials.algorithms.chapter1.webassignment;

import org.junit.Test;

public class PercolationStatsTest {
  @Test
  public void testPercolation() {
    PercolationStats stats = new PercolationStats(200, 100);
    System.out.println("mean                    = " + stats.mean());
    System.out.println("stddev                  = " + stats.stddev());
    System.out.println("95% confidence interval = " + stats.confidenceLo() + ", " + stats.confidenceHi());
  }
}
