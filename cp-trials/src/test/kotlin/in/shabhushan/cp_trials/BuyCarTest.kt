package `in`.shabhushan.cp_trials

import org.junit.Test
import kotlin.test.assertEquals

class  BuyCarTest {

    private fun testing(startPriceOld: Int, startPriceNew: Int, savingperMonth: Int, percentLossByMonth: Double, expect: Pair<Int, Int>) {
        val actual = BuyCar.nbMonths(startPriceOld, startPriceNew, savingperMonth, percentLossByMonth)
        assertEquals(expect, actual)
    }
    @Test
    fun fixedTests() {
        testing(2000, 8000, 1000, 1.5, Pair(6, 766))
        testing(12000, 8000, 1000, 1.5 , Pair(0, 4000))
        testing(8000, 12000, 500, 1.0, Pair(8, 597))
        testing(18000, 32000, 1500, 1.25, Pair(8, 332))
        testing(7500, 32000, 300, 1.55, Pair(25, 122))

    }

}
