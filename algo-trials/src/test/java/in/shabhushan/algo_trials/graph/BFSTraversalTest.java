package in.shabhushan.algo_trials.graph;

import org.junit.Test;

import java.util.List;

import static in.shabhushan.algo_trials.graph.BFSTraversal.getBfsTraversal;
import static in.shabhushan.algo_trials.graph.BFSTraversal.getGraph;
import static org.junit.Assert.assertEquals;

public class BFSTraversalTest {
  @Test
  public void testBFSTraversal() {
    assertEquals(List.of(0, 1, 3, 2), getBfsTraversal(getGraph(new String[]{
        "4 4",
        "0 1",
        "0 3",
        "1 2",
        "2 3",
    })));

    assertEquals(List.of(), getBfsTraversal(getGraph(new String[]{
        "0 0"
    })));

    assertEquals(List.of(0), getBfsTraversal(getGraph(new String[]{
        "1 0"
    })));

    assertEquals(List.of(0, 1), getBfsTraversal(getGraph(new String[]{
        "2 1",
        "0 1"
    })));

    assertEquals(List.of(0, 1, 2, 3, 4), getBfsTraversal(getGraph(new String[]{
        "5 0"
    })));

    assertEquals(List.of(0, 6, 8, 1, 5, 7, 2, 3, 4), getBfsTraversal(getGraph(new String[]{
        "9 10",
        "0 8",
        "1 6",
        "1 7",
        "1 8",
        "5 8",
        "6 0",
        "7 3",
        "7 4",
        "8 7",
        "2 5",
    })));

    assertEquals(List.of(0, 1, 2, 3, 4), getBfsTraversal(getGraph(new String[]{
        "5 8",
        "0 1",
        "0 4",
        "1 2",
        "2 0",
        "2 4",
        "3 0",
        "3 2",
        "4 3",
    })));
  }
}
