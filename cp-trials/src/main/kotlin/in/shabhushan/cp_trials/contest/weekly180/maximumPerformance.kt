package `in`.shabhushan.cp_trials.contest.weekly180

import java.util.*
import kotlin.math.max

fun maxPerformance(
  n: Int,
  speed: IntArray,
  efficiency: IntArray,
  k: Int
): Int {
  val list = speed.indices.map {
    speed[it] to efficiency[it]
  }.sortedBy { it.second }

  var sumElements = 0L
  var ans = 0L

  val queue = PriorityQueue<Int>()

  ( n - 1 downTo 0).forEach {
    queue.add(list[it].first)

    sumElements += list[it].first

    // as soon as there is one element more than k, remove the least element from queue and subtract from sum
    if (queue.size > k) {
      val minElement = queue.remove()
      sumElements -= minElement
    }

    ans = max(ans, sumElements * list[it].second)
  }

  return (ans % (1E9 + 7)).toInt()
}
