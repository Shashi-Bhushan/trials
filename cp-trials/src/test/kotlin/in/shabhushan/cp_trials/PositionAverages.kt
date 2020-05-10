package `in`.shabhushan.cp_trials

import org.junit.Test
import kotlin.test.assertEquals

class PositionAveragesTest {
    private fun assertFuzzy(s: String, exp: Double) {
        val merr = 1e-9

        val actual = PositionAverages.posAverage(s)
        val inrange = Math.abs(actual - exp) <= merr

        val actual2 = PositionAverages.posAverage2(s)
        val inrange2 = Math.abs(actual2 - exp) <= merr

        if (!inrange) {
            println("Expected mean must be near $exp, got $actual")
        }
        assertEquals(true, inrange)

        if (!inrange2) {
            println("Expected mean must be near $exp, got $actual2")
        }
        assertEquals(true, inrange2)
    }
    @Test
    fun test() {
        assertFuzzy("466960, 069060, 494940, 060069, 060090, 640009, 496464, 606900, 004000, 944096", 26.6666666667)
        assertFuzzy("444996, 699990, 666690, 096904, 600644, 640646, 606469, 409694, 666094, 606490", 29.2592592593)
        assertFuzzy("449404, 099090, 600999, 694460, 996066, 906406, 644994, 699094, 064990, 696046", 24.4444444444)

    }
}
