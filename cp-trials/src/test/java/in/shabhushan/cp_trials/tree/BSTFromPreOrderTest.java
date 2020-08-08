package in.shabhushan.cp_trials.tree;

import in.shabhushan.cp_trials.ds.tree.TreeNode;
import org.junit.Test;

import static in.shabhushan.cp_trials.tree.BSTfromPreOrder.getBst;
import static in.shabhushan.cp_trials.tree.TraversalDFS.levelOrder;

public class BSTFromPreOrderTest {
  @Test
  public void testBstFromPreorder() {
    TreeNode<Integer> answer = getBst(new int[]{30, 20, 10, 15, 25, 40, 50, 45});

    System.out.println(answer);

    System.out.println(levelOrder(answer));
  }
}
