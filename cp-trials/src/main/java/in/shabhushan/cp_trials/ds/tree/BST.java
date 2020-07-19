package in.shabhushan.cp_trials.ds.tree;

public class BST {
  public static <TYPE extends Integer> TreeNode<TYPE> delete(TreeNode<TYPE> root, TYPE key) {
    if (root == null) return root;

    // key is smaller
    if (key.compareTo(root.value) < 0) {
      root.left = delete(root.left, key);
    } else if (key.compareTo(root.value) > 1) {
      root.right = delete(root.right, key);
    } else {
      // found the node, replace this with it's in-order successor
      if (root.left == null) {
        return root.right;
      } else if (root.right == null) {
        return root.left;
      } else {
        // have both children
        TreeNode<TYPE> successor = root.right;

        while (successor.left != null) {
          successor = successor.left;
        }

        // remove inorder successor of this node and assign new tree to it's right
        root.right = delete(root.right, successor.value);
      }
    }

    return root;
  }
}
