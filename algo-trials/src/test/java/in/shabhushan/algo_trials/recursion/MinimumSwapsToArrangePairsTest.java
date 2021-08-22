package in.shabhushan.algo_trials.recursion;

import org.junit.Test;

import java.util.Map;

import static in.shabhushan.algo_trials.recursion.MinimumSwapsToArrangePairs.getMinimumSwapsToArrangePairs;
import static java.util.Map.entry;
import static org.junit.Assert.assertEquals;

public class MinimumSwapsToArrangePairsTest {
  @Test
  public void testMinimumSwaps() {
    assertEquals(0, getMinimumSwapsToArrangePairs(Map.ofEntries(
        entry(1, 3),
        entry(3, 1),
        entry(2, 6),
        entry(6, 2),
        entry(4, 5),
        entry(5, 4)
    ), new int[]{3, 1, 5, 4, 6, 2}));

    assertEquals(2, getMinimumSwapsToArrangePairs(Map.ofEntries(
        entry(1, 3),
        entry(3, 1),
        entry(2, 6),
        entry(6, 2),
        entry(4, 5),
        entry(5, 4)
    ), new int[]{3, 5, 6, 4, 1, 2}));
  }

}
