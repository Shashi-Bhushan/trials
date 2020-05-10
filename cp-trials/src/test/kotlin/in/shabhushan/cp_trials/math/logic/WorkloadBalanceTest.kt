package `in`.shabhushan.cp_trials.math.logic

import `in`.shabhushan.cp_trials.math.logic.WorkloadBalance.splitList
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import kotlin.math.abs
import kotlin.test.Test
import kotlin.test.assertEquals

@RunWith(Parameterized::class)
class WorkloadBalanceTest(
    val input: List<Int>
) {
    @Test
    fun `Basic Tests`(){
        val returnPair = splitList(input)

        assertEquals(1, abs(returnPair.first.sum() - returnPair.second.sum()))
    }

    companion object {
        @JvmStatic
        @Parameterized.Parameters
        @Throws(Throwable::class)
        fun data(): Iterable<Array<Any>> {
            return listOf<Array<Any>>(
                arrayOf<Any>(
                    listOf(2, 3, 4, 6, 8, 2),
                    1
                )
            )
        }
    }
}
