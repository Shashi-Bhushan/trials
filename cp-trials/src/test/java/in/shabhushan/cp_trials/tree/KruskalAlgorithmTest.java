package in.shabhushan.cp_trials.tree;

import org.junit.Test;

import static in.shabhushan.cp_trials.tree.KruskalAlgorithm.getMinimumSpanningWeight;
import static org.junit.Assert.assertEquals;

public class KruskalAlgorithmTest {
  @Test
  public void testKruskalAlgorithm() {
    // check this for graph https://www.youtube.com/watch?v=a4EV41S2kVo at 08:00
    assertEquals(20, getMinimumSpanningWeight(6, new int[][]{
      {0, 1, 1},
      {0, 2, 2},
      {1, 2, 3},
      {0, 3, 4},
      {1, 3, 6},
      {2, 3, 7},
      {2, 4, 8},
      {2, 5, 5},
      {3, 5, 9},
      {3, 4, 11},
      {4, 5, 10}
    }));
  }
}
