package in.shabhushan.cp_trials.dfs;

import in.shabhushan.cp_trials.dfs.CountIslands;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CountIslandsTest {
  @Test
  public void test() {
    char[][] input = new char[][]
        {new char[]{'1','1','1','1','0'},
            new char[]{'1','1','0','1','0'},
            new char[]{'1','1','0','0','0'},
            new char[]{'0','0','0','0','0'}
        };

    assertEquals(1, new CountIslands().numIslands(input));
    char[][] input2 = new char[][]{
        new char[]{'1', '0', '1', '1', '0', '1', '1'}
    };

    assertEquals(3, new CountIslands().numIslands(input2));
  }
}
