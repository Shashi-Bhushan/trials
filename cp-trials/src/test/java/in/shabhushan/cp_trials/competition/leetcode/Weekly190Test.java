package in.shabhushan.cp_trials.competition.leetcode;

import in.shabhushan.cp_trials.dsbook.tree.TreeNode;
import org.junit.Test;

import static in.shabhushan.cp_trials.competition.leetcode.Weekly190.pseudoPalindromicPaths;
import static org.junit.Assert.assertEquals;

public class Weekly190Test {
  @Test
  public void testPseudoPalindrome() {
    Weekly190.PseudoTreeNode node = new Weekly190.PseudoTreeNode(2,
        new Weekly190.PseudoTreeNode(3,
            new Weekly190.PseudoTreeNode(3),
            new Weekly190.PseudoTreeNode(1)
        ),
        new Weekly190.PseudoTreeNode(1,
            null,
            new Weekly190.PseudoTreeNode(1)
        )
    );

    assertEquals(2, pseudoPalindromicPaths(node));
  }
}
