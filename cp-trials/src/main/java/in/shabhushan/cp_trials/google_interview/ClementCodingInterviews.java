package in.shabhushan.cp_trials.google_interview;

import in.shabhushan.cp_trials.dsbook.tree.TreeNode;

import java.util.HashSet;
import java.util.Set;

/**
 * Solution for coding interview questions at https://www.youtube.com/watch?v=-tNMxwWSN_M
 */
public class ClementCodingInterviews {
  /**
   * Problem 1 Solution
   */
  public static int sumOfTreeDepth(TreeNode node) {
    return bfs(node);
  }

  private static int bfs(TreeNode node) {
    Set<TreeNode> set = new HashSet<>();
    set.add(node);

    int depth = 0;
    int sum = 0;
    while (!set.isEmpty()) {
      depth++;
      Set<TreeNode> temp = new HashSet<>();

      for (TreeNode n: set) {
        if (n.left != null) {
          temp.add(n.left);
        }
        if (n.right != null) {
          temp.add(n.right);
        }
      }

      set.clear();
      set.addAll(temp);

      sum += set.size() * depth;
    }

    return sum;
  }

  public static int sumOfAllSubTreeDepth(TreeNode node) {
    return 0;
  }
}
