package in.shabhushan.algo_trials.algo1.part1.dynamic_connectivity;

import java.util.Arrays;

public class QuickUnion implements UnionFind {

  private int[] array;

  public QuickUnion(int numComponents) {
    array = new int[numComponents];

    for (int i = 0; i < numComponents; i++) {
      array[i] = i;
    }
  }

  @Override
  public void union(int p, int q) {
    array[p] = q;
  }

  @Override
  public boolean connected(int p, int q) {
    p = find(p);
    q = find(q);

    return p == q;
  }

  @Override
  public int find(int p) {
    while (array[p] != p)
      p = array[p];

    return p;
  }

  @Override
  public int count() {
    return (int)Arrays.stream(array).map(this::find).distinct().count();
  }
}
