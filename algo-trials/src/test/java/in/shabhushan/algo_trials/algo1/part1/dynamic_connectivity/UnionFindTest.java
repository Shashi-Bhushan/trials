package in.shabhushan.algo_trials.algo1.part1.dynamic_connectivity;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UnionFindTest {
  UnionFind unionFind;

  @Before
  public void setup() {
    unionFind = new UnionFindImpl(10);

    unionFind.union(1, 2);
    unionFind.union(3, 4);
    unionFind.union(5, 6);
    unionFind.union(7, 8);
    unionFind.union(7, 9);
    unionFind.union(2, 8);
    unionFind.union(0, 5);
    unionFind.union(1, 9);
  }

  @Test
  public void testFind() {
    assertEquals(1, unionFind.find(2));
  }
}
