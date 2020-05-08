package in.shabhushan.algo_trials.algorithms.chapter1.section1.exercise;

import static in.shabhushan.algo_trials.algorithms.chapter1.section1.exercise.Exercise24.gcd;

public class Exercise31 {
  public static boolean[][] createCoprimeArray(int n) {
    boolean[][] array = new boolean[n][n];

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        array[i][j] = isCoprime(i, j);
      }
    }

    return array;
  }

  public static boolean isCoprime(int i, int j) {
    if (i == j && j != 1)
      return false;

    return i == 0 || j == 0 || gcd(i, j) == 1;
  }

}
