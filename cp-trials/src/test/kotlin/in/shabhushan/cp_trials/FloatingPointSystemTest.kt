package `in`.shabhushan.cp_trials

import `in`.shabhushan.cp_trials.FloatingPointSystem.mantExp
import `in`.shabhushan.cp_trials.FloatingPointSystem.mantExp2
import kotlin.test.assertEquals
import org.junit.Test
import java.math.BigDecimal

class FloatingPointSystemTest {
    private fun testing(aNumber: BigDecimal, digitsNumber: Int, exp: String) {
        println("aNumber: $aNumber")
        println("digitsNumber: $digitsNumber")
        val actual = mantExp(aNumber, digitsNumber)
        val actual2 = mantExp2(aNumber, digitsNumber)
        println("Actual From 1st Function: $actual")
        println("Actual From 2nd Function: $actual2")
        println("Expect: $exp")
        println("#")
        assertEquals(exp, actual)
        assertEquals(exp, actual2)
    }
    @Test
    fun test() {
        var x = BigDecimal("0.06")
        testing(x, 10, "6000000000P-11")
        x = BigDecimal("72.0")
        testing(x, 12, "720000000000P-10")
        x = BigDecimal("1.0")
        testing(x, 5, "10000P-4")
        x = BigDecimal("1.103000")
        testing(x, 10, "1103000000P-9")

    }

    @Test
    fun fromOtherSide() {
        val x = BigDecimal("123456.0")
        testing(x, 4, "1234P2")
        testing(BigDecimal("10000000000"), 10, "1000000000P1")
    }
}
