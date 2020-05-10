package in.shabhushan.cp_trials.google_interview;

import org.junit.Test;

import static in.shabhushan.cp_trials.google_interview.AddArrays.*;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AddArraysTest {
  @Test
  public void testAddArrays() {
    for (int i = 0; i < 100000; i++) {
      assertArrayEquals(new int[]{3, 4, 5}, addArrays(new int[]{3, 2, 0}, new int[]{2, 5}));
      assertArrayEquals(new int[]{0, 5, 7}, addArrays2(new int[]{3, 2}, new int[]{0, 2, 5}));
      assertArrayEquals(new int[]{7, 5, 8}, addArrays(new int[]{3, 5, 9}, new int[]{3, 9, 9}));
      assertArrayEquals(new int[]{1, 9, 9, 8}, addArrays(new int[]{9, 9, 9}, new int[]{9, 9, 9}));
    }
  }

  @Test
  public void testAddArrays2() {
    for (int i = 0; i < 100000; i++) {
      assertArrayEquals(new int[]{3, 4, 5}, addArrays2(new int[]{3, 2, 0}, new int[]{0, 2, 5}));
      assertArrayEquals(new int[]{0, 5, 7}, addArrays2(new int[]{3, 2}, new int[]{0, 2, 5}));
      assertArrayEquals(new int[]{7, 5, 8}, addArrays2(new int[]{3, 5, 9}, new int[]{3, 9, 9}));
      assertArrayEquals(new int[]{1, 9, 9, 8}, addArrays2(new int[]{9, 9, 9}, new int[]{9, 9, 9}));
    }
  }

  @Test
  public void testPadding() {
    assertArrayEquals(new int[]{0, 0, 3, 4}, addPadding(new int[]{3, 4}, 4));
  }

  @Test
  public void testBigger() {
    assertTrue(isBiggerOrEqual(new int[]{4, 5, 2}, new int[]{0, 3, 4}));
    assertTrue(isBiggerOrEqual(new int[]{4, 5, 2}, new int[]{4, 3, 4}));
    assertFalse(isBiggerOrEqual(new int[]{4, 5, 2}, new int[]{5, 3, 4}));
  }
}
