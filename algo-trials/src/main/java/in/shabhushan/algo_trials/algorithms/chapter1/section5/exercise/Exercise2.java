package in.shabhushan.algo_trials.algorithms.chapter1.section5.exercise;

import in.shabhushan.algo_trials.algorithms.chapter1.section5.QuickUnion;
import in.shabhushan.algo_trials.algorithms.chapter1.section5.Stats;

/**
 * Use quick union for the same sequence of operations
 * 9-0 3-4 5-8 7-2 2-1 5-7 0-3 4-3
 */
public class Exercise2 {
  public static void main(String[] args) {
    Stats.generateStats("1.5.2", new QuickUnion(10), new int[][]{
        {9, 0},
        {3, 4},
        {5, 8},
        {7, 2},
        {2, 1},
        {5, 7},
        {0, 3},
        {4, 3}
    });
  }
}
