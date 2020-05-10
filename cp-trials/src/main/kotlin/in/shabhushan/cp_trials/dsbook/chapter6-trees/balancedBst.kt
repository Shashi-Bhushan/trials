package `in`.shabhushan.cp_trials.dsbook.`chapter6-trees`

class Tree(
  var `val`: Int
) {
  var left: Tree? = null
  var right: Tree? = null
}

/**
 * Kotlin solution for https://leetcode.com/contest/weekly-contest-180/problems/balance-a-binary-search-tree/
 *
 * This solution gives the sorted List<Int> from a breadth first search tree
 */
fun dfs(root: Tree): List<Int> = (root.left?.let {
  dfs(it)
} ?: emptyList()) + listOf(root.`val`) + (root.right?.let {
  dfs(it)
} ?: emptyList())

/**
 * Sort of like merge sort, split the list into two
 * add new Tree node for middle element and call function recursively for other two parts
 */
fun mergeInMiddle(
  list: List<Int>,
  left: Int = 0,
  right: Int = list.size - 1
): Tree? = if (left > right) null else {
  val mid = (left + right) / 2

  Tree(list[mid]).apply {
    this.left = mergeInMiddle(list, left, mid - 1)
    this.right = mergeInMiddle(list, mid + 1, right)
  }
}

fun balanceBST(root: Tree?): Tree? = dfs(root!!).let { mergeInMiddle(it) }
