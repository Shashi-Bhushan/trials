package in.shabhushan.cp_trials.tree;

import java.util.*;

/**
 * Leetcode solution for
 * https://leetcode.com/problems/graph-valid-tree/
 */
public class GraphValidTree {
  public boolean validTree(int n, int[][] edges) {
    Map<Integer, List<Integer>> adj = new HashMap<>();
    
    for (int i = 0 ;i < n; i++) {
      adj.put(i, new ArrayList<>());
    }
    
    for (int[] edge: edges) {
      adj.get(edge[0]).add(edge[1]);
      adj.get(edge[1]).add(edge[0]);
    }
      
    // seen node to it's parent
    Map<Integer, Integer> parent = new HashMap<>();
    parent.put(0, -1);
    
    Stack<Integer> stack = new Stack<>();
    stack.push(0);
    
    while (!stack.isEmpty()) {
      Integer node = stack.pop();
      
      for (Integer neighbour: adj.get(node)) {
        // find parent of node, if it's this neighbour(this neighbour is parent of node) then skip it
         if (!parent.get(node).equals(neighbour)) {
          // if it's not parent and still I've already seen this children before, then means it's a cycle
          if (parent.containsKey(neighbour)) {
            return false;  
          }

          stack.push(neighbour);
          parent.put(neighbour, node);
        }
      }
    }
    
    return parent.size() == n;
  }
}
