package in.shabhushan.algo_trials.algorithms.chapter1.section3.exercise;

import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

public class Exercise32 {
  /**
   * Linked list based Stack-Queue implementation.
   * Push and pop are stack solutions(add and remove from starting of the list).
   * Enqueue is Queue, add to end of list.
   * @param <ITEM>
   */
  public static class Steque<ITEM> implements Iterable<ITEM>{
    private class Node {
      ITEM item;
      Node previous;
      Node next;
    }

    private Node first;
    private Node last;
    private int size;

    public boolean isEmpty() {
      return size == 0;
    }

    public int size() {
      return size;
    }

    public void push(ITEM item) {
      Node old = first;

      first = new Node();
      first.item = item;
      first.next = old;

      if (old != null) {
        old.previous = first;
      } else {
        last = first;
      }

      size++;
    }

    public ITEM pop() {
      ITEM item = first.item;

      first = first.next;

      if (first != null) {
        first.previous = null;
      } else {
        last = null;
      }

      size--;
      return item;
    }

    public void enqueue(ITEM item) {
      Node old = last;

      last = new Node();
      last.item = item;
      last.previous = old;

      if (old != null) {
        old.next = last;
      } else {
        first = last;
      }

      size++;
    }

    @NotNull
    @Override
    public Iterator<ITEM> iterator() {
      return new StequeIterator();
    }

    private class StequeIterator implements Iterator<ITEM> {
      Node current = first;
      int iteratorIndex = 0;

      @Override
      public boolean hasNext() {
        return iteratorIndex < size;
      }

      @Override
      public ITEM next() {
        ITEM item = current.item;
        current = current.next;

        iteratorIndex++;
        return item;
      }
    }
  }
}
