package in.shabhushan.algo_trials.algorithms.chapter1.section3.exercise;

import org.junit.Test;

import java.util.StringJoiner;

import static org.junit.Assert.assertEquals;

public class Exercise40Test {
  @Test
  public void testMoveToFront() {
    Exercise40.MoveToFront<String> lruCache = new Exercise40.MoveToFront<>();

    // Remove non existing element
    lruCache.add("1");
    lruCache.remove("2");

    StringJoiner joiner = new StringJoiner(", ");
    lruCache.forEach(joiner::add);
    assertEquals("1", joiner.toString());

    // Empties the cache
    lruCache.remove("1");

    joiner = new StringJoiner(", ");
    lruCache.forEach(joiner::add);
    assertEquals("", joiner.toString());

    // Add 3 items
    lruCache.add("1");
    lruCache.add("2");
    lruCache.add("3");

    joiner = new StringJoiner(", ");
    lruCache.forEach(joiner::add);
    assertEquals("3, 2, 1", joiner.toString());

    // Add 3 more items, one of which already exists
    lruCache.add("1");
    lruCache.add("4");
    lruCache.add("5");

    joiner = new StringJoiner(", ");
    lruCache.forEach(joiner::add);
    assertEquals("5, 4, 1, 3, 2", joiner.toString());
  }
}
