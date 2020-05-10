package `in`.shabhushan.cp_trials.dsbook.methods.`decrease-and-conquer`

import kotlin.test.Test
import kotlin.test.assertTrue
import kotlin.test.assertFalse
import kotlin.test.assertEquals

class CelebrityProblemTest {
	@Test
  fun testCelebrityProblem() {
    // We need to find the row with all 0's
    val personsIndex = arrayOf(
      arrayOf(0, 0, 1, 0),
      arrayOf(0, 0, 1, 1),
      arrayOf(0, 0, 0, 0),
      arrayOf(1, 0, 1, 0)
    )

    // We need to find the row with all 0's
    val anotherPersonsIndex = arrayOf(
      arrayOf(0, 0, 1, 0),
      arrayOf(0, 0, 1, 1),
      arrayOf(0, 1, 0, 0),
      arrayOf(1, 0, 1, 0)
    )

    assertEquals(-1 ,isCelebrity(anotherPersonsIndex))
  }
}
