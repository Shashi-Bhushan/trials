package in.shabhushan.cp_trials.string;

/**
 * https://leetcode.com/problems/longest-duplicate-substring/discuss/695214/JAVA-or-Binary-search-O(n-log-n)-average-with-Rabin-Karp-Algorithm
 */
class LongestDuplicateSubstring {
  public String longestDupSubstring(String S) {
    class Trie {
      Trie[] children;
      final int startPos;
      final int depth;

      Trie(int startPos, int depth) {
        this.startPos = startPos;
        this.depth = depth;
      }

      boolean isLeaf() {
        return children == null;
      }

      int childIndex(int start) {
        return S.charAt(start + depth) - 'a';
      }

      int addNew(int start) {
        if (start + depth == S.length())
          return depth;
        if (isLeaf()) {
          children = new Trie[28];
          children[childIndex(startPos)] = new Trie(startPos, depth + 1);
        }
        int newIndex = childIndex(start);
        Trie child = children[newIndex];
        if (child == null) {
          children[newIndex] = new Trie(start, depth + 1);
          return depth;
        }
        return child.addNew(start);
      }
    }

    int maxStart = 0, maxLength = 0;
    int length = S.length();
    Trie root = new Trie(0, 0);
    for (int i = 1; i + maxLength < length; ++i) {
      int len = root.addNew(i);
      if (len > maxLength) {
        maxLength = len;
        maxStart = i;
      }
    }
    return S.substring(maxStart, maxStart + maxLength);
  }
}
