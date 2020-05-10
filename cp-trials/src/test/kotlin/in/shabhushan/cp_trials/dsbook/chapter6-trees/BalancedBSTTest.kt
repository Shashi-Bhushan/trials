package `in`.shabhushan.cp_trials.dsbook.`chapter6-trees`

import kotlin.test.Test

class BalancedBSTTest {
  @Test
  fun test() {
    val tree = Tree(1).also {
      it.right = Tree(2).also {
        it.right = Tree(3).also {
          it.right = Tree(4)
        }
      }
    }

    println(balanceBST(tree))
  }
}
