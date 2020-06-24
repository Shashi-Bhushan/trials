package in.shabhushan.cp_trials.sweepline;

import java.util.*;

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
}
