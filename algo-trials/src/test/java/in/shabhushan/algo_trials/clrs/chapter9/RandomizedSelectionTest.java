package in.shabhushan.algo_trials.clrs.chapter9;

import org.junit.Test;

import static in.shabhushan.algo_trials.clrs.chapter7.QuickSort.getRandomArr;
import static in.shabhushan.algo_trials.clrs.chapter9.RandomizedSelection.randomSelection;
import static in.shabhushan.algo_trials.clrs.chapter9.RandomizedSelection.randomSelectionIter;
import static org.junit.Assert.assertEquals;

public class RandomizedSelectionTest {
  @Test
  public void testRandomArrIterativeVersion() {
    //int element = randomSelection(getRandomArr(10), 0, 10 - 1, 5);

    // what's at index 5
    //assertEquals(5, element);

    int size = 10;
    int key = 4;

    int element = randomSelectionIter(new int[]{1, 0, 6, 2, 4, 3, 5, 7, 8, 9}, 0, size - 1, key);

    assertEquals(key, element);

    size = 20;
    key = 14;

    assertEquals(key,
      randomSelectionIter(getRandomArr(size), 0, size - 1, key)
    );

    size = 1000;
    key = 526;

    assertEquals(key,
      randomSelectionIter(getRandomArr(size), 0, size - 1, key)
    );
  }

  @Test
  public void testRandomArr() {
    //int element = randomSelection(getRandomArr(10), 0, 10 - 1, 5);

    // what's at index 5
    //assertEquals(5, element);

    int size = 10;
    int key = 4;

    int element = randomSelection(new int[]{1, 0, 6, 2, 4, 3, 5, 7, 8, 9}, 0, size - 1, key);

    assertEquals(key, element);

    size = 20;
    key = 14;

    assertEquals(key,
      randomSelection(getRandomArr(size), 0, size - 1, key)
    );

    size = 1000;
    key = 526;

    assertEquals(key,
      randomSelection(getRandomArr(size), 0, size - 1, key)
    );
  }
}
