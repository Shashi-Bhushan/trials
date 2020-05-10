package `in`.shabhushan.cp_trials

import `in`.shabhushan.cp_trials.Squares.sqInRect
import org.junit.Assert.*
import org.junit.Test

class SquaresTest {
    private fun dotest(lng:Int, wdth:Int, expect:List<Int>?) {
        println("lng: $lng wdth: $wdth")
        val actual = sqInRect(lng, wdth)
        assertEquals(expect, actual)
    }
    @Test
    fun test1() {
        dotest(5, 3, listOf(3, 2, 1, 1))
        dotest(5, 5, null)
        dotest(20, 14, listOf(14, 6, 6, 2, 2, 2))

    }
}
