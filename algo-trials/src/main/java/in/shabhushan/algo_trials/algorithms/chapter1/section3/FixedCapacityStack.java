package in.shabhushan.algo_trials.algorithms.chapter1.section3;

public class FixedCapacityStack<Item> {
  private Item[] array;
  private int N;

  FixedCapacityStack(int cap) {
    this.array = (Item[]) new Object[cap];
  }

  public boolean isEmpty() {
    return N == 0;
  }

  public int size() {
    return N;
  }

  public void push(Item item) {
    array[N++] = item;
  }

  public Item pop() {
    return array[--N];
  }

}
