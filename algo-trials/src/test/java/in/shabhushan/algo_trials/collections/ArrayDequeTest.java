package in.shabhushan.algo_trials.collections;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class ArrayDequeTest {

  private static int[] arr = {1, 2, 3, 4, 5, 6, 7};

  @Test
  public void asStack() {
    ArrayDeque<Integer> stack = new ArrayDeque<>();

    for (int i: arr) {
      stack.push(i);
    }

    while (!stack.isEmpty()) {
      System.out.print(stack.pop() + " ");
    }

    System.out.println();
  }

  @Test
  public void asQueue() {
    Queue<Integer> queue = new ArrayDeque<>();

    for (int i: arr) {
      queue.offer(i);
    }

    while (!queue.isEmpty()) {
      System.out.print(queue.poll() + " ");
    }

    System.out.println();
  }
}
