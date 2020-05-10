package `in`.shabhushan.cp_trials

import `in`.shabhushan.cp_trials.CamelCase.toCamelCase
import org.junit.Test
import kotlin.test.assertEquals

class CamelCaseTest {
    @Test
    fun testFixed() {
        assertEquals("", toCamelCase(""))
        assertEquals("theStealthWarrior", toCamelCase("the_stealth_warrior"))
        assertEquals("TheStealthWarrior", toCamelCase("The-Stealth-Warrior"))
        assertEquals("ABC", toCamelCase("A-B-C"))
    }
}
