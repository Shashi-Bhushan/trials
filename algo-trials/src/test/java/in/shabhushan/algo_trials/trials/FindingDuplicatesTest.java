package in.shabhushan.algo_trials.trials;

import org.junit.Test;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static in.shabhushan.algo_trials.trials.FindingDuplicates.findDuplicates;
import static org.junit.Assert.assertEquals;

public class FindingDuplicatesTest {
  @Test
  public void testFindDuplicates() {
    var list = findDuplicates(new int[]{1, 3, 2, 1, 3, 0, 6});
    Collections.sort(list);

    assertEquals(List.of(1, 3), list);
  }
}