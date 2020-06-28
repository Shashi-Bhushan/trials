package in.shabhushan.cp_trials.math.algebra;

import java.util.*;

/**
 * Leetcode solution for
 * https://leetcode.com/problems/max-value-of-equation/submissions/
 *
 * Check this for reference
 * https://www.youtube.com/watch?v=hOTpn8jE9jI
 */
class MaxValueEquation {

  /**
   * Brute Force O(n^2) solution
   */
  public int findMaxValueOfEquation2(int[][] points, int k) {
    int ans = Integer.MIN_VALUE;
    for (int i = 0; i < points.length; i++) {
      for (int j = i+1; j < points.length && points[j][0] - points[i][0] <= k; j++) {
        ans = Math.max(ans, points[i][1] + points[j][1] + points[j][0] - points[i][0]);
      }
    }
    return ans;
  }

  public int findMaxValueOfEquation(int[][] points, int k) {
    // Pair of (x, y)
    PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((a, b) -> (b.getValue() - b.getKey() - (a.getValue() - a.getKey())));
    
    int result = Integer.MIN_VALUE;
    
    for (int[] point: points) {
      int x = point[0];
      int y = point[1];
      
      if (queue.isEmpty()) {
        queue.offer(Map.entry(x, y));
      } else {
        // remove all values with xj - xi > k
        while (!queue.isEmpty() && x - queue.peek().getKey() > k) {
          queue.poll();
        }
        
        if (!queue.isEmpty()) {
          // current x is greater than queue.peek().getKey(), hence no math.abs
          result = Math.max(result, y + x + queue.peek().getValue() - queue.peek().getKey());
        }
        
        queue.offer(Map.entry(x, y));
      }
    }
    
    return result;
  }
}
