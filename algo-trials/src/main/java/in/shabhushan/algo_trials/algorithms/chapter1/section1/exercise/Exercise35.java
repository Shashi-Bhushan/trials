package in.shabhushan.algo_trials.algorithms.chapter1.section1.exercise;

import edu.princeton.cs.algs4.StdRandom;

public class Exercise35 {
  private static final int SIDES = 6;

  public static double[] diceSimulations() {
    double[] dist = new double[2 * SIDES + 1];

    for (int i = 1; i <= SIDES; i++) {
      for (int j = 1; j <= SIDES; j++) {
        dist[i + j] += 1.0;
      }
    }

    for (int k = 0; k <= 2 * SIDES; k++) {
      dist[k] = dist[k] / 36.0;
    }

    return dist;
  }

  public static double[] diceExperiments(int numOfExperiments) {
    double[] dice = new double[2 * SIDES + 1];

    for (int i = 0; i < numOfExperiments; i++) {
      int firstDice = StdRandom.uniform(1, 7);
      int secondDice = StdRandom.uniform(1, 7);

      int sum = firstDice + secondDice;

      dice[sum]++;
    }

    for (int k = 2; k <= 2 * SIDES; k++) {
      dice[k] = dice[k] / numOfExperiments;
    }

    return dice;
  }
}
