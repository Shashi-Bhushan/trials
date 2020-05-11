package in.shabhushan.cp_trials.string.logic;

import org.junit.Test;

import java.util.List;

import static in.shabhushan.cp_trials.string.logic.PalindromePairs.palindromePairs;
import static in.shabhushan.cp_trials.string.logic.PalindromePairs.palindromePairs2;
import static org.junit.Assert.assertEquals;

public class PalindromePairsTest {
  @Test
  public void testPalindromePairs() {
    for (int i = 0; i < 10000; i++) {
      assertEquals(List.of(List.of(0, 1), List.of(1, 0), List.of(3, 2), List.of(2, 4)),
          palindromePairs(new String[]{"abcd", "dcba", "lls", "s", "sssll"})
      );
      assertEquals(List.of(List.of(1, 0), List.of(0, 1)),
          palindromePairs(new String[]{"a", ""})
      );
      assertEquals(List.of(List.of(1, 3), List.of(3, 0), List.of(2, 4), List.of(4, 0), List.of(0, 5), List.of(5, 0)),
          palindromePairs(new String[]{"a", "b", "c", "ab", "ac", "aa"})
      );
    }
  }

  @Test
  public void testPalindromePairs2() {
    for (int i = 0; i < 10000; i++) {
      assertEquals(List.of(List.of(0, 1), List.of(1, 0), List.of(3, 2), List.of(2, 4)),
          palindromePairs2(new String[]{"abcd", "dcba", "lls", "s", "sssll"})
      );
      assertEquals(List.of(List.of(0, 1), List.of(1, 0)),
          palindromePairs2(new String[]{"a", ""})
      );
      assertEquals(List.of(List.of(3, 0), List.of(4, 0), List.of(0, 5), List.of(5, 0), List.of(1, 3), List.of(2, 4)),
          palindromePairs2(new String[]{"a", "b", "c", "ab", "ac", "aa"})
      );
    }
  }
}
