package in.shabhushan.algo_trials.algorithms.chapter1.section5.exercise;

import in.shabhushan.algo_trials.algorithms.chapter1.section5.QuickFind;
import in.shabhushan.algo_trials.algorithms.chapter1.section5.Stats;

/**
 * Show the contents of the id[] array and the number of times the array is accessed for each input pair when you use quick-find for the sequence
 * 9-0 3-4 5-8 7-2 2-1 5-7 0-3 4-3
 */
public class Exercise1 {
  public static void main(String[] args) {
    Stats.generateStats("1.5.1", new QuickFind(10), new int[][]{
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
