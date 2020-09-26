package in.shabhushan.algo_trials.collections.heap;

import org.junit.Test;

public class PriorityQueueTest {
  @Test
  public void testMaxHeap() {
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(4, (a, b) -> b - a);

    maxHeap.insert(4);
    maxHeap.insert(3);
    maxHeap.insert(5);
    maxHeap.insert(10);
    maxHeap.insert(6);
    maxHeap.insert(1);

    System.out.println(maxHeap.toString());
  }
}
