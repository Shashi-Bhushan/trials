package `in`.shabhushan.cp_trials.math.logic

data class RGB(
    val r: Int,
    val g: Int,
    val b: Int
)

object HexToRGB {
    val map = mapOf(
        '0' to 0,
        '1' to 1,
        '2' to 2,
        '3' to 3,
        '4' to 4,
        '5' to 5,
        '6' to 6,
        '7' to 7,
        '8' to 8,
        '9' to 9,
        'A' to 10,
        'B' to 11,
        'C' to 12,
        'D' to 13,
        'E' to 14,
        'F' to 15
    )

    fun hexStringToRGB(hexString: String): RGB =
        RGB(
            convertToDecimal(
                hexString.subSequence(
                    1 until 3
                )
            ),
            convertToDecimal(
                hexString.subSequence(
                    3 until 5
                )
            ),
            convertToDecimal(
                hexString.subSequence(
                    5 until 7
                )
            )
        )

    private fun convertToDecimal(str: CharSequence): Int =
        16 * (map[str[0].toUpperCase()]!!) + map[str[1].toUpperCase()]!!

    fun hexStringToRGB2(hexString: String) = hexString
        .drop(1)
        .chunked(2) {
            "$it".toInt(16)
        }.let {
            RGB(it[0], it[1], it[2])
        }

    fun hexStringToRGB3(hexString: String): RGB = (::RGB).call(
        *hexString.drop(1).chunked(2){ it.toString().toInt(16) }.toTypedArray()
    )

}
