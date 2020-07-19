package in.shabhushan.cp_trials.tree.gfg;

import org.junit.Test;

import static in.shabhushan.cp_trials.tree.gfg.MinNodesAVL.minNodesAVLTree;
import static in.shabhushan.cp_trials.tree.gfg.MinNodesAVL.minNodesAVLTreeDP;
import static org.junit.Assert.assertEquals;

public class MinNodesAVLTest {
  @Test
  public void testMinNodes() {
    assertEquals(7, minNodesAVLTree(3));
    assertEquals(12, minNodesAVLTree(4));
    assertEquals(232, minNodesAVLTree(10));
    assertEquals(433494436, minNodesAVLTree(40));
  }

  @Test
  public void testMinNodesDP() {
    assertEquals(7, minNodesAVLTreeDP(3));
    assertEquals(12, minNodesAVLTreeDP(4));
    assertEquals(232, minNodesAVLTreeDP(10));
    assertEquals(433494436, minNodesAVLTreeDP(40));
  }
}
