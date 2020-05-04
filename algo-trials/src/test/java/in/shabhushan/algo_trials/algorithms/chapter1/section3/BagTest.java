package in.shabhushan.algo_trials.algorithms.chapter1.section3;

import org.junit.Test;

public class BagTest {
  @Test
  public void test() {
    Bag<Integer> bag = new Bag<Integer>();

    bag.add(1);
    bag.add(2);
    bag.add(3);
    bag.add(4);
    bag.add(5);

    for (int n : bag) {
      System.out.println(n);
    }
  }
}
