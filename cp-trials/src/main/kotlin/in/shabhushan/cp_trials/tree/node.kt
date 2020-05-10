package `in`.shabhushan.cp_trials.tree

data class Node(
  val data: Int,
  val left: Node? = null,
  val right: Node? = null
)

//TODO: Given an array, create it's BST

object NodeUtil {
  fun inOrderTraversal(
    root: Node?
  ): IntArray = root?.let {
    intArrayOf(*inOrderTraversal(root.left), root.data, *inOrderTraversal(root.right))
  } ?: intArrayOf()

  fun preOrderTraversal(
    root: Node?
  ): IntArray = root?.let {
    intArrayOf(root.data, *inOrderTraversal(root.left), *inOrderTraversal(root.right))
  } ?: intArrayOf()

  fun postOrderTraversal(
    root: Node?
  ): IntArray = root?.let {
    intArrayOf(*inOrderTraversal(root.left), *inOrderTraversal(root.right), root.data)
  } ?: intArrayOf()
}
