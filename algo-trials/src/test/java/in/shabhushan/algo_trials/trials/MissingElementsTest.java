package in.shabhushan.algo_trials.trials;

import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static in.shabhushan.algo_trials.trials.MissingElements.missingElements;
import static org.junit.Assert.assertEquals;

public class MissingElementsTest {
  @Test
  public void testMissingElements() {
    // Missing 2, 7 and 10
    var list = missingElements(new int[]{0, 1, 3, 4, 5, 6, 8, 9}, 3);
    Collections.sort(list);

    assertEquals(List.of(2, 7, 10), list);
  }
}
