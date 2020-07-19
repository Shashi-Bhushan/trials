package in.shabhushan.cp_trials.tree.gfg;

/**
 * Given the height of an AVL tree ‘h’, the task is to find the minimum number of nodes the tree can have.
 * https://www.geeksforgeeks.org/minimum-number-of-nodes-in-an-avl-tree-with-given-height/
 */
public class MinNodesAVL {
  public static int minNodesAVLTree(int height) {
    if (height == 0)
      return 1;
    else if (height == 1)
      return 2;
    else
      // root + left + right (either left or right will have one less height than other)
      return 1 + minNodesAVLTree(height - 1) + minNodesAVLTree(height - 2);
  }

  public static int minNodesAVLTreeDP(int height) {
    if (height == 0)
      return 1;
    else if (height == 1)
      return 2;

    int[] dp = new int[height + 1];
    dp[0] = 1;
    dp[1] = 2;

    for (int i = 2; i <= height; i++) {
      dp[i] = dp[i - 1] + dp[i - 2] + 1;
    }

    return dp[height];
  }
}
