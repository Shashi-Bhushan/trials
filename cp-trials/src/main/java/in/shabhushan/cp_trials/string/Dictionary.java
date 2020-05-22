package in.shabhushan.cp_trials.string;

import java.util.HashMap;
import java.util.Map;

/**
 * Dictionary that allows only one typo
 * https://leetcode.com/discuss/interview-question/281470/
 */
public class Dictionary {

  private final Trie root;

  public Dictionary(String[] dictionary) {
    root = new Trie('*');

    setupTrie(dictionary);
  }

  private void setupTrie(String[] dictionary) {
    for (String word: dictionary) {
      Trie node = root;

      for (char c: word.toCharArray()) {
        if (!node.children.containsKey(c)) {
          node.children.put(c, new Trie(c));
        }

        node = node.children.get(c);
      }

      node.isWord = true;
    }
  }

  public boolean atMostOneTypo(String word) {
    return atMostOneTypo(word, root, 0, 0);
  }

  private boolean atMostOneTypo(String word, Trie node, int current, int typos) {
    if (typos > 1) {
      return false;
    } else if (current == word.length()) {
       return node.isWord;
    } else if (node.children.containsKey(word.charAt(current))) {
      return atMostOneTypo(word, node.children.get(word.charAt(current)), current + 1, typos);
    } else {
      // check for each children
      for (Map.Entry<Character, Trie> entry: node.children.entrySet()) {
        if (atMostOneTypo(word, entry.getValue(), current + 1, typos + 1)) {
          return true;
        }
      }
      return false;
    }
  }

  private static class Trie {
    Character c;
    boolean isWord;
    Map<Character, Trie> children;

    public Trie(Character c) {
      this.c = c;
      children = new HashMap<>();
    }
  }
}
