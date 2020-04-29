package in.shabhushan.algo_trials.algorithms.chapter1.section4.exercise;

import java.util.HashSet;
import java.util.Set;

/**
 * Find common elements from two sorted int[] arrays with duplicates ?
 */
public class Exercise12CommonElements {
  public static Set<Integer> getCommonElements(int[] arrayOne, int[] arrayTwo) {
    int arrayOneIndex = 0;
    int arrayTwoIndex = 0;

    Set<Integer> answer = new HashSet<>();
    while (arrayOneIndex < arrayOne.length && arrayTwoIndex < arrayTwo.length) {
      while (arrayOneIndex < arrayOne.length && arrayOne[arrayOneIndex] < arrayTwo[arrayTwoIndex]) {
        arrayOneIndex++;
      }

      if (arrayOneIndex < arrayOne.length && arrayOne[arrayOneIndex] == arrayTwo[arrayTwoIndex]) {
        answer.add(arrayOne[arrayOneIndex]);

        arrayOneIndex++;
        arrayTwoIndex++;
      }

      while (arrayTwoIndex < arrayTwo.length && arrayTwo[arrayTwoIndex] < arrayOne[arrayOneIndex])
        arrayTwoIndex++;
    }

    return answer;
  }
}
