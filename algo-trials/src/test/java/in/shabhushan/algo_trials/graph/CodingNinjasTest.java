package in.shabhushan.algo_trials.graph;

import org.junit.Test;

import static in.shabhushan.algo_trials.graph.CodingNinjas.solve;
import static org.junit.Assert.assertEquals;

public class CodingNinjasTest {
  @Test
  public void testCodingNinjas() {
    assertEquals(1, solve(new String[]{
        "CXDXNXNXNXA",
        "XOXIXGXIXJX",
    }, 2, 11));

    assertEquals(1, solve(new String[]{
        "COYXNXNXNXA",
        "CXDXNXNXNXA",
        "XXXIXGXIXJX",
    }, 3, 11));
  }
}
