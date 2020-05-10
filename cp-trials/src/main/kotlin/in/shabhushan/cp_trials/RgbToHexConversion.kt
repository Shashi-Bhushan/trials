package `in`.shabhushan.cp_trials

object RgbToHexConversion {
    private val rgb = arrayOf('0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F')

    fun rgb(r: Int, g: Int, b: Int): String = StringBuffer()
        .append(rgb[getVal(r) {(r) / 16}])
        .append(rgb[getVal(r) {(r ) % 16}])
        .append(rgb[getVal(g) {(g) / 16}])
        .append(rgb[getVal(g) {(g) % 16}])
        .append(rgb[getVal(b) {(b) / 16}])
        .append(rgb[getVal(b) {(b) % 16}])
        .toString().replace("-", "0")

    private fun getVal(
        r: Int,
        f: (Int) -> Int
    ): Int = if (r < 0) 0 else if (r > 255) 15 else f(r)

    fun rgb2(r: Int, g: Int, b: Int): String = String.format("%02X%02X%02X", round(r), round(g), round(b))

    fun round(x: Int): Int = when {
        x < 0 -> 0
        x > 255 -> 255
        else -> x
    }

    fun rgb3(r: Int, g: Int, b: Int) = String.format("%02X%02X%02X", r.coerceIn(0..255), g.coerceIn(0..255), b.coerceIn(0..255))
}
