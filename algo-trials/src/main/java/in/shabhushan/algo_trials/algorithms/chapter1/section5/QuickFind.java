package in.shabhushan.algo_trials.algorithms.chapter1.section5;

/**
 * This implementation denotes the eager approach of doing union find.
 * The backing data structure would be integer array of given size
 * The interpretation is 2 objects p and q are connected iff they have same entry in the array
 *
 * Analysis:
 * Initialize: O(n)
 * Union: O(n)
 * Find: O(1)
 *
 * union is biggest problem here since for a union of n objects, it would take O(n^2) time
 */
public class QuickFind implements UnionFind {

  private int[] parent;
  private int count;
  private int totalCount;
  private int findCount;
  private int checkParentCount;
  private int updateParentCount;

  public QuickFind(int numComponents) {
    parent = new int[numComponents];
    count = numComponents;

    for (int i = 0; i < numComponents; i++) {
      parent[i] = i;
    }
  }

  /**
   * Change the ID's of the connected component of q to p's connected component.
   * @param p
   *  Object from first set
   * @param q
   * Object from first set
   */
  @Override
  public void union(int p, int q) {
    int a = find(p);
    int b = find(q);

    for (int i = 0; i < parent.length; i++) {
      checkParentCount++;
      if (parent[i] == b) {
        updateParentCount++;
        totalCount++;
        parent[i] = a;
      }

      totalCount++;
    }

    count--;
  }

  /**
   * Check if p and q have same entries in the array
   * @param p
   *  Component from first set
   * @param q
   *  Component from second set
   * @return
   *  true if connected, false otherwise
   */
  @Override
  public boolean connected(int p, int q) {
    totalCount += 2;
    checkParentCount += 2;
    return parent[p] == parent[q];
  }

  @Override
  public int find(int p) {
    if (p < 0 || parent.length <= p)
      throw new IllegalArgumentException("err-value-not-within-bounds");

    findCount++;
    totalCount++;
    return parent[p];
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
