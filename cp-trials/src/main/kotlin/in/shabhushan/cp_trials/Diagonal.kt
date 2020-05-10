package `in`.shabhushan.cp_trials

import java.math.BigInteger

object Diagonal {
    val map = mutableMapOf<Int, BigInteger>()

    fun diagonal(level: Int, diagonal: Int): BigInteger = Pair(level + 1, diagonal + 1).let {
        it.first.factorial() / (it.second.factorial() * (it.first - it.second).factorial())
    }

    fun diagonal2(level: Int, diagonal: Int): BigInteger = Pair(level + 1, diagonal + 1).let {
        getCombination(it.first, it.second)
    }

    fun getCombination(n: Int, r: Int): BigInteger {
        val diff: Long = (n - r).toLong()
        var multSum = BigInteger.ONE

        (diff+1..n).forEach {
            multSum *= BigInteger.valueOf(it)
        }

        return multSum / r.factorial()
    }

    /**
     * Find the factorial of a number
     *
     * @param n : number to find the factorial
     * @return : factorial value of 'n'
     */
    private fun Int.factorial(): BigInteger {
        if (!map.containsKey(this)) {
            var fact: BigInteger = BigInteger.ONE

            (1L..this).forEach {
                fact *= BigInteger.valueOf(it)
            }

            map[this] = fact
        }

        return map[this]!!
    }
}
