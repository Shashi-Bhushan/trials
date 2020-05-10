package `in`.shabhushan.cp_trials.math.primes

import kotlin.math.sqrt

object PrimeDecomposition {
    fun factors(l: Int): String = factorize(l).convertToString()

    fun factorize(num: Int): List<Int> {
        if (num == 2 || num == 3) {
            return mutableListOf(num)
        } else {
            var tempNum = num
            var list = mutableListOf<Int>()

            var sqrt = sqrt(tempNum.toDouble()).toInt()

            (2..sqrt).forEach { n ->
                while (tempNum % n == 0) {
                    list.add(n)

                    tempNum /= n
                }
            }

            if (tempNum != 0 && tempNum != 1) {
                list.add(tempNum)
            }

            return list
        }
    }

    fun List<Int>.convertToString(): String = this.groupBy { it }.map {
        "(${it.key}${if (it.value.size > 1) "**${it.value.size}" else ""})"
    }.joinToString("")
}
