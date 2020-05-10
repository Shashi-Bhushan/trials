package `in`.shabhushan.cp_trials.math.primes

import kotlin.math.sqrt

object GapInPrimes {
    fun isPrime(num: Long): Boolean = if (num != 2L && num % 2 == 0L) {
        false
    } else {
        var prime = true
        val sqrt = sqrt(num.toDouble()).toLong() + 1

        (3L until sqrt step 2).forEach {
            if (num % it == 0L) prime = false
        }

        prime
    }

    fun isPrime2(x: Long) = (2L..sqrt(x.toDouble()).toLong()).none { x % it == 0L }

    //if these g-gap prime numbers don't exist return []
    fun gap(
        g: Int,
        m: Long,
        n: Long
    ): LongArray = (m..n).find {
        isPrime(it) && isPrime(it + g)
    }?.let {
        longArrayOf(it, it + g)
    } ?: longArrayOf()

}
