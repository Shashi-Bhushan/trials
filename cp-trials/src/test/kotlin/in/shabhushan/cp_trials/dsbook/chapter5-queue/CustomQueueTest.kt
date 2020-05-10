package `in`.shabhushan.cp_trials.dsbook.`chapter5-queue`

import org.junit.Test
import kotlin.test.assertEquals

class CustomQueueTest {
  @Test
  fun testCustomQueue() {
    val queue = CustomQueue<Int>(3)
    println(queue)
    queue.add(1)
    println(queue)
    queue.add(2)
    println(queue)
    queue.add(3)
    println(queue)
    queue.add(4)
    queue.add(5)
    println(queue)
    queue.add(1)
    queue.add(1)
    queue.add(2)
    queue.remove()
    queue.add(3)
    queue.add(3)
    queue.add(3)
    queue.add(3)
    queue.add(3)
    queue.add(3)
    println(queue)
  }
}


class RoboScriptTest {

  @Test
  fun descriptionExamples() {
    assertCorrect("F3RF5LF7", "<span style=\"color: pink\">F</span><span style=\"color: orange\">3</span><span style=\"color: green\">R</span><span style=\"color: pink\">F</span><span style=\"color: orange\">5</span><span style=\"color: red\">L</span><span style=\"color: pink\">F</span><span style=\"color: orange\">7</span>")
    assertCorrect("FFFR345F2LL", "<span style=\"color: pink\">FFF</span><span style=\"color: green\">R</span><span style=\"color: orange\">345</span><span style=\"color: pink\">F</span><span style=\"color: orange\">2</span><span style=\"color: red\">LL</span>")
  }

  private fun assertCorrect(code: String, expected: String) {
    println("Code without syntax highlighting:   $code")
    val actual = highlight(code)
    println("Your code with syntax highlighting: $actual")
    println("Expected syntax highlighting:       $expected")
    assertEquals(expected, actual, "Code: $code")
  }
}
