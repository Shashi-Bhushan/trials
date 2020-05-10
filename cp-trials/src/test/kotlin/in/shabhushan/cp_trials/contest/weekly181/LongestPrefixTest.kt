package `in`.shabhushan.cp_trials.contest.weekly181

import kotlin.test.Test
import kotlin.test.assertEquals

class LongestPrefixTest {
  @Test
  fun test() {
    assertEquals("leet", longestPrefix("leetcodeleet"))
    assertEquals("abab", longestPrefix("ababab"))
    assertEquals("aac", longestPrefix("aacccbaaacccbaac"))
  }
}
