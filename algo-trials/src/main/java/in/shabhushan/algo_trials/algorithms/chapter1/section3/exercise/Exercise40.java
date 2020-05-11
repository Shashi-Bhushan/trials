package in.shabhushan.algo_trials.algorithms.chapter1.section3.exercise;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Exercise40 {
  public static class MoveToFront<ITEM> implements Iterable<ITEM> {

    private Node first;
    private int size;
    private Set<ITEM> set;

    public MoveToFront() {
      size = 0;
      set = new HashSet<>();
    }

    public boolean isEmpty() {
      return size == 0;
    }

    public int size() {
      return size;
    }

    public void add(ITEM item) {
      if (set.contains(item))
        remove(item);

      Node node = new Node();
      node.item = item;

      node.next = first;

      first = node;

      set.add(item);
    }

    /**
     * Deletes Item from the linked list
     */
    public void remove(ITEM item) {
      Node current = first;

      if (!set.contains(item))
        return;

      if (first.item.equals(item)) {
        first = first.next;
      }
      // if item not in first place
      else if (!current.item.equals(item)) {
        // Find one before the item
        while (!current.next.item.equals(item)) {
          current = current.next;
        }

        current.next = current.next.next;
      }

      set.remove(item);
    }

    @Override
    public Iterator<ITEM> iterator() {
      return new MoveToFrontIterator();
    }

    private class MoveToFrontIterator implements Iterator<ITEM> {
      Node current = first;

      @Override
      public boolean hasNext() {
        return current != null;
      }

      @Override
      public ITEM next() {
        ITEM item = current.item;

        current = current.next;

        return item;
      }
    }

    private class Node {
      ITEM item;
      Node next;
    }
  }
}
