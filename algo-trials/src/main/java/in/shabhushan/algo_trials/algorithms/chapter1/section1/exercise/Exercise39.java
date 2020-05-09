package in.shabhushan.algo_trials.algorithms.chapter1.section1.exercise;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

public class Exercise39 {
  public static int[] mainExperiment(int trials) {
    int n1 = (int) Math.pow(10, 3);
    int n2 = (int) Math.pow(10, 4);
    int n3 = (int) Math.pow(10, 5);
    int n4 = (int) Math.pow(10, 6);

    int[] results = new int[4];

    for (int i = 0; i < trials; i++) {
      results[0] += experiment(n1);
      results[1] += experiment(n2);
      results[2] += experiment(n3);
      results[3] += experiment(n4);
    }

    return results;
  }

  private static int experiment(int n) {
    int[] array1 = new int[n];
    int[] array2 = new int[n];

    for (int i = 0; i < n; i++) {
      array1[i] = StdRandom.uniform(100000, 1000000);
      array2[i] = StdRandom.uniform(100000, 1000000);
    }

    Arrays.sort(array1);
    Arrays.sort(array2);

    int numInBoth = 0;

    for (int i = 0; i < n; i++) {

      if (binarySearch(array1[i], array2, 0, array2.length -1)) {
        numInBoth++;
      }

    }

    return numInBoth;
  }

  private static boolean binarySearch(int key, int[] arr, int low, int high) {

    boolean found = false;

    if (low <= high) {
      int mid = low + (high - low) / 2;

      if (key < arr[mid]) {
        binarySearch(key, arr, low, mid - 1);
      } else if (key > arr[mid]) {
        binarySearch(key, arr, mid + 1, high);
      } else {
        found = true;
      }
    }

    return found;
  }
}
