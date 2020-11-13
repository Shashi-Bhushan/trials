package in.shabhushan.algo_trials.clrs.chapter14;

import org.junit.Test;

public class RedBlackBinarySearchTreeTest {
  @Test
  public void testRedBlackTree() {
    RedBlackBinarySearchTree<Integer, String> rbTree = new RedBlackBinarySearchTree<>();

    rbTree.put(1, "Shashi");
    rbTree.put(2, "Bhushan");
    rbTree.put(1, "Shashi Bhushan");

    System.out.println(rbTree);
  }
}
