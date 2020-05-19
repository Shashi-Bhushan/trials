package in.shabhushan.cp_trials.search;

import org.junit.Test;

import java.util.Random;
import java.util.stream.IntStream;

import static in.shabhushan.cp_trials.search.KthLargestElement.*;
import static org.junit.Assert.assertEquals;

public class KthLargestElementTest {

  private static final int ARRAY_SIZE = 100_00_00;

  private static final int[] ar;

  static {
    ar = IntStream.range(0, ARRAY_SIZE).toArray();

    Random rnd = new Random();
    for (int i = ar.length - 1; i > 0; i--) {
      int index = rnd.nextInt(i + 1);
      // Simple swap
      int a = ar[index];
      ar[index] = ar[i];
      ar[i] = a;
    }
  }

  @Test
  public void testKthLargestElement() {
    assertEquals(6, findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 1));
    assertEquals(5, findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
    assertEquals(4, findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));
  }

  @Test
  public void testKthLargestElement2() {
    //assertEquals(4, findKthLargest2(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));
    //assertEquals(6, findKthLargest2(new int[]{3, 2, 1, 5, 6, 4}, 1));
    assertEquals(5, findKthLargest2(new int[]{3, 2, 1, 5, 6, 4}, 2));
  }

  @Test
  public void testKthLargestElement3() {
    assertEquals(5, findKthLargest3(new int[]{3, 2, 1, 5, 6, 4}, 2));
    assertEquals(19, findKthLargest3(new int[]{3, 2, 5, 6, 4, 7, 8, 10, 9, 12, 11, 15, 14, 13, 20, 19, 18, 17, 16}, 2));
    assertEquals(24, findKthLargest3(new int[]{3, 2, 5, 6, 4, 7, 8, 10, 9, 12, 21, 22, 23, 24, 25, 11, 15, 14, 13, 20, 19, 18, 17, 16}, 2));
    assertEquals(6, findKthLargest3(new int[]{3, 2, 1, 5, 6, 4}, 1));
    assertEquals(9, findKthLargest3(new int[]{5, 4, 3, 7, 8, 9}, 1));
    assertEquals(4, findKthLargest3(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));
  }

  @Test // 127 ms
  public void testLargeArrayKthLargest1() {
    assertEquals(ARRAY_SIZE - 2, findKthLargest(ar, 2));
  }

  @Test // 54 ms
  public void testLargeArrayKthLargest2() {
    assertEquals(ARRAY_SIZE - 2, findKthLargest2(ar, 2));
  }

  @Test // 16 ms
  public void testLargeArrayKthLargest3() {
    assertEquals(ARRAY_SIZE - 2, findKthLargest3(ar, 2));
  }
}
