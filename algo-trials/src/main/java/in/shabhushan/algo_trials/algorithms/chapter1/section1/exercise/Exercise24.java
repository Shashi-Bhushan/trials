package in.shabhushan.algo_trials.algorithms.chapter1.section1.exercise;

public class Exercise24 {
  /**
   * gcd(a, b) = gcd(b, a % b)
   */
  public static int gcd(int numerator, int denominator) {
    if (denominator == 0)
      return numerator;

    int r = numerator % denominator;
    return gcd(denominator, r);
  }
}
