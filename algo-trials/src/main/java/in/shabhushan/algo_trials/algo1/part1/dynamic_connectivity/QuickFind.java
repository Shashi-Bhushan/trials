package in.shabhushan.algo_trials.algo1.part1.dynamic_connectivity;

import java.util.Arrays;

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

  private int[] array;

  public QuickFind(int numComponents) {
    array = new int[numComponents];

    for (int i = 0; i < numComponents; i++) {
      array[i] = i;
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
    int a = array[p];
    int b = array[q];

    for (int i = 0; i < array.length; i++) {
      if (array[i] == b)
        array[i] = a;
    }
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
    return array[p] == array[q];
  }

  @Override
  public int find(int p) {
    if (p < 0 || array.length <= p)
      throw new IllegalArgumentException("err-value-not-within-bounds");

    return array[p];
  }

  @Override
  public int count() {
    return (int) Arrays.stream(array).distinct().count();
  }
}
