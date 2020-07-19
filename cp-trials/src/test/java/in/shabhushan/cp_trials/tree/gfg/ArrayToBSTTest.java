package in.shabhushan.cp_trials.tree.gfg;

import in.shabhushan.cp_trials.ds.tree.TreeNode;
import org.junit.Test;

import java.util.List;

import static in.shabhushan.cp_trials.tree.TraversalDFS.inOrder;
import static in.shabhushan.cp_trials.tree.TraversalDFS.preOrder;
import static in.shabhushan.cp_trials.tree.gfg.ArrayToBST.sortedArrayToBST;
import static org.junit.Assert.assertEquals;

public class ArrayToBSTTest {
  @Test
  public void testSortedArrayToBST() {
    TreeNode<Integer> root = sortedArrayToBST(new int[]{1, 2, 3});

    assertEquals(List.of(2, 1, 3), preOrder(root));
    assertEquals(List.of(1, 2, 3), inOrder(root));
  }

  @Test
  public void testSortedArrayToBST2() {
    TreeNode<Integer> root = sortedArrayToBST(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});

    assertEquals(List.of(5, 2, 1, 3, 4, 7, 6, 8, 9), preOrder(root));
    assertEquals(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9), inOrder(root));
  }
}
