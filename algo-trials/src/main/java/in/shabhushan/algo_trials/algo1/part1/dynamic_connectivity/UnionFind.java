package in.shabhushan.algo_trials.algo1.part1.dynamic_connectivity;

/**
 * Goal: Design an efficient data structure for union find
 * 1. Number of objects N could be huge
 * 2. Number of operations M could be huge
 * 3. Find queries and union commands may be intermixed
 */
public interface UnionFind {

  /**
   * Add a connection between p and q
   *
   * @param p
   *  Component from first set
   * @param q
   *  Component from second set
   */
  void union(int p, int q);

  /**
   * Check if two objects are in same component
   *
   * @param p
   *  Component from first set
   * @param q
   *  Component from second set
   * @return
   *  true if connected, false otherwise
   */
  boolean connected(int p, int q);

  /**
   * component identifier for p (0..N-1)
   */
  int find(int p);

  /**
   * Returns the number of components
   */
  int count();
}
