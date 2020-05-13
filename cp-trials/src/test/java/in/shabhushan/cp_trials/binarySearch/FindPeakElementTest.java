package in.shabhushan.cp_trials.binarySearch;

import org.junit.Test;

import static in.shabhushan.cp_trials.binarySearch.FindPeakElement.findPeakElement;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.CoreMatchers.is;

public class FindPeakElementTest {
  @Test
  public void testFindPeakElement() {
    assertEquals(1, findPeakElement(new int[]{3, 4, 3, 2, 1}));
    assertEquals(2, findPeakElement(new int[]{1, 2, 3, 1}));
    assertEquals(1, findPeakElement(new int[]{1, 2}));
    assertEquals(0, findPeakElement(new int[]{2, 1}));
    assertEquals(0, findPeakElement(new int[]{1}));
    assertEquals(4, findPeakElement(new int[]{1, 2, 3, 4, 5}));
    assertEquals(0, findPeakElement(new int[]{5, 4, 3, 2, 1}));
    assertEquals(2, findPeakElement(new int[]{1, 2, 3, 2, 1}));
    assertThat(findPeakElement(new int[]{1, 2, 3, 4, 2, 3, 5, 6, 4, 1}), anyOf(is(3), is(7)));
  }
}
