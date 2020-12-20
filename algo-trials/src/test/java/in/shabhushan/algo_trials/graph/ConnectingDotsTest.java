package in.shabhushan.algo_trials.graph;

import org.junit.Test;

import static in.shabhushan.algo_trials.graph.ConnectingDots.solve;
import static org.junit.Assert.assertEquals;

public class ConnectingDotsTest {
  @Test
  public void testConnectingDots() {
    assertEquals(1, solve(new String[]{
        "AAAA",
        "ABCA",
        "AAAA",
    }, 3, 4));

    assertEquals(1, solve(new String[]{
        "YYYR",
        "BYBY",
        "BBBY",
        "BBBY",
    }, 4, 4));

    assertEquals(1, solve(new String[]{
        "AAAAAB\n" +
        "ABBBAB",
        "ABAAAB",
        "ABABBB",
        "ABAAAB",
        "ABBBAB",
        "AAAAAB",
    }, 7, 6));
  }
}
