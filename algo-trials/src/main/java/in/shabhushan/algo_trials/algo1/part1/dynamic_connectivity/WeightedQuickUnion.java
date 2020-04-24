package in.shabhushan.algo_trials.algo1.part1.dynamic_connectivity;

/**
 * This is the lazy approach
 * Union is quick but find takes more time if the tree is too tall.
 *
 * on n objects, find would take O(n^2) time
 */
public class WeightedQuickUnion implements UnionFind {

  private int[] parent;
  private int[] size;
  private int count;

  public WeightedQuickUnion(int numComponents) {
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
    while (parent[p] != p)
      p = parent[p];

    return p;
  }

  @Override
  public int count() {
    return count;
  }
}
