package in.shabhushan.algo_trials.algorithms.chapter1.section3.exercise;

import edu.princeton.cs.algs4.StdOut;
import org.junit.Test;

import java.util.StringJoiner;

import static org.junit.Assert.assertEquals;

public class Exercise38Test {
  @Test
  public void testGeneralizedQueue() {
    Exercise38.GeneralizedQueue<Integer> generalizedQueue = new Exercise38.GeneralizedQueue<>();
    generalizedQueue.insert(0);
    generalizedQueue.insert(1);
    generalizedQueue.insert(2);
    generalizedQueue.insert(3);
    generalizedQueue.insert(4);

    generalizedQueue.delete(1);
    generalizedQueue.delete(3);

    StringJoiner generalizedQueueItems = new StringJoiner(", ");
    for (int item : generalizedQueue) {
      generalizedQueueItems.add(String.valueOf(item));
    }

    assertEquals("1, 2, 4", generalizedQueueItems.toString());
  }
}
