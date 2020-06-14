package in.shabhushan.cp_trials.graph;

import java.util.*;

/**
 * Leetcode solution for
 * https://leetcode.com/problems/cheapest-flights-within-k-stops/
 *
 * Check this for reference
 * https://www.youtube.com/watch?v=71xQSBWUupU
 */
class CheapestFlightWithinKStop {
  public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
    Map<Integer, List<Node>> adj = new HashMap<>();

    for (int[] flight: flights) {
      adj.putIfAbsent(flight[0], new ArrayList<>());
      adj.get(flight[0]).add(new Node(flight[1], flight[2]));
    }

    // queue has minimum cost entries first
    PriorityQueue<CostMetric> queue = new PriorityQueue<>((a, b) -> Integer.compare(a.cost, b.cost));

    queue.offer(new CostMetric(src, 0, K));

    while (!queue.isEmpty()) {
      CostMetric c = queue.poll();

      if (c.current == dst) {
        return c.cost;
      }

      if (c.step >= 0 && adj.containsKey(c.current)) {
        for (Node node: adj.get(c.current)) {
          queue.add(new CostMetric(node.destination, c.cost + node.cost, c.step - 1));
        }
      }

    }

    return -1;
  }

  private static class CostMetric {
    int current;
    int cost;
    int step;

    public CostMetric(int current, int cost, int step) {
      this.current= current;
      this.cost = cost;
      this.step = step;
    }

    @Override
    public String toString() {
      return String.format("{current %d, cost %d, step %d}", current, cost, step);
    }
  }

  private static class Node {
    int cost;
    int destination;

    public Node(int destination, int cost) {
      this.cost = cost;
      this.destination = destination;
    }

    @Override
    public String toString() {
      return String.format("{cost %d, destination %d}", cost, destination);
    }
  }
}
