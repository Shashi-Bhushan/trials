package in.shabhushan.cp_trials.tree;

import in.shabhushan.cp_trials.ds.tree.TreeNode;
import org.junit.Test;

import static in.shabhushan.cp_trials.tree.TraversalDFS.inOrder;
import static in.shabhushan.cp_trials.tree.TraversalDFS.preOrder;

public class TraversalDFSTest {
  @Test
  public void testPreOrder() {
    TreeNode<Integer> node = new TreeNode<>(1,
        new TreeNode<>(2,
          new TreeNode<>(3),
          new TreeNode<>(4)
        ),
        new TreeNode<>(5,
          new TreeNode<>(6),
          new TreeNode<>(7)
        )
      );

    preOrder(node);
  }

  @Test
  public void testInOrder() {
    TreeNode<Integer> node = new TreeNode<>(4,
      new TreeNode<>(2,
        new TreeNode<>(1),
        new TreeNode<>(3)
      ),
      new TreeNode<>(6,
        new TreeNode<>(5),
        new TreeNode<>(7)
      )
    );

    inOrder(node);
  }
}
