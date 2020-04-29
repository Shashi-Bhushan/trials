package in.shabhushan.algo_trials.algorithms.chapter1.section4.exercise;

import org.junit.Test;

import java.util.Set;

import static in.shabhushan.algo_trials.algorithms.chapter1.section4.exercise.Exercise12CommonElements.getCommonElements;
import static org.junit.Assert.assertEquals;

public class Exercise12CommonElementsTest {
  @Test
  public void testCommonElements() {
    int[] array1 = {-2, 1, 2, 2, 5, 6, 6, 8, 25};
    int[] array2 = {0, 1, 2, 2, 2, 3, 4, 5, 10, 20, 25};

    Set<Integer> answer = getCommonElements(array1, array2);

    assertEquals(Set.of(1, 2, 5, 25), answer);
  }
}
