package in.shabhushan.algo_trials.algorithms.chapter1.section1.exercise;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

import java.util.Arrays;

public class Exercise38 {

  public static void calculateTime(int key, int[] array) {
    // Sort the array
    Arrays.sort(array);

    long startTime = System.nanoTime();

    bruteForceSearch(key, array);

    long endTime = System.nanoTime();
    long duration = (endTime - startTime);

    StdOut.println("BRUTEFORCE :: Time Duration: " + duration + " nanoseconds.");

    startTime = System.nanoTime();

    binarySearch(key, array, 0, array.length);

    endTime = System.nanoTime();
    duration = (endTime - startTime);

    StdOut.println("Binary Search :: Time Duration: " + duration + " nanoseconds.");
  }

  public static int bruteForceSearch(int key, int[] array) {
    if (array == null) {
      throw new IllegalArgumentException();
    }

    int result = -1;

    for (int i = 0; i < array.length; i++) {
      if (key == array[i]) {
        result = i;
      }
    }

    return result;
  }

  public static int binarySearch(int key, int[] array, int low, int high) {
    if (array == null) {
      throw new IllegalArgumentException();
    }

    if (low <= high) {
      int middle = low + (high - low) / 2;

      if (key < array[middle]) {
        return binarySearch(key, array, low, middle - 1);
      } else if (key > array[middle]) {
        return binarySearch(key, array, middle + 1, high);
      } else {
        return middle;
      }
    } else {
      return -1;
    }
  }
}
