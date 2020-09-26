package in.shabhushan.algo_trials.collections.heap;

import in.shabhushan.algo_trials.collections.utils.Math;

import java.util.Comparator;
import java.util.StringJoiner;

public class PriorityQueue<T> implements Heap<T> {
  protected static final int TOP = 0;
  protected T[] items;
  protected int current;
  private final Comparator<? super T> comparator;

  /**
   *
   * Build Heap with given depth and comparator
   * @param depth
   * @param comparator
   */
  public PriorityQueue(int depth, Comparator<? super T> comparator) {
    items = (T[]) new Object[Math.pow(2, depth)];
    current = 0;
    this.comparator = comparator;
  }

  /**
   * Build heap using the array
   * @param items
   * @param comparator
   */
  public PriorityQueue(T[] items, Comparator<? super T> comparator) {
    items = (T[]) new Object[size(items.length)];
    System.arraycopy(items, 0, items, 0, items.length);

    current = items.length;
    this.comparator = comparator;
  }

  @Override
  public void insert(T item) {
    int index = current;
    int parent = parent(index);

    // while item is larger than parent
    while (parent >= 0 && comparator.compare(items[parent], item) > 0) {
      items[index] = items[parent];
      index = parent;
      parent = parent(index);
    }

    items[index] = item;
    current++;
  }

  @Override
  public T delete(int index) {
    return null;
  }

  @Override
  public void changeKey(T item, T newValue) {

  }

  @Override
  public T top() {
    validate(TOP);

    return items[TOP];
  }

  @Override
  public T removeTop() {
    validate(TOP);

    T removedItem = items[TOP];

    items[TOP] = items[current];
    items[current--] = null;

    heapify(TOP);

    return removedItem;
  }

  public int parent(int index) {
    return ((index + 1) / 2) - 1;
  }

  public int leftChild(int index) {
    int newIndex = index + 1;
    return (newIndex * 2) - 1;
  }

  public int rightChild(int index) {
    int newIndex = index + 1;
    return (newIndex * 2 + 1) - 1;
  }

  public int depth() {
    int i = 1;
    int j = 0;
    while(i != items.length) {
      i *= 2;
      j++;
    }
    return j;
  }

  @Override
  public String toString() {
    int depth = depth();

    int index = 0;
    StringJoiner joiner = new StringJoiner(System.getProperty("line.separator"));
    for (int i = 0; i < depth; i++) {
      StringBuilder builder = new StringBuilder();

      int spaces = Math.pow(2, depth - i - 1);
      for (int j = 0; j < spaces; j++) {
        builder.append(" ");
      }

      int from = Math.pow(2, i) - 1;
      int to = Math.pow(2, i + 1) - 1;

      for (int j = from; j < to; j++) {
        if (items[index] == null) {
          builder.append(" ");
        } else {
          builder.append(items[index].toString() + " ");
        }
        index++;
      }

      joiner.add(builder);
    }

    return joiner.toString();
  }

  private void swap(int a, int b) {
    T temp = items[a];

    items[a] = items[b];
    items[b] = temp;
  }

  private void heapify(int index) {
    while (index < current) {
      int left = leftChild(index);
      int right = rightChild(index);

      int result = smallest(left, index, right);

      if (result < 0) {
        index = left;
      } else if (result > 0) {
        index = right;
      }
    }
  }

  private void validate(int index) {
    if (index < 0 || index >= current) {
      throw new IllegalArgumentException("err-index-not-within-bounds");
    }
  }

  private int smallest(int left, int index, int right) {
    int a = comparator.compare(items[index], items[left]);
    int b = comparator.compare(items[index], items[right]);
    int c = comparator.compare(items[left], items[right]);

    // index in greatest
    if (a > 0 && b > 0) {
      return 0;
    } else if (a < 0 && c > 0) {
      return -1;
    } else {
      return 1;
    }
  }

  private static int size(int length) {
    int i = 1;
    while (Math.pow(2, i) <= length) {
      i++;
    }

    return Math.pow(2, i);
  }
}
