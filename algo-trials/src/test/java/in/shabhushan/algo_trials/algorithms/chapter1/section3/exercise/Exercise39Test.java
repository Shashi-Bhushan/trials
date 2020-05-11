package in.shabhushan.algo_trials.algorithms.chapter1.section3.exercise;

import org.junit.Test;

import java.util.StringJoiner;

import static org.junit.Assert.assertEquals;

public class Exercise39Test {
  @Test
  public void testRingBuffer() {
    Exercise39.RingBuffer<String> buffer = new Exercise39.RingBuffer<>(5);

    buffer.produce("1");
    buffer.produce("2");
    buffer.produce("3");

    StringJoiner joiner = new StringJoiner(", ");
    buffer.forEach(joiner::add);

    assertEquals("1, 2, 3", joiner.toString());

    buffer.produce("4");
    buffer.produce("5");
    buffer.produce("6");

    joiner = new StringJoiner(", ");
    buffer.forEach(joiner::add);
    assertEquals("1, 2, 3, 4, 5", joiner.toString());

    assertEquals("1", buffer.consume());

    joiner = new StringJoiner(", ");
    buffer.forEach(joiner::add);

    assertEquals("2, 3, 4, 5, 6", joiner.toString());
  }
}
