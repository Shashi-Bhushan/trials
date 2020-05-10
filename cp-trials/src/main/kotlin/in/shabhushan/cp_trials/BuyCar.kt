package `in`.shabhushan.cp_trials

import kotlin.math.roundToInt

object BuyCar {
    fun nbMonths(
        startPriceOld: Int,
        startPriceNew: Int,
        savingperMonth: Int,
        percentLossByMonth: Double
    ): Pair<Int, Int> {
        var oldCarPrice = startPriceOld.toDouble()
        var newCarPrice = startPriceNew.toDouble()
        var lossPercentage = percentLossByMonth
        var totalSavings = 0
        var month = 0

        while (oldCarPrice + totalSavings < newCarPrice) {
            month += 1
            if (month != 0 && month % 2 == 0) {
                lossPercentage += 0.5
            }

            oldCarPrice *= lossPercentage.effectivePercentage()
            newCarPrice *= lossPercentage.effectivePercentage()

            totalSavings += savingperMonth
        }

        return Pair(month, (oldCarPrice + totalSavings - newCarPrice).roundToInt())
    }

    private fun Double.effectivePercentage() = 1 - (this / 100)
}
