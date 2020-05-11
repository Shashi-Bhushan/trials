package in.shabhushan.algo_trials.algorithms.chapter1.section3.exercise;

import edu.princeton.cs.algs4.Queue;

import java.util.Iterator;

public class Exercise39 {
  public static class RingBuffer<ITEM> implements Iterable<ITEM> {
    private ITEM[] items;
    private int size;
    private int first;
    private int last;

    private Queue<ITEM> queue;

    public RingBuffer(int capacity) {
      items = (ITEM[]) new Object[capacity];
      size = 0;
      first = -1;
      last = -1;

      queue = new Queue<>();
    }

    public boolean isEmpty() {
      return size == 0;
    }

    public int size() {
      return size;
    }

    /**
     * Produces an item and adds it in item upto the capacity
     * If capacity is reached, add the the auxiliary queue instead.
     */
    public void produce(ITEM item) {
      if (isEmpty()) {
        items[size] = item;
        first = 0;
        last = 0;
        size++;
      } else {
        // check if items' limit reached
        if (size >= items.length) {
          queue.enqueue(item);
        } else {
          if (last == items.length - 1) {
            last = 0;
          } else {
            last++;
          }

          items[last] = item;
          size++;
        }
      }
    }

    /**
     * Returns the item in top of the queue.
     * Since there is space for 1 item now, check if there is some items in auxiliary queue.
     * if there are, add 1 from there to the items.
     */
    public ITEM consume() {
      if (isEmpty())
        return null;

      ITEM item = items[first];
      items[first] = null;

      if (first == items.length - 1) {
        first = 0;
      } else {
        first++;
      }

      size--;

      // since I'm removing this item from items, there is place for one item to be picked from buffer
      if (!queue.isEmpty()) {
        produce(queue.dequeue());
      }

      return item;
    }

    @Override
    public Iterator<ITEM> iterator() {
      return new RingBufferIterator();
    }

    private class RingBufferIterator implements Iterator<ITEM> {

      private int current = first;
      private int count = 0;

      @Override
      public boolean hasNext() {
        return count < size;
      }

      @Override
      public ITEM next() {
        ITEM item = items[current];

        if (current == items.length - 1) {
          current = 0; //Wrap around
        } else {
          current++;
        }

        count++;
        return item;
      }
    }
  }
}
