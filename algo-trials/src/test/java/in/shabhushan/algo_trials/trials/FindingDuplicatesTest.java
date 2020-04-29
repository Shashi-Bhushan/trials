package in.shabhushan.algo_trials.trials;

import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static in.shabhushan.algo_trials.trials.FindingDuplicates.findDuplicateCount;
import static in.shabhushan.algo_trials.trials.FindingDuplicates.findDuplicates;
import static org.junit.Assert.assertEquals;

public class FindingDuplicatesTest {
  @Test
  public void testFindDuplicates() {
    var list = findDuplicates(new int[]{1, 3, 2, 1, 3, 0, 6});
    Collections.sort(list);

    assertEquals(List.of(1, 3), list);
  }

  @Test
  public void testDuplicatedCount() {
    assertEquals(3,
        findDuplicateCount(new int[]{1, 1, 1})
    );
    assertEquals(49,
        findDuplicateCount(new int[]{1, 2, 4, 1, 2, 1, 2, 4, 5, 1, 2, 4, 5, 1, 2 ,5, 6, 7, 7, 8, 2, 1, 2, 4, 5})
    );
  }
}
