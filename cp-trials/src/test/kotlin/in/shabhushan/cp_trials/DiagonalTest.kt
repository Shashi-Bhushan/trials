package `in`.shabhushan.cp_trials

import org.junit.Ignore
import java.math.BigInteger
import org.junit.Test
import kotlin.test.assertEquals

class DiagonalTest {

    @Test
    fun testFindVal() {
        assertEquals(BigInteger.valueOf(8), Diagonal.diagonal2(7, 0))
    }

    @Test
    fun basicTests() {
        assertEquals(BigInteger.valueOf(8), Diagonal.diagonal2(7, 0))
        assertEquals(BigInteger.valueOf(28), Diagonal.diagonal2(7, 1))
        assertEquals(BigInteger.valueOf(56), Diagonal.diagonal2(7, 2))
        assertEquals(BigInteger.valueOf(5985), Diagonal.diagonal2(20, 3))
        assertEquals(BigInteger.valueOf(20349), Diagonal.diagonal2(20, 4))
        assertEquals(BigInteger.valueOf(54264), Diagonal.diagonal2(20, 5))

    }
}
