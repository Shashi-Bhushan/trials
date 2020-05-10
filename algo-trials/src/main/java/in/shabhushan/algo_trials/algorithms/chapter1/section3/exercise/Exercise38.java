package in.shabhushan.algo_trials.algorithms.chapter1.section3.exercise;

import java.util.Arrays;
import java.util.Iterator;

public class Exercise38 {
  public static class GeneralizedQueue<ITEM> implements Iterable<ITEM> {
    private ITEM[] items;
    // size is where the next element will be placed
    private int size;

    public GeneralizedQueue() {
      items = (ITEM[]) new Object[1];
      size = 0;
    }

    public boolean isEmpty() {
      return size == 0;
    }

    public void insert(ITEM item) {
      if (size >= items.length * 0.75) {
        resize();
      }

      items[size++] = item;
    }

    public ITEM delete(int k) {
      if (k >= items.length || k <= 0) {
        throw new IllegalArgumentException("err-invalid-index");
      }

      ITEM item = this.items[k - 1];

      moveItemsBackward(k);

      size--;

      if (size < items.length * 0.25) {
        this.items = Arrays.copyOf(this.items, this.items.length / 2);
      }

      return item;
    }

    private void resize() {
      this.items = Arrays.copyOf(this.items, this.items.length * 2);
    }

    private void moveItemsBackward(int k) {
      // k - 1 is empty at this point
      for (int i = k; i < size; i++) {
        this.items[i - 1] = this.items[i];
      }

      // since size-- is not done yet, the element where next entry will be is size - 1. stop loitering at that position
      this.items[size - 1] = null;
    }

    @Override
    public Iterator<ITEM> iterator() {
      return new GeneralizedQueueIterator();
    }

    private class GeneralizedQueueIterator implements Iterator<ITEM> {

      private int index = 0;

      @Override
      public boolean hasNext() {
        return index < size;
      }

      @Override
      public ITEM next() {
        ITEM item = items[index];
        index++;
        return item;
      }
    }
  }
}
