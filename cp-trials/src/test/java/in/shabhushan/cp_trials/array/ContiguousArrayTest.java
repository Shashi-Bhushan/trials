package in.shabhushan.cp_trials.array;

import org.junit.Test;

import static in.shabhushan.cp_trials.array.ContiguousArray.findMaxLength;
import static org.junit.Assert.assertEquals;

public class ContiguousArrayTest {
  @Test
  public void testContiguousArray() {
    assertEquals(2, findMaxLength(new int[]{0, 1}));
    assertEquals(2, findMaxLength(new int[]{0, 1, 0}));
  }
}
