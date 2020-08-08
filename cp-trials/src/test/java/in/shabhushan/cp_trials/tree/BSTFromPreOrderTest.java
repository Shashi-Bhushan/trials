package in.shabhushan.cp_trials.tree;

import in.shabhushan.cp_trials.ds.tree.TreeNode;
import org.junit.Test;

import java.util.List;

import static in.shabhushan.cp_trials.tree.BSTfromPreOrder.getBst;
import static in.shabhushan.cp_trials.tree.TraversalDFS.levelOrder;
import static org.junit.Assert.assertEquals;

public class BSTFromPreOrderTest {
  @Test
  public void testBstFromPreorder() {
    TreeNode<Integer> answer = getBst(new int[]{30, 20, 10, 15, 25, 40, 50, 45});

    System.out.println(answer);

    assertEquals(List.of(30, 20, 40, 10, 25, 50, 15, 45), levelOrder(answer));
  }
}
