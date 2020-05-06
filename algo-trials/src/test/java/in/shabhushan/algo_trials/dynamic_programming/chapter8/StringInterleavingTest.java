package in.shabhushan.algo_trials.dynamic_programming.chapter8;

import org.junit.Test;

import static in.shabhushan.algo_trials.dynamic_programming.chapter8.StringInterleaving.isInterleavingString;
import static in.shabhushan.algo_trials.dynamic_programming.chapter8.StringInterleaving.isInterleavingStringDP;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class StringInterleavingTest {
  @Test
  public void testInterleavingString() {
    assertTrue(isInterleavingString("xyz", "abcd", "xabyczd"));
    assertTrue(isInterleavingString("bcc", "bbca", "bbcbcac"));
    assertFalse(isInterleavingString("bcc", "bbca", "bbcbca"));
    assertFalse(isInterleavingString("bcc", "bbca", "bbcbcaca"));
    assertFalse(isInterleavingString("bcc", "bbca", "bbcbcaax"));
    assertFalse(isInterleavingString("bcc", "bbca", "bbcbcaxa"));
  }

  @Test
  public void testInterleavingStringDP() {
    assertTrue(isInterleavingStringDP("bcc", "bbca", "bbcbcac"));
    assertTrue(isInterleavingStringDP("xyz", "abcd", "xabyczd"));
    assertTrue(isInterleavingStringDP("bcc", "bbca", "bbcbcac"));
    assertFalse(isInterleavingStringDP("bcc", "bbca", "bbcbca"));
    assertFalse(isInterleavingStringDP("bcc", "bbca", "bbcbcaca"));
    assertFalse(isInterleavingStringDP("bcc", "bbca", "bbcbcaax"));
    assertFalse(isInterleavingStringDP("bcc", "bbca", "bbcbcaxa"));
  }
}
