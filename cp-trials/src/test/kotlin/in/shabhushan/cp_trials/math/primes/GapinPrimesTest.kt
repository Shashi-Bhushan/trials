package `in`.shabhushan.cp_trials.math.primes

import `in`.shabhushan.cp_trials.math.primes.GapInPrimes.gap
import `in`.shabhushan.cp_trials.math.primes.GapInPrimes.isPrime
import `in`.shabhushan.cp_trials.math.primes.StepsInPrime.isPrime2
import org.junit.Assert.*
import java.util.Arrays
import org.junit.Test

class GapInPrimesTest {
    //--------------
    @Test
    fun test() {
        println("Fixed Tests")
        assertEquals("[101, 103]", Arrays.toString(gap(2, 100, 110)))
        assertEquals("[103, 107]", Arrays.toString(gap(4, 100, 110)))
        assertEquals("[101, 107]", Arrays.toString(gap(6, 100, 110)))
    }

    @Test
    fun primeTest() {
        (0..100000).forEach {
            assertTrue(isPrime(101))
            assertTrue(isPrime(131))
        }
    }

    @Test
    fun primeTest2() {
        (0..100000).forEach {
            assertTrue(isPrime2(101))
            assertTrue(isPrime2(131))
        }
    }
}
