package `in`.shabhushan.cp_trials

import java.lang.Math.pow
import java.math.BigDecimal
import java.math.RoundingMode
import kotlin.math.pow

object FloatingPointSystem {
    fun mantExp(aNumber: BigDecimal, digitsNumber: Int): String = if (aNumber.toString().split(".")[0].length < digitsNumber) {
        var number = aNumber
        var radix = 0


        while (10.toDouble().pow(digitsNumber.toDouble() - 1) > number.toDouble()) {
            number = number.multiply(BigDecimal.TEN)
            radix += 1
        }

        String.format("%sP-%d", number.toString().split(".")[0],radix)
    } else {
        var number = aNumber
        var radix = 0

        while (10.toDouble().pow(digitsNumber.toDouble()) <= number.toDouble()) {
            number = number.divide(BigDecimal.TEN)
            radix += 1
        }

        String.format("%sP%d", number.toString().split(".")[0], radix)
    }

    /**
     * Better Approach
     */
    fun mantExp2(number: BigDecimal, nDigits: Int): String
            = number.setScale(nDigits + number.scale() - number.precision(), RoundingMode.DOWN).let { "${it.unscaledValue()}P${-it.scale()}"}
}
