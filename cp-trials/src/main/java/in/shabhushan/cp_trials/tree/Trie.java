package in.shabhushan.cp_trials.tree;

import java.util.*;

class Trie {

  private static class Node {
    final char c;
    boolean word;
    final Map<Character, Node> children;

    public Node(char c) {
      this(c, false);
    }

    public Node(char c, boolean word) {
      this.c = c;
      this.word = word;
      this.children = new HashMap<>();
    }

    @Override
    public boolean equals(Object otherNode) {
      return otherNode instanceof Node && ((Node)otherNode).c == this.c;
    }

    @Override
    public int hashCode() {
      return c - '0';
    }
  }

  private Node root;

  /** Initialize your data structure here. */
  public Trie() {
    root = new Node('-');
  }

  /** Inserts a word into the trie. */
  public void insert(String word) {
    // recursive insert character
    insert(root, word, 0);
  }

  private void insert(Node node, String word, int index) {
    if (index == word.length()) {
      node.word = true;
      return;
    }

    char c = word.charAt(index);

    if (node.children.containsKey(c)) {
      insert(node.children.get(c), word, index + 1);
    } else {
      Node newNode = new Node(word.charAt(index));

      node.children.put(c, newNode);
      insert(newNode, word, index + 1);
    }
  }

  /** Returns if the word is in the trie. */
  public boolean search(String word) {
    return search(this.root.children.get(word.charAt(0)), word, 0, false);
  }

  /** Returns if there is any word in the trie that starts with the given prefix. */
  public boolean startsWith(String prefix) {
    return search(this.root.children.get(prefix.charAt(0)), prefix, 0, true);
  }

  private boolean search(Node node, String word, int from, boolean prefixMode) {
    if (node == null) {
      return false;
    }
    else if (from + 1 == word.length())
      if (prefixMode)
        return node.c == word.charAt(from);
      else
        return node.c == word.charAt(from) && node.word;
    else {
      return node.c == word.charAt(from) && search(node.children.get(word.charAt(from + 1)), word, from + 1, prefixMode);
    }
  }
}
