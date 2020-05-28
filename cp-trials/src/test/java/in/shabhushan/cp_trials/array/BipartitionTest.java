package in.shabhushan.cp_trials.array;

import org.junit.Test;

import static in.shabhushan.cp_trials.array.Bipartition.possibleBipartition;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BipartitionTest {
  @Test
  public void testBipartition() {
    assertTrue(possibleBipartition(4, new int[][]{
        {1, 2}, {1, 3}, {2, 4}
    }));

    assertFalse(possibleBipartition(3, new int[][]{
        {1, 2}, {1, 3}, {2, 3}
    }));
  }
}
