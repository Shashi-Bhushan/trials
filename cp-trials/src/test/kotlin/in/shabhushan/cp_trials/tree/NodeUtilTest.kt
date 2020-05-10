package `in`.shabhushan.cp_trials.tree

import `in`.shabhushan.cp_trials.tree.NodeUtil.inOrderTraversal
import `in`.shabhushan.cp_trials.tree.NodeUtil.postOrderTraversal
import `in`.shabhushan.cp_trials.tree.NodeUtil.preOrderTraversal
import kotlin.test.Test
import kotlin.test.assertEquals

class NodeUtilTest {
  @Test
  fun testInOrderTraversal() {
    val root = Node(
      1,
      Node(
        2, Node(3), Node(6)
      ),
      Node(4, Node(5))
    )

    assertArrayEquals(intArrayOf(3, 2, 6, 1, 5, 4), inOrderTraversal(root))
  }

  @Test
  fun testPreOrderTraversal() {
    val root = Node(
      1,
      Node(
        2, Node(3), Node(6)
      ),
      Node(4, Node(5))
    )

    assertArrayEquals(intArrayOf(1, 3, 2, 6, 5, 4), preOrderTraversal(root))
  }

  @Test
  fun testPostOrderTraversal() {
    val root = Node(
      1,
      Node(
        2, Node(3), Node(6)
      ),
      Node(4, Node(5))
    )

    assertArrayEquals(intArrayOf(3, 2, 6, 5, 4, 1), postOrderTraversal(root))
  }

  private fun assertArrayEquals(
    expecteds: IntArray,
    actuals: IntArray
  ) {
    for (i in actuals.indices)
      assertEquals(expecteds[i], actuals[i])
  }
}
