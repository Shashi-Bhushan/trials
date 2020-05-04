package in.shabhushan.algo_trials.algorithms.chapter1.section3;

import java.util.Arrays;
import java.util.Iterator;

public class ResizingArrayStack<Item> implements Iterable<Item> {

  private Item[] items = (Item[]) new Object[1];

  private int size = 0;

  public boolean isEmpty() {
    return size == 0;
  }

  public int size() {
    return size;
  }

  private void resize(int max) {
    items = Arrays.copyOf(items, max);
  }

  public void push(Item item) {
    if (size == items.length)
      resize(2 * items.length);

    items[size++] = item;
  }

  public Item pop() {
    Item item = items[--size];

    items[size] = null;
    if (0 < size && items.length * 0.25 <= size)
      resize(items.length / 2);

    return item;
  }

  public Iterator<Item> iterator() {
    return new ReverseArrayIterator();
  }

  private class ReverseArrayIterator implements Iterator<Item> {
    private int i = size;

    public boolean hasNext() {
      return i > 0;
    }

    public Item next() {
      return items[--i];
    }

    public void remove() {
      throw new UnsupportedOperationException("err-remove-not-supported");
    }
  }
}
