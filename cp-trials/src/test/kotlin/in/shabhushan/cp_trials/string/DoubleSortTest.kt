package `in`.shabhushan.cp_trials.string

import org.junit.Test
import org.junit.Assert.*
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import org.junit.runners.Parameterized.Parameters

@RunWith(Parameterized::class)
class DoubleSortTest(
    val a: Array<Any>,
    val expResult: Array<Any>
) {
    /**
     * Test of dbSort method, of class DoubleSort.
     */
    @Test
    fun basicTests() {
        val result = DoubleSort.dbSort(a)
        assertArrayEquals(expResult, result)
    }

    companion object {
        @JvmStatic
        @Parameters
        @Throws(Throwable::class)
        fun data(): Iterable<Array<Any>> {
            return listOf<Array<Any>>(
                *arrayOf(
                    arrayOf<Any>(
                        arrayOf<Int>(6, 2, 3, 4, 5),
                        arrayOf<Int>(2, 3, 4, 5, 6)
                    ),
                    arrayOf<Any>(
                        arrayOf<Int>(14, 32, 3, 5, 5),
                        arrayOf<Int>(3, 5, 5, 14, 32)
                    ),
                    arrayOf<Any>(
                        arrayOf<Int>(1, 2, 3, 4, 5),
                        arrayOf<Int>(1, 2, 3, 4, 5)
                    ),
                    arrayOf<Any>(
                        arrayOf<Any>("Banana", "Orange", "Apple", "Mango", 0, 2, 2),
                        arrayOf<Any>(0, 2, 2, "Apple", "Banana", "Mango", "Orange")
                    ),
                    arrayOf<Any>(
                        arrayOf<Any>("C", "W", "W", "W", 1, 2, 0),
                        arrayOf<Any>(0, 1, 2, "C", "W", "W", "W")
                    )
                )
            )
        }
    }
}
