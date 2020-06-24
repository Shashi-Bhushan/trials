package in.shabhushan.cp_trials.sweepline;

import java.util.*;

/**
 * Leetcode solution for
 * https://leetcode.com/problems/car-pooling/submissions/
 */
class CarPooling {
  public boolean carPooling(int[][] trips, int capacity) {
    Arrays.sort(trips, (a, b) -> a[1] - b[1]);

    // ending to capacity queue
    PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((a, b) -> a.getKey() - b.getKey());

    int count = 0;

    for (int i = 0; i < trips.length; i++) {
      if (queue.isEmpty()) {
        queue.add(Map.entry(trips[i][2], i));
        count += trips[i][0];
      } else {
        while (!queue.isEmpty() && queue.peek().getKey() <= trips[i][1]) {
          count -= trips[queue.poll().getValue()][0];
        }

        count += trips[i][0];

        if (count > capacity) return false;

        queue.add(Map.entry(trips[i][2], i));
      }
    }

    return count <= capacity;
  }

  public boolean carPooling2(int[][] trips, int capacity) {
    // ending to capacity queue
    PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((a, b) -> a.getKey() - b.getKey());

    for (int[] trip: trips) {
      queue.offer(Map.entry(trip[1], -trip[0]));
      queue.offer(Map.entry(trip[2], trip[0]));
    }

    int count = capacity;

    while (!queue.isEmpty()) {
      Map.Entry<Integer, Integer> entry = queue.poll();

      count += entry.getValue();
      while (!queue.isEmpty() && queue.peek().getKey().equals(entry.getKey())) {
        count += (queue.poll().getValue());
      }

      if (count < 0)
        return false;
    }

    return true;
  }
}
