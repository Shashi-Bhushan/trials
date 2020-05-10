package `in`.shabhushan.cp_trials

import `in`.shabhushan.cp_trials.BankersPlan.fortune
import org.junit.Assert.*
import org.junit.Test

class BankersPlanTest {
    @Test
    fun test1() {
        println("Fixed Tests: fortune")
        testing(fortune(100000, 1.0, 2000, 15, 1.0), true)
        testing(fortune(100000, 1.0, 9185, 12, 1.0), false)
        testing(fortune(2950068, 8.0, 198014, 18, 7.0), true)

    }
    companion object {
        private fun testing(actual:Boolean, expected:Boolean) {
            assertEquals(expected, actual)
        }
    }
}
