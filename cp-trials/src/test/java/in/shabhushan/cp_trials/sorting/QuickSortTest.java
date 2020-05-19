package in.shabhushan.cp_trials.sorting;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

import static in.shabhushan.cp_trials.sorting.QuickSort.quickSort;
import static org.junit.Assert.assertArrayEquals;

public class QuickSortTest {

  private static final int ARRAY_SIZE = 100_00_00;

  private static final int[] ar;

  private static final int[] sortedArr;

  static {
    ar = IntStream.range(0, ARRAY_SIZE).toArray();
    sortedArr = IntStream.range(0, ARRAY_SIZE).toArray();
    // If running on Java 6 or older, use `new Random()` on RHS here

    Random rnd = new Random();
    for (int i = ar.length - 1; i > 0; i--) {
      int index = rnd.nextInt(i + 1);
      // Simple swap
      int a = ar[index];
      ar[index] = ar[i];
      ar[i] = a;
    }
  }

  @Test
  public void testQuickSort() {
    int[] array = {4, 3, 5, 7, 8, 9};

    quickSort(array);

    assertArrayEquals(new int[]{3, 4, 5, 7, 8, 9}, array);
  }

  @Test
  public void testQuickSortLargeArray() {
    int[] arrayCopy = new int[ARRAY_SIZE];

    System.arraycopy(ar, 0, arrayCopy, 0, ARRAY_SIZE);

    quickSort(arrayCopy);

    assertArrayEquals(sortedArr, arrayCopy);
  }

  @Test
  public void testArraysSortLargeArray() {
    int[] arrayCopy = new int[ARRAY_SIZE];

    System.arraycopy(ar, 0, arrayCopy, 0, ARRAY_SIZE);

    Arrays.sort(arrayCopy);

    assertArrayEquals(sortedArr, arrayCopy);
  }
}
