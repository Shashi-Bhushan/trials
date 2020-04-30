package in.shabhushan.algo_trials.algorithms.chapter1.section4.exercise;

import org.junit.Test;

import static in.shabhushan.algo_trials.algorithms.chapter1.section4.exercise.Exercise20BitonicSearch.bitonicSearch;
import static in.shabhushan.algo_trials.algorithms.chapter1.section4.exercise.Exercise20BitonicSearch.getTippingPoint;
import static org.junit.Assert.assertEquals;

public class Exercise20BitonicSearchTest {
  private int[] array1 = {1, 2, 3, 4, -1, -2, -3};
  private int[] array2 = {1, 5, 4, 3, 2, 0};
  private int[] array3 = {2, 4, 8, 16, 32, 1};
  private int[] array4 = {2, 4, 8, 16, 32};
  private int[] array5 = {2, 1};
  private int[] array6 = {9};

  @Test
  public void testTippingPoint() {
    assertEquals(3, getTippingPoint(array1));
    assertEquals(1, getTippingPoint(array2));
    assertEquals(4, getTippingPoint(array3));
    assertEquals(4, getTippingPoint(array4));
    assertEquals(0, getTippingPoint(array5));
    assertEquals(0, getTippingPoint(array6));
  }

  @Test
  public void testBitonicSearch() {
    assertEquals(1, bitonicSearch(array1, 2));
    assertEquals(3, bitonicSearch(array1, 4));
    assertEquals(5, bitonicSearch(array1, -2));
    assertEquals(0, bitonicSearch(array6, 9));
    assertEquals(-1, bitonicSearch(array6, 2));
  }
}
