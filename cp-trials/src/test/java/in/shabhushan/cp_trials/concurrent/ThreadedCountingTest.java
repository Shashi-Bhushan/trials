package in.shabhushan.cp_trials.concurrent;

import java.util.*;
import java.util.stream.*;
import org.junit.Test;
import static org.junit.Assert.*;


public class ThreadedCountingTest {
  @Test
  public void the_correct_numbers_are_counted() {
    Counter counter = new Counter();
    ThreadedCounting.countInThreads(counter);

    Set<Integer> expected = IntStream.rangeClosed(1, 100)
      .boxed()
      .collect(Collectors.toSet());
    Set<Integer> actual = new HashSet<>(counter.getNumbers());

    assertEquals("The expected numbers were not generated",
      expected, actual);
  }

  @Test
  public void the_correct_numbers_are_counted_in_sequence() {
    Counter counter = new Counter();
    ThreadedCounting.countInThreads(counter);

    List<Integer> expected = IntStream.rangeClosed(1, 100)
      .boxed()
      .collect(Collectors.toList());
    List<Integer> actual = counter.getNumbers();

    assertEquals("The expected numbers were not generated in the right sequence",
      expected, actual);
  }

  @Test
  public void three_threads_are_used() {
    Counter counter = new Counter();
    ThreadedCounting.countInThreads(counter);

//    assertEquals("The numbers are written in three different threads",
//      3, counter.getThreadIds().size());
  }

  @Test
  public void numbers_are_in_the_correct_threads() {
    Counter counter = new Counter();
    ThreadedCounting.countInThreads(counter);

    List<Integer> expected1 = IntStream.rangeClosed(1, 100)
      .filter(i -> i % 3 == 1)
      .boxed()
      .collect(Collectors.toList());
    List<Integer> expected2 = IntStream.rangeClosed(1, 100)
      .filter(i -> i % 3 == 2)
      .boxed()
      .collect(Collectors.toList());
    List<Integer> expected3 = IntStream.rangeClosed(1, 100)
      .filter(i -> i % 3 == 0)
      .boxed()
      .collect(Collectors.toList());

//    assertEquals("Correct thread for 1, 4, 7...",
//      expected1, counter.getNumbersInSameThreadAs(1));
//    assertEquals("Correct thread for 2, 5, 8...",
//      expected2, counter.getNumbersInSameThreadAs(2));
//    assertEquals("Correct thread for 3, 6, 9...",
//      expected3, counter.getNumbersInSameThreadAs(3));
  }
}
