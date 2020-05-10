package `in`.shabhushan.cp_trials.math.algebra

import java.math.BigDecimal
import java.text.DecimalFormat
import kotlin.math.abs
import kotlin.math.ceil

object PiApproximation {
    fun iterPi2String(epsilon: Double): String {
        var index = 0
        var num: Double = 1.0
        var sum: Double = 0.0

        while (abs((sum * 4) - Math.PI) >= epsilon) {
            if (index % 2 == 0)
                sum += 1/num
            else
                sum -= 1/num

            index += 1
            num += 2
        }

        return "[$index, ${DecimalFormat("#.0000000000").format(sum * 4)}]"
    }
}
