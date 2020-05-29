package in.shabhushan.algo_trials.dynamic_programming.chapter4;

public class MinimumCostOfTravel {
  public static int getMinimumCost(int[][] cost, int source, int destination) {
    if (source == destination || source + 1 == destination)
      return cost[source][destination];

    // consider direct travel from source to destination as min
    int min = cost[source][destination];
    for (int i = source + 1; i < destination; i++) {
      min = Math.min(min, getMinimumCost(cost, source, i) + getMinimumCost(cost, i, destination));
    }

    return min;
  }

  public static int getMinimumCostFaster(int[][] cost) {
    int[] minCost = new int[cost.length];

    minCost[0] = 0;
    minCost[1] = cost[0][1];

    for (int i = 2; i < cost.length; i++) {
      minCost[i] = cost[0][i];

      // cost between 0 and i, considering j as middle station
      for (int j = 1; j < i; j++) {
        minCost[i] = Math.min(minCost[i], minCost[j] + cost[j][i]);
      }
    }

    return minCost[cost.length - 1];
  }
}
