package in.shabhushan.algo_trials.dynamic_programming.chapter4;

import org.junit.Test;

import static in.shabhushan.algo_trials.dynamic_programming.chapter4.MinimumCostOfTravel.getMinimumCost;
import static in.shabhushan.algo_trials.dynamic_programming.chapter4.MinimumCostOfTravel.getMinimumCostFaster;
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

    assertEquals(45, getMinimumCost(costs, 0, 2));
    assertEquals(60, getMinimumCost(costs, 0, 3));
  }

  @Test
  public void testMinCostBetweenStationsFaster() {
    int[][] costs = new int[][]{
        {0, 10, 75, 94},
        {-1, 0, 35, 50},
        {-1, -1, 0, 80},
        {-1, -1, -1, 0}
    };

    assertEquals(60, getMinimumCostFaster(costs));
  }
}
