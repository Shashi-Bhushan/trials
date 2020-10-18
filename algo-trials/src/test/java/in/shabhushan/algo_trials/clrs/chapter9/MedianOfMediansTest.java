package in.shabhushan.algo_trials.clrs.chapter9;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static in.shabhushan.algo_trials.clrs.chapter7.QuickSort.getRandomArr;
import static in.shabhushan.algo_trials.clrs.chapter9.MedianOfMedians.getSelectionByMedianOfMedians;
import static org.junit.Assert.assertEquals;

public class MedianOfMediansTest {
  @Test
  public void testMedianOfMedians() {
    List<Integer> arr = List.of(1, 0, 6, 2, 4, 3, 5, 7, 8, 9);

    assertEquals(8, getSelectionByMedianOfMedians(arr, 8));
  }

  @Test
  public void testRandomMedianOfMediansTest() {
    int size = 1000;

    List<Integer> list = Arrays.stream(getRandomArr(size)).boxed().collect(Collectors.toList());

    assertEquals(526, getSelectionByMedianOfMedians(list, 526));
  }
}
