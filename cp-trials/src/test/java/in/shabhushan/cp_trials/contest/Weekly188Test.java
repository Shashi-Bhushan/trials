package in.shabhushan.cp_trials.contest;

import org.junit.Ignore;
import org.junit.Test;

import static in.shabhushan.cp_trials.contest.Weekly188.*;
import static org.junit.Assert.assertEquals;

public class Weekly188Test {
  @Test
  public void testProblem2() {
    for (int i = 0; i < 10000; i++) {
      assertEquals(4, countTriplets(new int[]{2, 3, 1, 6, 7}));
      assertEquals(10, countTriplets(new int[]{1, 1, 1, 1, 1}));
      assertEquals(0, countTriplets(new int[]{2, 3}));
      assertEquals(3, countTriplets(new int[]{1, 3, 5, 7, 9}));
      assertEquals(8, countTriplets(new int[]{7, 11, 12, 9, 5, 2, 7, 17, 22}));
      assertEquals(51, countTriplets(new int[]{7, 11, 12, 9, 5, 2, 7, 17, 22, 2, 5, 78, 998, 34, 12, 36, 4, 44, 32, 56, 43, 23, 78, 34, 23, 22, 5, 7, 8, 9, 10, 11, 12, 12, 14, 2, 5, 6, 7, 2}));
      assertEquals(635, countTriplets(new int[]{7, 11, 12, 9, 5, 2, 7, 17, 22, 2, 5, 78, 998, 34, 12, 36, 4, 44, 32, 56, 43, 23, 78, 34, 23, 22, 5, 7, 8, 9, 10, 11, 12, 12, 14, 2, 5, 6, 7, 2, 34, 56, 78, 98, 99, 2, 5, 6, 23, 56, 45, 67, 23, 45, 34, 5, 65, 76, 87, 98, 21, 32, 43, 54, 65, 76, 8, 7, 87, 98, 9, 90, 12, 1, 4, 14, 15, 46, 57, 68, 45, 56, 67, 8, 9, 12, 12}));
    }
  }

  @Ignore
  @Test
  public void testProblem2InefficientSolution() {
    for (int i = 0; i < 10000; i++) {
      assertEquals(4, countTripletsInefficient(new int[]{2, 3, 1, 6, 7}));
      assertEquals(10, countTripletsInefficient(new int[]{1, 1, 1, 1, 1}));
      assertEquals(0, countTripletsInefficient(new int[]{2, 3}));
      assertEquals(3, countTripletsInefficient(new int[]{1, 3, 5, 7, 9}));
      assertEquals(8, countTripletsInefficient(new int[]{7, 11, 12, 9, 5, 2, 7, 17, 22}));
      assertEquals(51, countTripletsInefficient(new int[]{7, 11, 12, 9, 5, 2, 7, 17, 22, 2, 5, 78, 998, 34, 12, 36, 4, 44, 32, 56, 43, 23, 78, 34, 23, 22, 5, 7, 8, 9, 10, 11, 12, 12, 14, 2, 5, 6, 7, 2}));
      assertEquals(635, countTripletsInefficient(new int[]{7, 11, 12, 9, 5, 2, 7, 17, 22, 2, 5, 78, 998, 34, 12, 36, 4, 44, 32, 56, 43, 23, 78, 34, 23, 22, 5, 7, 8, 9, 10, 11, 12, 12, 14, 2, 5, 6, 7, 2, 34, 56, 78, 98, 99, 2, 5, 6, 23, 56, 45, 67, 23, 45, 34, 5, 65, 76, 87, 98, 21, 32, 43, 54, 65, 76, 8, 7, 87, 98, 9, 90, 12, 1, 4, 14, 15, 46, 57, 68, 45, 56, 67, 8, 9, 12, 12}));
    }
  }
}
