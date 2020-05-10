package `in`.shabhushan.cp_trials.string

import `in`.shabhushan.cp_trials.string.EncryptThis.encryptThis
import `in`.shabhushan.cp_trials.string.EncryptThis.encryptThis2
import org.junit.Test
import org.junit.Assert.*

class EncryptThisTest {
    @Test
    fun testSample() {
        (0..100000).forEach {
            // Example Test Cases
            assertEquals("65 119esi 111dl 111lw 108dvei 105n 97n 111ka", encryptThis("A wise old owl lived in an oak"))
            assertEquals(
                "84eh 109ero 104e 115wa 116eh 108sse 104e 115eokp",
                encryptThis("The more he saw the less he spoke")
            )
            assertEquals(
                "84eh 108sse 104e 115eokp 116eh 109ero 104e 104dare",
                encryptThis("The less he spoke the more he heard")
            )
            assertEquals(
                "87yh 99na 119e 110to 97ll 98e 108eki 116tah 119esi 111dl 98dri",
                encryptThis("Why can we not all be like that wise old bird")
            )
            assertEquals(
                "84kanh 121uo 80roti 102ro 97ll 121ruo 104ple",
                encryptThis("Thank you Piotr for all your help")
            )
        }
    }

    @Test
    fun testSample2() {
        (0..100000).forEach {
            // Example Test Cases
            assertEquals("65 119esi 111dl 111lw 108dvei 105n 97n 111ka", encryptThis2("A wise old owl lived in an oak"))
            assertEquals(
                "84eh 109ero 104e 115wa 116eh 108sse 104e 115eokp",
                encryptThis2("The more he saw the less he spoke")
            )
            assertEquals(
                "84eh 108sse 104e 115eokp 116eh 109ero 104e 104dare",
                encryptThis2("The less he spoke the more he heard")
            )
            assertEquals(
                "87yh 99na 119e 110to 97ll 98e 108eki 116tah 119esi 111dl 98dri",
                encryptThis2("Why can we not all be like that wise old bird")
            )
            assertEquals(
                "84kanh 121uo 80roti 102ro 97ll 121ruo 104ple",
                encryptThis2("Thank you Piotr for all your help")
            )
        }
    }
}
