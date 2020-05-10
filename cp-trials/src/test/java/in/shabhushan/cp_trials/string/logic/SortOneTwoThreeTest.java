package in.shabhushan.cp_trials.string.logic;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class SortOneTwoThreeTest {

  @Test
  public void test() {
    assertArrayEquals(new int[]{8, 8, 9, 9, 10, 10}, SortOneTwoThree.sort(new int[]{8, 8, 9, 9, 10, 10}));
    assertArrayEquals(new int[]{4, 1, 3, 2}, SortOneTwoThree.sort(new int[]{1, 2, 3, 4}));
    assertArrayEquals(new int[]{9, 999, 99}, SortOneTwoThree.sort(new int[]{9, 99, 999}));
  }

}
