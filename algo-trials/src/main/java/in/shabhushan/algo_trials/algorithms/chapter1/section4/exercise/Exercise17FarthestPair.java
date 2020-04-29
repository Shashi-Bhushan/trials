package in.shabhushan.algo_trials.algorithms.chapter1.section4.exercise;

public class Exercise17FarthestPair {
  /**
   * Given an unsorted double array, find the farthest two points.
   * Points whose difference is the maximum in all array.
   */
  public static double[] farthestPair(double[] array) {
    double min = array[0];
    double max = array[0];

    for (double num: array) {
      if (num < min) {
        min = num;
      }

      if (max < num) {
        max = num;
      }
    }

    return new double[]{min, max};
  }
}
