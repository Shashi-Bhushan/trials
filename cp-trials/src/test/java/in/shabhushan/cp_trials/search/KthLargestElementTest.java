package in.shabhushan.cp_trials.search;

import org.junit.Test;

import static in.shabhushan.cp_trials.search.KthLargestElement.findKthLargest;
import static org.junit.Assert.assertEquals;

public class KthLargestElementTest {
  @Test
  public void testKthLargestElement() {
    assertEquals(6, findKthLargest(new int[]{3,2,1,5,6,4}, 1));
    assertEquals(5, findKthLargest(new int[]{3,2,1,5,6,4}, 2));
    assertEquals(4, findKthLargest(new int[]{3,2,3,1,2,4,5,5,6}, 4));
  }
}
