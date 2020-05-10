package in.shabhushan.cp_trials.google_interview;

import in.shabhushan.cp_trials.dsbook.tree.TreeNode;
import org.junit.Test;

import static in.shabhushan.cp_trials.google_interview.ClementCodingInterviews.sumOfTreeDepth;
import static org.junit.Assert.assertEquals;

public class ClementCodingInterviewsTest {
  @Test
  public void testNodeDepth() {
    // 1
    TreeNode root = TreeNode.leaf().withChildren(
        // 2
        TreeNode.leaf().withChildren(
            // 4
            TreeNode.leaf().withChildren(
                //8
                TreeNode.leaf(),
                // 9
                TreeNode.leaf()
            ),
            // 5
            TreeNode.leaf()
        ),
        // 3
        TreeNode.leaf().withChildren(
          TreeNode.leaf(),
          TreeNode.leaf()
        )
    );

    assertEquals(16, sumOfTreeDepth(root));
  }
}
