package `in`.shabhushan.cp_trials

import java.lang.NumberFormatException

object UnwantedDollars {
    fun moneyValue(money:String):Double = money.replace(Regex("( |\\$)"), "")
        .let {
            try {
                java.lang.Double.parseDouble(it)
            } catch (e: NumberFormatException) {
                0.0
            }
        }
}
