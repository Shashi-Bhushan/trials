package in.shabhushan.algo_trials.binarySearch;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AllocateBooksTest {
  AllocateBooks books = new AllocateBooks();

  @Test
  public void test() {
    assertEquals(113, books.books(new int[]{12, 34, 67, 90}, 2));
    assertEquals(-1, books.books(new int[]{31, 14, 19, 75}, 12));
  }
}
