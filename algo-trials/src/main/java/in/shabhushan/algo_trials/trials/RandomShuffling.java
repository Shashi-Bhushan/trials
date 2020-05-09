package in.shabhushan.algo_trials.trials;

import edu.princeton.cs.algs4.StdRandom;

import static in.shabhushan.algo_trials.algorithms.utils.CommonUtil.swap;

public class RandomShuffling {

  private static final int multiplier = 1234567890;
  private static final int addend = 150;
  private static final int mod = Integer.MAX_VALUE;

  /**
   * X(n+1) = [aX(n) + c] mod m
   * Check Linear congruential generator
   */
  public static final int[] pseudoRandomNumberGenerator(int seed, int n, int totalCount) {
    int[] array = new int[totalCount];

    for (int i = 0 ; i < totalCount; i++) {
      if (i == 0)
        array[0] = (seed * multiplier + addend) % mod;
      else
        array[i] = (array[i - 1] * multiplier + addend) % mod;
    }

    return array;
  }

  public static int[][] nonRandomShuffle(int numTrials, int N) {
    char[] arr = new char[N];
    int[][] positions = new int[N][N];

    for (int i = 0; i < numTrials; i++) {
      initializeArray(arr);
      badShuffle(arr);

      for (int j = 0; j < N; j++) {
        positions[arr[j] - 'A'][j]++;
      }
    }

    return positions;
  }

  public static int[][] empiricalShuffle(int numTrials, int N) {
    char[] arr = new char[N];
    int[][] positions = new int[N][N];

    for (int i = 0; i < numTrials; i++) {
      initializeArray(arr);
      goodShuffle(arr);

      for (int j = 0; j < N; j++) {
        positions[arr[j] - 'A'][j]++;
      }
    }

    return positions;
  }

  private static char[] goodShuffle(char[] array) {
    for (int i = 0; i < array.length; i++) {
      int randomIndex = i + StdRandom.uniform(array.length - i);

      swap(array, i, randomIndex);
    }

    return array;
  }

  private static char[] badShuffle(char[] array) {
    for (int i = 0; i < array.length; i++) {
      int randomIndex = StdRandom.uniform(array.length);

      swap(array, i, randomIndex);
    }

    return array;
  }

  private static void initializeArray(char[] arr) {
    for (int i = 0; i < arr.length; i++) {
      arr[i] = (char)('A' + i);
    }
  }
}
