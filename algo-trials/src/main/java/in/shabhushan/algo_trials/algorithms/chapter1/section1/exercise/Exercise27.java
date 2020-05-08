package in.shabhushan.algo_trials.algorithms.chapter1.section1.exercise;

import edu.princeton.cs.algs4.StdOut;

public class Exercise27 {
  private static int count = 0;

  public static double binomial(int N, int k, double p,int count) {
    //Exercise27.count++;

    if ((N == 0) && (k == 0)) {
      //StdOut.println(String.format("==> %d - %d, N = %d, K = %d, p = %3.2f", Exercise27.count, count, N, k , p));
      return 1.0;
    }
    if ((N < 0) || (k < 0)) {
      // StdOut.println(String.format("%d - %d, N = %d, K = %d, p = %3.2f", Exercise27.count, count, N, k , p));
      return 0.0;
    }
    return (1 - p) * binomial(N - 1, k, p, count + 1) + p * binomial(N - 1, k - 1, p, count + 1);
  }
}
