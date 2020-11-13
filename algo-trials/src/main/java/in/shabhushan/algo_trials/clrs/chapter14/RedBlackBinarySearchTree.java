package in.shabhushan.algo_trials.clrs.chapter14;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;

public class RedBlackBinarySearchTree<K extends Comparable<K>, V> {
  private static final AtomicBoolean RED = new AtomicBoolean(true);
  private static final AtomicBoolean BLACK = new AtomicBoolean(false);

  private static final String LINE_SEPARATOR = System.getProperty("line.separator");

  private BSTNode root;

  public RedBlackBinarySearchTree() {

  }

  /*************************
   * Public Helper Functions
   *************************/

  public int size() {
    return size(this.root);
  }

  public boolean isEmpty() {
    return this.root == null;
  }

  public V get(K key) {
    return get(this.root, key);
  }

  public void put(K key, V value) {
    root = put(root, key, value);
    root.color = BLACK;
  }

  public boolean contains(K key) {
    return get(key) != null;
  }

  public Iterable<K> keys() {
    return keys(min(), max());
  }

  public K min() {
    return min(root).key;
  }

  public K max() {
    return max(root).key;
  }

  public Iterable<K> keys(K low, K high) {
    Queue<K> queue = new ArrayDeque<>();

    keys(root, queue, low, high);

    return queue;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();

    Queue<BSTNode> queue = new ArrayDeque<>();
    queue.add(root);

    while (!queue.isEmpty()) {
      BSTNode node = queue.poll();

      sb.append("[")
          .append(node.key)
          .append(", ")
          .append(node.value)
          .append("] ")
          .append("(")
          .append(color(node))
          .append(") => L:");

      if (node.left != null) {
        sb.append(node.left.key);
        queue.add(node.left);
      }

      sb.append(" R:");

      if (node.right != null) {
        sb.append(node.right.key);
        queue.add(node.right);
      }

      sb.append(LINE_SEPARATOR);
    }


    return sb.toString();
  }

  /**************************
   * Private Helper Functions
   **************************/

  private V get(BSTNode node, K key) {
    while (node != null) {
      int compare = key.compareTo(node.key);

      // key to insert is smaller
      if (compare < 0) node = node.left;
      // key to insert is larger
      else if (compare > 0) node = node.right;
      else return node.value;
    }

    return null;
  }

  private BSTNode put(BSTNode node, K key, V value) {
    if (node == null) return new BSTNode(key, value, RED, 1);

    int compare = key.compareTo(node.key);

    // key to insert is smaller
    if (compare < 0) node.left = put(node.left, key, value);
    // key to insert is larger
    else if (compare > 0) node.right = put(node.right, key, value);
    // else replace with current value of node
    else node.value = value;

    //////////////
    // NODE Fix UP
    ///////////////
    if (isRed(node.right) && !isRed(node.left)) node = rotateLeft(node);
    if (!isRed(node.right) && isRed(node.left)) node = rotateRight(node);
    // if both red, move the node color up the tree
    if (isRed(node.right) && isRed(node.left)) flipColors(node);

    node.size = size(node.left) + 1 + size(node.right);

    return node;
  }

  /**
   * If a tree is leaning to the left, right rotate the BST
   * While rotating RIGHT, left node should be RED
   */
  private BSTNode rotateRight(BSTNode node) {
    //assert(isRed(node.left));

    BSTNode left = node.left;
    node.left = left.right;

    left.right = node;
    left.color = left.right.color;
    left.right.color = RED;
    left.size = node.size;

    node.size = size(node.left) + 1 + size(node.right);

    return left;
  }

  private BSTNode rotateLeft(BSTNode node) {
    //assert(isRed(node.right));

    BSTNode right = node.right;
    node.right = right.left;

    right.left = node;
    right.color = right.left.color;
    right.left.color = RED;
    right.size = node.size;

    node.size = size(node.left) + 1 + size(node.right);

    return right;
  }

  /**
   * Restore Red Black Tree properties
   */
  private BSTNode balance(BSTNode node) {
    if (isRed(node.right)) node = rotateLeft(node);
    if (isRed(node.left) && isRed(node.left.left)) node = rotateRight(node);
    if (isRed(node.left) && isRed(node.right)) flipColors(node);

    node.size = size(node.left) + 1 + size(node.right);

    return node;
  }

  private void flipColors(BSTNode node) {
    node.color = negate(node.color);
    node.left.color = negate(node.left.color);
    node.right.color = negate(node.right.color);
  }

  private AtomicBoolean negate(AtomicBoolean color) {
    return color == RED? BLACK : RED;
  }

  private int size(BSTNode node) {
    if (node == null) return 0;
    else return node.size;
  }

  private boolean isRed(BSTNode node) {
    if (node == null) return false;
    return node.color == RED;
  }

  private String color(BSTNode node) {
    return isRed(node) ? "RED" : "BLACK";
  }

  private void keys(BSTNode node, Queue<K> queue, K low, K high) {
    if (node == null) return;

    int compareLow = low.compareTo(node.key);
    int compareHigh = high.compareTo(node.key);

    if (compareLow < 0) keys(node.left, queue, low, high);
    if (compareLow <= 0 && 0 <= compareHigh) queue.add(node.key);
    if (compareHigh > 0) keys(node.right, queue, low, high);
  }

  private BSTNode min(BSTNode node) {
    if (node.left == null) return node;
    else return min(node.left);
  }

  private BSTNode max(BSTNode node) {
    if (node.right == null) return node;
    else return max(node.right);
  }

  private class BSTNode {
    private final K key;
    private V value;
    private BSTNode left;
    private BSTNode right;
    private AtomicBoolean color;
    private int size;

    public BSTNode(K key, V value, AtomicBoolean color, int size) {
      this.key = key;
      this.value = value;
      this.color = color;
      this.size = size;
    }
  }
}
