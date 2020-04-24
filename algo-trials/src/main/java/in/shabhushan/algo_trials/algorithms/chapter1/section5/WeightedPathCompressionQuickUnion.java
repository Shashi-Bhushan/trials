package in.shabhushan.algo_trials.algorithms.chapter1.section5;

/**
 * This is the lazy approach
 * Union is quick but find takes more time if the tree is too tall.
 *
 * on n objects, find would take O(n^2) time
 */
public class WeightedPathCompressionQuickUnion implements UnionFind {

  private int[] parent;
  private int[] size;
  private int count;
  private int arrayAccessCount;

  public WeightedPathCompressionQuickUnion(int numComponents) {
    parent = new int[numComponents];
    size = new int[numComponents];
    count = numComponents;

    for (int i = 0; i < numComponents; i++) {
      parent[i] = i;
      size[i] = 1;
    }
  }

  @Override
  public void union(int p, int q) {
    int rootP = find(p);
    int rootQ = find(q);

    if (rootP == rootQ) return;

    if (size[rootP] < size[rootQ]) {
      parent[rootP] = rootQ;
      size[rootQ] += size[rootP];
    } else {
      parent[rootQ] = rootP;
      size[rootP] += rootQ;
    }
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
    while (parent[p] != p) {
      parent[p] = parent[parent[p]];
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
    return new int[] { arrayAccessCount };
  }
}
