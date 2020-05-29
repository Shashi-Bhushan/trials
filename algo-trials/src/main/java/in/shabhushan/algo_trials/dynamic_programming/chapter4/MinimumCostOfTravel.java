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
}
