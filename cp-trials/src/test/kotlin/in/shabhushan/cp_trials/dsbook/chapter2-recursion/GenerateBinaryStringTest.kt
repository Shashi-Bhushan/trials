package `in`.shabhushan.cp_trials.dsbook.`chapter2-recursion`

import org.junit.Assert.assertArrayEquals
import kotlin.test.Test

class GenerateBinaryStringTest {
  @Test
  fun testBinaryString() {
    assertArrayEquals(
      arrayOf("00", "10", "01", "11"), binaryStrings(
        2
      ).toTypedArray()
    )

    println(binaryStrings(3))
    println(binaryStrings(4))
  }
}
