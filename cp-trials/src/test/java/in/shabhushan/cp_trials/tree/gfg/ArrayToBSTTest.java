package in.shabhushan.cp_trials.tree.gfg;

import in.shabhushan.cp_trials.ds.tree.TreeNode;
import org.junit.Test;

import java.util.List;

import static in.shabhushan.cp_trials.tree.TraversalDFS.*;
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
    TreeNode<Integer> root = sortedArrayToBST(new int[]{10, 20, 30, 40, 50, 60, 70, 80, 90,100,110,120,130,140,150,160,170,180});

    assertEquals(List.of(90, 40, 140, 20, 60, 110, 160, 10, 30, 50, 70, 100, 120, 150, 170, 80, 130, 180), levelOrder(root));
    assertEquals(List.of(90, 40, 20, 10, 30, 60, 50, 70, 80, 140, 110, 100, 120, 130, 160, 150, 170, 180), preOrder(root));
    assertEquals(List.of(10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120, 130, 140, 150, 160, 170, 180), inOrder(root));
  }
}
