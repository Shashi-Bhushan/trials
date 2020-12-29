package in.shabhushan.algo_trials.arrays;

import org.junit.Test;

import static in.shabhushan.algo_trials.arrays.ValidModulusPairs.isValidPair;
import static org.junit.Assert.assertTrue;

public class ValidModulusPairsTest {
  @Test
  public void testValidPairs() {
    assertTrue(isValidPair(new int[]{6, 3, 15, 9}, 4, 9, 3)); // [{6, 15}, {3 ,9}]
    assertTrue(isValidPair(new int[]{2, 1, 5, 7}, 4, 9, 3)); // [{2, 1}, {5, 7}]
    assertTrue(isValidPair(new int[]{6, 3, 6, 0}, 4, 9, 3)); // [{6,6}, {3, 0}]

    assertTrue(isValidPair(new int[]{10, 15, 12 ,13, 8, 6}, 6, 11, 3)); // [{10, 15}, {12 ,13}, {8, 6}]
  }
}
