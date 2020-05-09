package in.shabhushan.algo_trials.algorithms.chapter1.section3.exercise;

import edu.princeton.cs.algs4.StdOut;
import org.junit.Test;

import java.util.StringJoiner;

public class Exercise34Test {
  @Test
  public void testRandomBag() {
    Exercise34.RandomBag<Integer> randomBag = new Exercise34.RandomBag<>(5);
    randomBag.add(1);
    randomBag.add(2);
    randomBag.add(3);
    randomBag.add(4);
    randomBag.add(5);
    randomBag.add(6);
    randomBag.add(7);
    randomBag.add(8);

    StdOut.print("Random bag items: ");

    StringJoiner randomBagItems = new StringJoiner(", ");
    for (int item : randomBag) {
      randomBagItems.add(String.valueOf(item));
    }

    StdOut.println(randomBagItems.toString());
  }
}
