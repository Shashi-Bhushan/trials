package in.shabhushan.algo_trials.algorithms.chapter1.section5;

/**
 * This is the lazy approach
 * Union is quick but find takes more time if the tree is too tall.
 *
 * on n objects, find would take O(n^2) time
 */
public class QuickUnion implements UnionFind {

  private int[] parent;
  private int count;
  private int totalCount;
  private int findCount;
  private int checkParentCount;
  private int updateParentCount;

  public QuickUnion(int numComponents) {
    parent = new int[numComponents];
    count = numComponents;

    for (int i = 0; i < numComponents; i++) {
      parent[i] = i;
    }
  }

  @Override
  public void union(int p, int q) {
    int rootP = find(p);
    int rootQ = find(q);

    if (rootP == rootQ) return;

    updateParentCount++;
    totalCount++;
    parent[rootP] = rootQ;
    count--;
  }

  @Override
  public boolean connected(int p, int q) {
    p = find(p);
    q = find(q);

    return p == q;
  }

  @Override
  public int find(int p) {
    findCount++;
    totalCount++;
    while (parent[p] != p) {
      checkParentCount++;
      totalCount++;
      p = parent[p];
    }

    return p;
  }

  @Override
  public int count() {
    return count;
  }

  @Override
  public int[] getParent() {
    return parent;
  }

  @Override
  public int[] getTotalCount() {
    int[] stats = new int[]{totalCount, findCount, checkParentCount, updateParentCount};

    resetStats();

    return stats;
  }

  private void resetStats() {
    totalCount = 0;
    findCount = 0;
    checkParentCount = 0;
    updateParentCount = 0;
  }
}
