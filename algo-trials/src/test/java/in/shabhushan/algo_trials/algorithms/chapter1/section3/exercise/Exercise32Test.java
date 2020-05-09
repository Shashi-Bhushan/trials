package in.shabhushan.algo_trials.algorithms.chapter1.section3.exercise;

import org.junit.Test;

import java.util.StringJoiner;

import static org.junit.Assert.assertEquals;

public class Exercise32Test {
  @Test
  public void testSteque() {
    Exercise32.Steque<String> steque = new Exercise32.Steque<>();
    steque.push("A");
    steque.push("B");
    steque.push("C");
    steque.pop();
    steque.enqueue("D");
    steque.enqueue("E");

    StringJoiner stringJoiner = new StringJoiner(", ");

    for (String c : steque) {
      stringJoiner.add(c);
    }

    // A, B, C are pushed from front
    // D and E are enqueued from back
    assertEquals("B, A, D, E", stringJoiner.toString());

  }

}
