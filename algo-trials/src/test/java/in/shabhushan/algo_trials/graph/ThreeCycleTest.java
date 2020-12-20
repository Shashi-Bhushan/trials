package in.shabhushan.algo_trials.graph;

import org.junit.Test;

import static in.shabhushan.algo_trials.graph.BFSTraversal.getGraph;
import static in.shabhushan.algo_trials.graph.ThreeCycle.solve;
import static org.junit.Assert.assertEquals;

public class ThreeCycleTest {
  @Test
  public void testThreeCycle() {
    assertEquals(1, solve(getGraph(new String[]{
        "3 3",
        "0 1",
        "1 2",
        "2 0",
    }), 3));

    assertEquals(0, solve(getGraph(new String[]{
        "2 1",
        "0 1",
    }), 2));

    assertEquals(4, solve(getGraph(new String[]{
        "6 9",
        "4 3",
        "4 0",
        "0 3",
        "3 1",
        "5 1",
        "5 3",
        "0 5",
        "0 2",
        "5 2",
    }), 6));

    assertEquals(0, solve(getGraph(new String[]{
        "5 0",
    }), 5));

    assertEquals(0, solve(getGraph(new String[]{
        "5 0",
    }), 5));

    assertEquals(1, solve(getGraph(new String[]{
        "6 4",
        "0 1",
        "0 2",
        "1 2",
        "3 4",
    }), 5));
  }
}
