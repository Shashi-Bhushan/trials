package in.shabhushan.cp_trials.tree;

import org.junit.Test;

import java.util.List;

import static in.shabhushan.cp_trials.tree.CountSmallerThan.countSmaller;
import static org.junit.Assert.assertEquals;

public class CountSmallerThanTest {
  @Test
  public void testCountSmallerThan() {
    assertEquals(List.of(2, 1, 1, 0), countSmaller(new int[]{5, 2, 6, 1}));
  }
}
