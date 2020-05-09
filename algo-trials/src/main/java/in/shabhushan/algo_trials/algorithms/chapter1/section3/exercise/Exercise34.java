package in.shabhushan.algo_trials.algorithms.chapter1.section3.exercise;

import edu.princeton.cs.algs4.StdRandom;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Iterator;

import static in.shabhushan.algo_trials.algorithms.utils.CommonUtil.swap;

public class Exercise34 {
  public static class RandomBag<ITEM> implements Iterable<ITEM> {
    private ITEM[] items;
    private int size = 0;

    public RandomBag(int capacity) {
      items = (ITEM[]) new Object[capacity];
    }

    public boolean isEmpty() {
      return size == 0;
    }

    public int size() {
      return size;
    }

    public void add(ITEM item) {
      resizeIfRequired();

      items[size++] = item;
    }

    private void resizeIfRequired() {
      // more than 75%
      if (size >= items.length * 0.75) {
        items = Arrays.copyOf(items, items.length * 2);
      }
    }

    @NotNull
    @Override
    public Iterator<ITEM> iterator() {
      return new RandomBagIterator();
    }

    private class RandomBagIterator implements Iterator<ITEM> {

      ITEM[] tempItems;
      int current;

      public RandomBagIterator() {
        tempItems = Arrays.copyOf(items, size);

        for (int i = 0; i < tempItems.length; i++) {
          int index = i + StdRandom.uniform(tempItems.length - i);

          swap(tempItems, i, index);
        }

        current = 0;
      }

      @Override
      public boolean hasNext() {
        return current < size;
      }

      @Override
      public ITEM next() {
        return tempItems[current++];
      }
    }
  }
}
