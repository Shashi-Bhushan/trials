package in.shabhushan.cp_trials.ds.tree;

import in.shabhushan.cp_trials.ds.tree.TreeNode;
import org.junit.Test;

import static in.shabhushan.cp_trials.ds.tree.CommonParent.commonNode;
import static org.junit.Assert.assertEquals;

public class CommonParentTest {
  @Test
  public void commonParent() {
    TreeNode root = new TreeNode(
        "A",
        new TreeNode("B",
          new TreeNode("D",
              new TreeNode("H"),
              new TreeNode("I")
          ),
          new TreeNode("E")
        ),
        new TreeNode("C",
            new TreeNode("F"),
            new TreeNode("G")
        )
    );

    assertEquals(new TreeNode("B"), commonNode(root, new TreeNode("I"), new TreeNode("E")));
  }
}
