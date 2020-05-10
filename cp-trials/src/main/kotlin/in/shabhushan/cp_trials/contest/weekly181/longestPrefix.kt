package `in`.shabhushan.cp_trials.contest.weekly181

/**
 * Leetcode solution for https://leetcode.com/contest/weekly-contest-181/problems/longest-happy-prefix/
 *
 * Watch video for reference
 * https://www.youtube.com/watch?v=V5-7GzOfADQ
 */
fun longestPrefix(s: String): String {
  var j = 0
  val v = Array(s.length) { 0 }

  var i = 1
  while (i < s.length) {
    if(s[i] == s[j]) {
      j++
      v[i] = j
    } else {
      if (j != 0) {
        j = v[j - 1]
        i -= 1
      }
    }

    i++
  }

  return s.substring(0, v.last())
}
