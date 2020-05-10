package in.shabhushan.cp_trials.dsbook.methods.dynamic_programming;

import org.junit.Test;

import static in.shabhushan.cp_trials.dsbook.methods.dynamic_programming.LongestCommonSubsequence.lcs;
import static org.junit.Assert.assertEquals;

public class LongestCommonSubsequenceTest {
  @Test
  public void exampleTests() {
//    assertEquals("", lcs("a", "b"));
//    assertEquals("abc", lcs("abcdef", "abc"));
//    assertEquals("nottest", lcs("notatest", "anothertest"));
    assertEquals("acdefghijklmnoq", lcs("apcdefghijklmnobq", "abcdefghijklmnopq"));
  }
}
