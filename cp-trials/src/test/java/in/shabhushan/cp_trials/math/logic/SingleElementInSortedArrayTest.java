package in.shabhushan.cp_trials.math.logic;

import org.junit.Test;

import static in.shabhushan.cp_trials.math.logic.SingleElementInSortedArray.singleNonDuplicate;
import static org.junit.Assert.assertEquals;

public class SingleElementInSortedArrayTest {
  @Test
  public void testSingleElementInSortedArray() {
    assertEquals(1, singleNonDuplicate(new int[]{1}));
    assertEquals(1, singleNonDuplicate(new int[]{1, 2, 2, 3 ,3 ,4 ,4, 5 ,5}));
    assertEquals(5, singleNonDuplicate(new int[]{1, 1, 2, 2, 3 ,3 ,4 ,4, 5}));

    assertEquals(2, singleNonDuplicate(new int[]{1, 1, 2, 3 ,3 ,4 ,4, 5 ,5}));
    assertEquals(4, singleNonDuplicate(new int[]{1, 1, 2, 2, 3, 3, 4}));
    assertEquals(4, singleNonDuplicate(new int[]{1, 1, 2, 2, 3, 3, 4, 5, 5}));
    assertEquals(2, singleNonDuplicate(new int[]{1, 1, 2, 3, 3, 4, 4, 5, 5}));
  }
}
