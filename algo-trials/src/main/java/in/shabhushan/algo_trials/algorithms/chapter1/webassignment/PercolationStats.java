package in.shabhushan.algo_trials.algorithms.chapter1.webassignment;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {

  private final double mean;
  private final double standardDeviation;
  private final double confidenceLow;
  private final double confidenceHigh;

  /**
   * perform independent trials on an n-by-n grid
   */
  public PercolationStats(int gridSize, int trials) {
    if (gridSize <= 0) {
      throw new IllegalArgumentException("err-invalid-grid-size");
    }
    if (trials <= 0) {
      throw new IllegalArgumentException("err-invalid-number-of-experiments");
    }

    double[] threshold = new double[trials];

    for (int i = 0; i < trials; i++) {
      threshold[i] = performTrial(gridSize);
    }

    mean = StdStats.mean(threshold);
    standardDeviation = StdStats.stddev(threshold);

    double confidenceFraction = (1.96 * standardDeviation) / Math.sqrt(trials);
    confidenceLow = mean - confidenceFraction;
    confidenceHigh = mean + confidenceFraction;
  }

  private static double performTrial(int gridSize) {
    Percolation percolation = new Percolation(gridSize);

    int runs = 0;
    while (!percolation.percolates()) {
      int[] openSite = findOpenSite(percolation, gridSize);
      int row = openSite[0];
      int col = openSite[1];

      percolation.open(row, col);
      runs++;
    }

    return runs / (double) (gridSize * gridSize);
  }

  private static int[] findOpenSite(Percolation percolation, int gridSize) {
    int row = 1 + StdRandom.uniform(gridSize);
    int col = 1 + StdRandom.uniform(gridSize);

    // choose new site while you don't find a close one
    while (percolation.isOpen(row, col)) {
      row = 1 + StdRandom.uniform(gridSize);
      col = 1 + StdRandom.uniform(gridSize);
    }

    return new int[]{row, col};
  }

  // sample mean of percolation threshold
  public double mean() {
    return mean;
  }

  // sample standard deviation of percolation threshold
  public double stddev() {
    return standardDeviation;
  }

  // low endpoint of 95% confidence interval
  public double confidenceLo() {
    return confidenceLow;
  }

  // high endpoint of 95% confidence interval
  public double confidenceHi() {
    return confidenceHigh;
  }

  public static void main(String[] args) {
    int gridSize = Integer.parseInt(args[0]);
    int trials = Integer.parseInt(args[1]);

    PercolationStats stats = new PercolationStats(gridSize, trials);
    System.out.println("mean                    = " + stats.mean());
    System.out.println("stddev                  = " + stats.stddev());
    System.out.println("95% confidence interval = " + stats.confidenceLo() + ", " + stats.confidenceHi());
  }
}
