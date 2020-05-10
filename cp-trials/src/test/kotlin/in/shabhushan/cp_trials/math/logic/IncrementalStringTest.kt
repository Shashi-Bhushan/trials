package `in`.shabhushan.cp_trials.math.logic

import `in`.shabhushan.cp_trials.math.logic.IncrementalString.incrementString
import `in`.shabhushan.cp_trials.math.logic.IncrementalString.incrementString2
import org.junit.Ignore
import kotlin.test.assertEquals
import org.junit.Test

class IncrementalStringTest {

    @Ignore
    @Test
    fun FixedTests() {
        assertEquals("foo1", incrementString("foo"))
        assertEquals("foobar001", incrementString("foobar000"))
        assertEquals("foobar1000", incrementString("foobar999"))
        assertEquals("foobar01000", incrementString("foobar00999"))
        assertEquals("foobar002", incrementString("foobar001"))
        assertEquals("foobar2", incrementString("foobar1"))
        assertEquals("2", incrementString("1"))
        assertEquals("1", incrementString(""))
        assertEquals("010", incrementString("009"))
        assertEquals("1000", incrementString("999"))
    }

    @Test
    fun benchmark1() {
        (0..100000).forEach {
            assertEquals("foobar01000", incrementString("foobar00999"))
        }
    }

    @Test
    fun benchmark2() {
        (0..100000).forEach {
            assertEquals("foobar01000", incrementString2("foobar00999"))
        }
    }
}
