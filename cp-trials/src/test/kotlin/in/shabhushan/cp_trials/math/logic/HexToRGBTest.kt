package `in`.shabhushan.cp_trials.math.logic

import `in`.shabhushan.cp_trials.math.logic.HexToRGB.hexStringToRGB
import kotlin.test.assertEquals
import org.junit.Test

class TestExample {
    @Test
    fun testFixed() {
        assertEquals(RGB(r = 255, g = 153, b = 51), hexStringToRGB("#FF9933"))
        assertEquals(RGB(r = 190, g = 173, b = 237), hexStringToRGB("#beaded"))
        assertEquals(RGB(r = 0, g = 0, b = 0), hexStringToRGB("#000000"))
        assertEquals(RGB(r = 17, g = 17, b = 17), hexStringToRGB("#111111"))
        assertEquals(RGB(r = 250, g = 52, b = 86), hexStringToRGB("#Fa3456"))
    }
}
