package `in`.shabhushan.cp_trials

import kotlin.math.roundToInt
import kotlin.math.roundToLong

object CubeSum {

    val map = mutableMapOf<Long, Long>()

    fun findNb(m: Long): Long {
        var sum: Long = 0
        var index: Long = 0

        while (sum < m) {
            index += 1

            val cube = if (map.containsKey(index)) {
                map[index]!!
            } else {
                val cube = (index * index * index)

                map[index] = cube
                cube
            }

            sum += cube
        }

        return if (sum == m) index else -1
    }

    fun findCube(n: Long) = ((n * (n + 1)) / 2) * ((n * (n + 1)) / 2)

}
