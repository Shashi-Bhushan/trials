package `in`.shabhushan.cp_trials.math.primes

import org.junit.Ignore
import org.junit.Test
import kotlin.test.assertEquals

class PrimeDecompositionTest {
    private fun testing(n: Int, exp: String) {
        val ans = PrimeDecomposition.factors(n)
        assertEquals(exp, ans)
    }

    @Test
    fun fixedTests() {
        testing(1024, "(2**10)")
        testing(7775460, "(2**2)(3**3)(5)(7)(11**2)(17)")

    }

    @Test
    fun testFactorize() {
        val factors = PrimeDecomposition.factorize(7775460)

        println(factors)
    }
}
