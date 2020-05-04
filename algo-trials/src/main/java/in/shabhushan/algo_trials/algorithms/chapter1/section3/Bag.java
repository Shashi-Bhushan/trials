package in.shabhushan.algo_trials.algorithms.chapter1.section3;

import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

public class Bag<Item> implements Iterable<Item> {

  private BagItem first;
  private int size;

  /**
   * Creates an empty bag
   */
  public Bag() {}

  @NotNull
  @Override
  public Iterator<Item> iterator() {
    return new BagItemIterator();
  }

  /**
   * Add an item
   * @param item
   *    item to add
   */
  public void add(Item item) {
    first = new BagItem(item, first);

    size++;
  }

  /**
   * Returns true iff the bag is empty, false otherwise
   */
  public boolean isEmpty() {
    return size == 0;
  }

  /**
   * Number of items in the bag
   */
  public int size() {
    return size;
  }

  public static void main(String[] args) {
    System.out.println();
  }

  private class BagItem {
    Item item;
    BagItem next;

    public BagItem(Item item, BagItem next) {
      this.item = item;
      this.next = next;
    }
  }

  private class BagItemIterator implements Iterator<Item> {
    private BagItem current = first;

    @Override
    public boolean hasNext() {
      return current != null;
    }

    @Override
    public Item next() {
      Item item = current.item;
      current = current.next;

      return item;
    }

    @Override
    public void remove() {
      throw new IllegalCallerException("err-remove-not-supported-in-bag");
    }
  }
}
