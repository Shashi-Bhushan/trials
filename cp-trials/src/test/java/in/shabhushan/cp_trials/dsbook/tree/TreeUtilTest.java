package in.shabhushan.cp_trials.dsbook.tree;

import org.junit.Test;

import static in.shabhushan.cp_trials.dsbook.tree.TreeUtil.diameterOfBinaryTree;
import static org.junit.Assert.assertEquals;

public class TreeUtilTest {
  @Test
  public void testGetDiameterOfBinaryTree() {
    assertEquals(1, diameterOfBinaryTree(TreeNode.leaf().withChildren(
        TreeNode.leaf(),
        null
    )));

    assertEquals(2, diameterOfBinaryTree(TreeNode.leaf().withChildren(
        TreeNode.leaf(),
        TreeNode.leaf()
    )));

    assertEquals(3, diameterOfBinaryTree(TreeNode.leaf().withChildren(
        TreeNode.leaf().withChildren(null, TreeNode.leaf()),
        TreeNode.leaf()
    )));

    assertEquals(4, diameterOfBinaryTree(TreeNode.leaf().withChildren(
        TreeNode.leaf().withChildren(TreeNode.leaf(), TreeNode.leaf()),
        TreeNode.leaf().withChildren(TreeNode.leaf(), TreeNode.leaf())
    )));

    assertEquals(2, diameterOfBinaryTree(TreeNode.leaf().withChildren(
        TreeNode.leaf().withChildren(TreeNode.leaf(), TreeNode.leaf()),
        null
    )));
  }
}
