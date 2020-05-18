package in.shabhushan.cp_trials.search;

import org.junit.Test;

import static in.shabhushan.cp_trials.search.KthLargestElement.*;
import static org.junit.Assert.assertEquals;

public class KthLargestElementTest {
  @Test
  public void testKthLargestElement() {
    assertEquals(6, findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 1));
    assertEquals(5, findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
    assertEquals(4, findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));
  }

  @Test
  public void testKthLargestElement2() {
    assertEquals(4, findKthLargest2(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));
    assertEquals(6, findKthLargest2(new int[]{3, 2, 1, 5, 6, 4}, 1));
    assertEquals(5, findKthLargest2(new int[]{3, 2, 1, 5, 6, 4}, 2));
  }

  @Test
  public void testKthLargestElement3() {
    assertEquals(6, findKthLargest3(new int[]{3, 2, 5, 6, 4, 7, 8, 10, 9, 12, 11, 15,14,13, 20,19,18,17,16}, 2));
    assertEquals(5, findKthLargest3(new int[]{3, 2, 1, 5, 6, 4}, 2));
    assertEquals(6, findKthLargest3(new int[]{3, 2, 1, 5, 6, 4}, 1));
    assertEquals(4, findKthLargest3(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));
  }
}
