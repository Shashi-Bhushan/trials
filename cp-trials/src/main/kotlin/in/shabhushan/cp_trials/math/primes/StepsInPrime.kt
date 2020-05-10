package `in`.shabhushan.cp_trials.math.primes

import kotlin.math.sqrt

object StepsInPrime {
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


    // if these g-steps prime numbers don't exist return []
    fun step(
        g: Int,
        m: Long,
        n: Long
    ): LongArray {
        if (g % 2 != 0) {
            return longArrayOf()
        } else {
            ((if (m % 2 == 0L) m + 1 else m)..n step 2).forEach {
                if (isPrime(it) && isPrime(
                        it + g.toLong()
                    )
                ) {
                    return longArrayOf(it, it + g.toLong())
                }
            }

            return longArrayOf()
        }
    }

    fun step2(
        g: Int,
        m: Long,
        n: Long
    ): LongArray = ((if (m % 2 == 0L) m + 1 else m)..n step 2)
        .find {
            isPrime(it) && isPrime(
                it + g.toLong()
            )
        }
        ?.let { longArrayOf(it, it + g.toLong()) }
        ?: longArrayOf()
}
