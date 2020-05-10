package in.shabhushan.algo_trials.algorithms.chapter1.section3.exercise;

import edu.princeton.cs.algs4.Queue;

import java.util.ArrayList;
import java.util.List;

public class Exercise37 {
  /**
   * Queue here gives a way to circularly rotate around the array.
   * You could use {@link java.util.ArrayDeque} which would give similar result and has similar performance to algs4's {@link Queue}
   */
  public static List<Integer> josepheusProblem(int m, int numPeople) {
    List<Integer> eliminationOrder = new ArrayList<>();

    Queue<Integer> queue = new Queue<>();

    for (int i = 0; i < numPeople; i++) {
      queue.enqueue(i);
    }

    while (numPeople-- > 0) {
      for (int j = 0; j < m - 1; j++) {
        queue.enqueue(queue.dequeue());
      }

      Integer x = queue.dequeue();
      eliminationOrder.add(x);
    }

    return eliminationOrder;
  }
}
