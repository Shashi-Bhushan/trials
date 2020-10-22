package in.shabhushan.algo_trials.clrs.chapter10;

import java.util.Arrays;

public class ArrayDeque {
  private int[] array;

  private int head;
  private int tail;

  public ArrayDeque(int size) {
    array = new int[size];
    head = 0;
    tail = 0;
  }

  /**
   * Inserts at the tail of the Queue
   *
   * @param element element to insert
   */
  public void pushBack(int element) {
    if (head == tail && head != 0) {
      throw new IllegalStateException("err-full-queue-overflow");
    } else {
      array[tail] = element;

      tail = (tail != array.length - 1) ? tail + 1 : 0;
    }
  }

  public void pushFront(int element) {
    if (head == tail && head != 0) {
      throw new IllegalStateException("err-full-queue-overflow");
    } else {
      // decrement head first, then add
      head = (head == 0) ? array.length - 1 : head - 1;
      array[head] = element;
    }
  }

  public int removeBack() {
    if (head == tail && head == 0) {
      throw new IllegalStateException("err-empty-queue-underflow");
    } else {
      tail = (tail == 0) ? array.length - 1 : tail - 1;

      int element = array[tail];
      array[tail] = 0;
      return element;
    }
  }

  public int removeFront() {
    if (head == tail && head == 0) {
      throw new IllegalStateException("err-empty-queue-underflow");
    } else {
      int element = array[head];

      array[head] = 0;

      head = (head == array.length - 1) ? 0 : head + 1;

      return element;
    }
  }

  @Override
  public String toString() {
    return "ArrayDeque{" +
        "array=" + Arrays.toString(array) +
        ", head=" + head +
        ", tail=" + tail +
        '}';
  }

  public int[] getArray() {
    return array;
  }
}
