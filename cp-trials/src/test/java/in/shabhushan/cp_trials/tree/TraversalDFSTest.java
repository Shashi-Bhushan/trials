package in.shabhushan.cp_trials.tree;

import in.shabhushan.cp_trials.ds.tree.TreeNode;
import org.junit.Test;

import java.util.List;

import static in.shabhushan.cp_trials.tree.TraversalDFS.*;
import static org.junit.Assert.assertEquals;

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

    assertEquals(List.of(1, 2, 3, 4, 5, 6, 7), preOrder(node));
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

    assertEquals(List.of(1, 2, 3, 4, 5, 6, 7), inOrder(node));
  }

  @Test
  public void testPostOrder() {
    TreeNode<Integer> node = new TreeNode<>(7,
      new TreeNode<>(3,
        new TreeNode<>(1),
        new TreeNode<>(2)
      ),
      new TreeNode<>(6,
        new TreeNode<>(4),
        new TreeNode<>(5)
      )
    );

    assertEquals(List.of(1, 2, 3, 4, 5, 6, 7), postOrder(node));
  }
}
