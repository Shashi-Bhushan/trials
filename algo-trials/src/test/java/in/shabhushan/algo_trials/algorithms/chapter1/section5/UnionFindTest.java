package in.shabhushan.algo_trials.algorithms.chapter1.section5;

import org.junit.Test;

import static org.junit.Assert.*;

public class UnionFindTest {
  public UnionFind getQuickFind() {
    UnionFind unionFind = new QuickFind(10);

    unionFind.union(1, 2);
    unionFind.union(3, 4);
    unionFind.union(5, 6);
    unionFind.union(7, 8);
    unionFind.union(7, 9);
    unionFind.union(2, 8);
    unionFind.union(0, 5);
    unionFind.union(1, 9);

    return unionFind;
  }

  public UnionFind getQuickUnion() {
    UnionFind unionFind = new QuickUnion(10);

    unionFind.union(6, 5);
    unionFind.union(2, 1);
    unionFind.union(5, 0);
    unionFind.union(0, 1);
    unionFind.union(7, 1);
    unionFind.union(1, 8);
    unionFind.union(3, 8);
    unionFind.union(4, 3);
    unionFind.union(9, 8);

    return unionFind;
  }

  public UnionFind getWeightedQuickUnion() {
    UnionFind unionFind = new WeightedQuickUnion(10);

    // child, parent
    unionFind.union(6, 5);
    unionFind.union(2, 1);
    unionFind.union(5, 0);
    unionFind.union(0, 1);
    unionFind.union(7, 1);
    unionFind.union(1, 8);
    unionFind.union(3, 8);
    unionFind.union(4, 3);
    unionFind.union(9, 8);

    return unionFind;
  }

  @Test
  public void testQuickFind() {
    UnionFind unionFind = getQuickFind();
    assertEquals(1, unionFind.find(2));

    assertFalse(unionFind.connected(2, 3));
    unionFind.union(2, 3);
    assertTrue(unionFind.connected(2, 3));
  }

  /**
   *          8
   *        / | \
   *       1  9  3
   *     / | \   |
   *    0  2  7  4
   *    |
   *    5
   *    |
   *    6
   */
  @Test
  public void testQuickUnion() {
    UnionFind unionFind = getQuickUnion();
    assertEquals(8, unionFind.find(2));
  }

  /**
   *        6
   *   4 8 1 5 0 7 3 9
   *       2
   */
  @Test
  public void testWeightedQuickUnion() {
    UnionFind unionFind = getWeightedQuickUnion();
    assertEquals(6, unionFind.find(2));
  }
}
