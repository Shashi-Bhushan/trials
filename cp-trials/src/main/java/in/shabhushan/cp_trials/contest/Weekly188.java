package in.shabhushan.cp_trials.contest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.*;
import java.util.Map;

public class Weekly188 {

  /**
   * O(n^2) solution
   */
  public static int countTriplets(int[] arr) {
    int[] xorSum = new int[arr.length + 1];

    for (int i = 0; i < arr.length; i++) {
      xorSum[i + 1] = xorSum[i] ^ arr[i];
    }

    int ans = 0;

    for (int i = 0; i <= arr.length; i++) {
      for (int j = i + 2; j <= arr.length; j++) {
        if (xorSum[i] == xorSum[j]) {
          ans += j - i - 1;
        }
      }
    }
    return ans;
  }

  /**
   * Problem 2 : O(n^3)
   */
  public static int countTripletsInefficient(int[] arr) {
    int ans = 0;
    for (int i = 0; i < arr.length - 1; i++) {
      int a = arr[i];

      for (int j = i + 1; j < arr.length; j++) {
        int b = 0;

        for (int k = j; k < arr.length; k++) {
          b = b ^ arr[k];

          if (a == b) {
            //System.out.println(" i " + i + " j " + j + " k " + k);
            ans++;
          }
        }

        a = a ^ arr[j];
      }

    }

    return ans;
  }

  private static class Node {
    public Node(Integer n) {this.parent = n;}

    Integer parent;
    List<Integer> children = new ArrayList<>();

    @Override
    public String toString() {
      return String.format("Node { %d, %s }", parent, children);
    }
  }

  /**
   * Problem 3
   */
  public static int minTime(int n1, int[][] edges, List<Boolean> hasApple) {
    Map<Integer, Node> m = new HashMap<>();

    for (int[] edge: edges) {
      if (m.containsKey(edge[0])) {
        Node n = m.get(edge[0]);

        n.children.add(edge[1]);

        m.put(edge[1], new Node(edge[0]));
      } else {
        m.put(edge[0], new Node(edge[0]));
        m.get(edge[0]).children.add(edge[1]);

        m.put(edge[1], new Node(edge[0]));
      }
    }

    return 0;
  }
}
