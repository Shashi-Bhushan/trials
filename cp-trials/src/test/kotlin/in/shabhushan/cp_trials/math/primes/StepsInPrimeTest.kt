package `in`.shabhushan.cp_trials.math.primes

import `in`.shabhushan.cp_trials.math.primes.StepsInPrime.isPrime
import `in`.shabhushan.cp_trials.math.primes.StepsInPrime.step2
import org.junit.Test
import java.util.*
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue


class StepsInPrimeTest {
    @Test
    fun testPrime() {
        assertTrue(isPrime(2))
        assertTrue(isPrime(5))
        assertTrue(isPrime(7))
        assertFalse(isPrime(9))
        assertTrue(isPrime(13))
        assertFalse(isPrime(12))
        assertFalse(isPrime(30148))
    }

    //--------------
    @Test
    fun test() {
        println("Fixed Tests")
        assertEquals("[101, 103]", Arrays.toString(step2(2, 100, 110)))
        assertEquals("[103, 107]", Arrays.toString(step2(4, 100, 110)))
        assertEquals("[101, 107]", Arrays.toString(step2(6, 100, 110)))

        assertEquals("[]", Arrays.toString(step2(11, 30000, 100000)))
    }
}
