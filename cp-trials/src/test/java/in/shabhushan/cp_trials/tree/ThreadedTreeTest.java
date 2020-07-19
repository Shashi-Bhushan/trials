package in.shabhushan.cp_trials.tree;

import in.shabhushan.cp_trials.ds.tree.ThreadedTreeNode;
import org.junit.Test;

import java.util.List;

import static in.shabhushan.cp_trials.ds.tree.ThreadedTree.*;
import static org.junit.Assert.assertEquals;

public class ThreadedTreeTest {
  @Test
  public void testThreadedTree() {
    ThreadedTreeNode<Integer> root = new ThreadedTreeNode<>(5);

    insert(root, 6);
    insert(root, 9);
    insert(root, 1);
    insert(root, 8);
    insert(root, 7);

    assertEquals(List.of(1,5,6,7,8,9), inorderTraversal(root));

    //inorderTraverse(root);
  }
}
