package `in`.shabhushan.cp_trials

import org.junit.Test
import kotlin.test.assertEquals

class CubeSumTest {

    private fun testing(n: Long, expected: Long) {
        var actual = CubeSum.findNb(n)
        assertEquals(expected, actual)
    }
    @Test
    fun fixedTests() {
        testing(56396345062501, -1)
        testing(36, 3)
        testing(3025, 10)
        testing(6132680780625, 2225)
        testing(28080884739601, -1)
    }
}
