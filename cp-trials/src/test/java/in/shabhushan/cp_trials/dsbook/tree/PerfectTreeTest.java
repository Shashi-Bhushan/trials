package in.shabhushan.cp_trials.dsbook.tree;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PerfectTreeTest {

    /**
     * null
     */
    @Test
    public void testNullTree() {
        TreeNode root = null;
        assertThat("null tree should be perfect", TreeNode.isPerfect(root), is(true));
    }

    /**
     * 0
     * / \
     * 0   0
     */
    @Test
    public void testFullOneLevelTree() {
        TreeNode root = TreeNode.leaf().withLeaves();
        assertThat("root with two leaves should be perfect", TreeNode.isPerfect(root), is(true));
    }


    /**
     * 0
     * /
     * 0
     */
    @Test
    public void testOneChildTree() {
        TreeNode root = TreeNode.leaf().withLeftLeaf();
        assertThat("root with single leaf should not be perfect", TreeNode.isPerfect(root), is(false));
    }

    /**
     * 0
     * /
     * 0
     */
    @Test
    public void testTwoChildTree() {
        TreeNode left = TreeNode.leaf().withLeftLeaf().withLeftLeaf();
        TreeNode right = TreeNode.leaf().withRightLeaf().withRightLeaf();

        TreeNode root = TreeNode.join(left, right);

        assertThat("root with single leaf should not be perfect", TreeNode.isPerfect(root), is(false));
    }

    @Test
    public void testMultipleChildTree() {
        TreeNode root = TreeNode.leaf().withLeftLeaf();

        assertThat("root with single leaf should not be perfect", TreeNode.isPerfect(root), is(false));
    }
}
