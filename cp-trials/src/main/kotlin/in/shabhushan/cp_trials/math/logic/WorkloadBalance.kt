package `in`.shabhushan.cp_trials.math.logic

import kotlin.math.abs

object WorkloadBalance {
    fun splitList(list: List<Int>): Pair<List<Int>, List<Int>> {
        val sum = list.sum() / 2

        val combos = mutableListOf(Pair(listOf<Int>(), 0))

        // TODO: Understand this logic
        list.forEachIndexed { index, value ->
            combos += combos.filter {
                it.second + value <= sum
            }.map {
                Pair(it.first + index, it.second + value)
            }
        }

        val arr = combos.last().first

        val ma = mutableListOf<Int>()
        val mb = mutableListOf<Int>()

        list.forEachIndexed { index, value ->
            if (arr.contains(index))
                ma.add(value)
            else mb.add(value)
        }

        return Pair(ma, mb)
    }
}
