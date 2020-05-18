package in.shabhushan.cp_trials.competition.codeforces.round643div2;

import org.junit.Test;

import static in.shabhushan.cp_trials.competition.codeforces.round643div2.Problem2YoungExplorer.getNumberOfGroups2;
import static in.shabhushan.cp_trials.competition.codeforces.round643div2.Problem2YoungExplorer.getNumberOfGroups;
import static org.junit.Assert.assertEquals;

public class Problem2YoungExplorerSolution {
  @Test
  public void testYoungExplorer() {
    assertEquals(3, getNumberOfGroups(new long[]{1, 1, 1}));
    assertEquals(2, getNumberOfGroups(new long[]{2, 3, 1, 2, 2}));
  }

  @Test
  public void testYoungExplorer2() {
    assertEquals(3, getNumberOfGroups2(new long[]{1, 1, 1}));
    assertEquals(2, getNumberOfGroups2(new long[]{2, 3, 1, 2, 2}));
  }
}
