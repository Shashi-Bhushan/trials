package in.shabhushan.cp_trials.dynamic_programming;

public class MinCostBetweenStations {
  public static int minCostBetweenStations(int[][] cost, int source, int destination) {
    System.out.println("Solving for source " + source + " destination " + destination);
    if (source == destination || source + 1 == destination)
      return cost[source][destination];

    int min = cost[source][destination];
    for (int i = source + 1; i < destination; i++) {
      min = Math.min(min, minCostBetweenStations(cost, source, i) + minCostBetweenStations(cost, i, destination));
    }

    return min;
  }
}
