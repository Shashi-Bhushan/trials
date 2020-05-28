package in.shabhushan.cp_trials.dynamic_programming;

import org.junit.Test;

import static in.shabhushan.cp_trials.dynamic_programming.MinCostBetweenStations.minCostBetweenStations;
import static org.junit.Assert.assertEquals;

public class MinCostBetweenStationsTest {
  @Test
  public void testMinCostBetweenStations() {
    int[][] costs = new int[][]{
        {0, 10, 75, 94},
        {-1, 0, 35, 50},
        {-1, -1, 0, 80},
        {-1, -1, -1, 0}
    };

    assertEquals(45, minCostBetweenStations(costs, 0, 2));
    assertEquals(60, minCostBetweenStations(costs, 0, 3));
  }
}
