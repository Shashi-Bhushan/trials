package `in`.shabhushan.cp_trials.math.algebra

import `in`.shabhushan.cp_trials.math.algebra.PiApproximation.iterPi2String
import org.junit.Test
import kotlin.test.assertEquals

class PiApproximationTest {
    private fun testing(epsilon: Double, expect: String) {
        val actual: String = iterPi2String(epsilon)
        assertEquals(expect, actual)
    }
    @Test
    fun basicTests() {
        testing(0.1, "[10, 3.0418396189]")
        testing(0.01, "[100, 3.1315929036]")
        testing(0.001, "[1000, 3.1405926538]")

    }
}
