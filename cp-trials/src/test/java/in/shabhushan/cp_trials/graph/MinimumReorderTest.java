package in.shabhushan.cp_trials.graph;

import org.junit.Test;

import static in.shabhushan.cp_trials.graph.MinimumReorder.minReorder;
import static org.junit.Assert.assertEquals;

public class MinimumReorderTest {
  @Test
  public void testMinimumReorder() {
    assertEquals(3, minReorder(6, new int[][]{
        {0,1},{1,3},{2,3},{4,0},{4,5}
    }));
    assertEquals(2, minReorder(5, new int[][]{
        {1,0},{1,2},{3,2},{3,4}
    }));
    assertEquals(0, minReorder(3, new int[][]{
        {1,0}, {2,0}
    }));
  }
}
