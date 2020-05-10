package `in`.shabhushan.cp_trials.contest.march7

import java.util.*

object DecreasingString {
  fun sortString(s: String): String {
    val map = TreeMap<String, Int>()

    s.split("").filter { it.isNotBlank() }.forEach {
      map[it] = map.getOrDefault(it, 0) + 1
    }

    val sb = StringBuilder()

    val keys = map.keys.toTypedArray()

    while (map.isNotEmpty()) {
      keys.mapNotNull {
        if (map.containsKey(it) && map[it] != 0) {
          map[it] = map[it]!! - 1
          it
        } else {
          map.remove(it)
          null
        }
      }.joinToString("").let {
        sb.append(it)
      }

      keys.reverse()
    }

    return sb.toString()
  }
}
