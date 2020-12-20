package in.shabhushan.algo_trials.graph;

import org.junit.Test;

import static in.shabhushan.algo_trials.graph.LargestPiece.dfs;
import static org.junit.Assert.assertEquals;

public class LargestPieceTest {
  @Test
  public void testLargestPiece() {
    assertEquals(3, dfs(new String[]{
        "1 1",
        "0 1"
    }, 2));

    assertEquals(2, dfs(new String[]{
        "1 0 0",
        "0 1 0",
        "0 1 0",
    }, 3));

    assertEquals(1, dfs(new String[]{
        "1",
    }, 1));
  }
}
