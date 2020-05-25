package in.shabhushan.algo_trials.trials;

import org.junit.Test;

import static in.shabhushan.algo_trials.trials.UniqueElements.*;

/**
 * Sorting Time taken 1646565417
 * Count 6322804
 * HashSet Time taken 4908217365
 * Count 6322804
 */
public class UniqueElementsTest {
  @Test
  public void testUniqueElementsHashSet() {
    long startTime = System.nanoTime();

    int count = getUniqueElementsCountUsingHashSet(getArrayCopy());

    System.out.println("HashSet Time taken " + (System.nanoTime() - startTime));
    System.out.println("Count " + count);
  }

  @Test
  public void testUniqueElementsSorting() {
    long startTime = System.nanoTime();

    int count = getUniqueElementsCountUsingSorting(getArrayCopy());

    System.out.println("Sorting Time taken " + (System.nanoTime() - startTime));
    System.out.println("Count " + count);
  }
}
