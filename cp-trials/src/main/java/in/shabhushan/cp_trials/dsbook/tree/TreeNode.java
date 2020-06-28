package in.shabhushan.cp_trials.dsbook.tree;

public class TreeNode {

    long sum;
    long depth;
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(long sum, long depth) {
        this.sum = sum;
        this.depth = depth;
    }

    public static boolean isPerfect(TreeNode root) {
        if (root != null) System.out.println(root.toString());
        if (root == null)
            return true;
        else if ((root.left == null && root.right != null) || (root.left != null && root.right == null))
            return false;
        else
            return isPerfect(root.left) && isPerfect(root.right);

    }

    public static TreeNode leaf() {
        return new TreeNode(1, 1);
    }

    public static TreeNode join(TreeNode left, TreeNode right) {
        return new TreeNode(left.sum + right.sum, left.depth + 1).withChildren(left, right);
    }

    public TreeNode withLeft(TreeNode left) {
        this.left = left;
        return this;
    }

    public TreeNode withRight(TreeNode right) {
        this.right = right;
        return this;
    }

    public TreeNode withChildren(TreeNode left, TreeNode right) {
        this.left = left;
        this.right = right;
        return this;
    }

    public TreeNode withLeftLeaf() {
        this.sum++;
        return withLeft(leaf());
    }

    public TreeNode withRightLeaf() {
        this.sum++;
        return withRight(leaf());
    }

    public TreeNode withLeaves() {
        this.sum += 2;
        return withChildren(leaf(), leaf());
    }

    public String toString() {
        return (this.left != null ? this.left.toString() + " <-- " : "") + this.sum + (this.right != null ? " --> " + this.right.toString() : "");
    }
}
