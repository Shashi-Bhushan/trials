package in.shabhushan.algo_trials.algorithms.chapter1.section1.exercise;

import edu.princeton.cs.algs4.StdRandom;

public class Exercise36 {
  private Exercise36(){}

  public static int[][] empiricalShuffle(int n, int m) {
    int[][] positions = new int[m][m];

    int[] array = new int[m];

    for (int i = 0 ; i < n; i++) {
      initializeArray(array);
      shuffle(array);

      for (int j = 0 ; j < array.length; j++) {
        positions[array[j]][j]++;
      }
    }

    return positions;
  }

  private static void initializeArray(int[] array) {
    for (int i = 0; i < array.length; i++) {
      array[i] = i;
    }
  }

  private static void shuffle(int[] array) {
    for (int i = 0; i < array.length; i++) {
      // BAD SHUFFLING
      // int randomIndex = StdRandom.uniform(n)
      int randomIndex = i + StdRandom.uniform(array.length - i);

      int temp = array[randomIndex];
      array[randomIndex] = array[i];
      array[i] = temp;
    }
  }
}
