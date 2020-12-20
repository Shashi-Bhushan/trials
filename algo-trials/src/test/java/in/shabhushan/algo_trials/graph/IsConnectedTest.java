package in.shabhushan.algo_trials.graph;

import org.junit.Test;

import static in.shabhushan.algo_trials.graph.BFSTraversal.getGraph;
import static in.shabhushan.algo_trials.graph.IsConnected.isConnected;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class IsConnectedTest {
  @Test
  public void testIsConnected() {
    assertTrue(isConnected(getGraph(new String[]{
        "4 4",
        "0 1",
        "0 3",
        "1 2",
        "2 3"
    })));

    assertFalse(isConnected(getGraph(new String[]{
        "4 3",
        "0 1",
        "1 3",
        "0 3"
    })));
  }
}
