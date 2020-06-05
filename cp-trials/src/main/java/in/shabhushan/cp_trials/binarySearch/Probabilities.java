package in.shabhushan.cp_trials.binarySearch;

import java.util.Arrays;

/**
 * Leetcode solution for
 * https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/539/week-1-june-1st-june-7th/3351/
 *
 * Random Pick with Weight
 * Check this https://leetcode.com/problems/random-pick-with-weight/discuss/671445/Question-explained
 */
public class Probabilities {
  private double[] prob;

  public Probabilities(int[] w) {
    prob = new double[w.length];

    double sum = Arrays.stream(w).sum();

    prob[0] = w[0]/sum;
    for (int i = 1; i < w.length; i++) {
      w[i] += w[i - 1];
      prob[i] = w[i] / sum;
    }
  }

  public int pickIndex() {
    return Math.abs(Arrays.binarySearch(prob, Math.random())) - 1;
  }
}
