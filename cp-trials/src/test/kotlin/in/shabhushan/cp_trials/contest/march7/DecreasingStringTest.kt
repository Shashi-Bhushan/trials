package `in`.shabhushan.cp_trials.contest.march7

import `in`.shabhushan.cp_trials.contest.march7.DecreasingString.sortString
import kotlin.test.Test
import kotlin.test.assertEquals

class DecreasingStringTest {
  @Test
  fun testDecreasingString() {
    assertEquals("abccbaabccba", sortString("aaaabbbbcccc"))
    assertEquals("art", sortString("rat"))
    assertEquals("cdelotee", sortString("leetcode"))
    assertEquals("ops", sortString("spo"))
    assertEquals("gggggg", sortString("gggggg"))
  }
}
