package `in`.shabhushan.cp_trials.dsbook.methods.backtracking

import `in`.shabhushan.cp_trials.dsbook.methods.backtracking.CoinChange.coinChangeMinimumCoins
import `in`.shabhushan.cp_trials.dsbook.methods.backtracking.CoinChange.coinChangePossible
import `in`.shabhushan.cp_trials.dsbook.methods.backtracking.CoinChange.coinChangeTotalCanonicallySimilarWays
import `in`.shabhushan.cp_trials.dsbook.methods.backtracking.CoinChange.coinChangeTotalWays
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class CoinChangeTest {
  @Test
  fun testCoinChange_Possible() {
    assertTrue(coinChangePossible(intArrayOf(5, 2, 2), 9))
    assertTrue(coinChangePossible(intArrayOf(5, 2, 2), 7))
    assertFalse(coinChangePossible(intArrayOf(5, 2, 2), 3))
  }

  @Test
  fun testCoinChange_MinimumCoins() {
    assertEquals(2, coinChangeMinimumCoins(intArrayOf(1, 3, 4), 6))
    assertEquals(1, coinChangeMinimumCoins(intArrayOf(1, 2, 5), 5))
  }

  @Test
  fun testCoinChange_TotalCanonicallySimilarWays() {
    //assertEquals(4, coinChangeTotalCanonicallySimilarWays(intArrayOf(1, 3, 4), 6))
    assertEquals(4, coinChangeTotalCanonicallySimilarWays(intArrayOf(1, 2, 5), 5))
    //assertEquals(0, coinChangeTotalCanonicallySimilarWays(intArrayOf(2, 5), 3))
  }

  @Test
  fun testCoinChange_TotalWays() {
    //assertEquals(9, coinChangeTotalWays(intArrayOf(1, 3, 4), 6))
    assertEquals(9, coinChangeTotalWays(intArrayOf(1, 2, 5), 5))
    //assertEquals(0, coinChangeTotalWays(intArrayOf(2, 5), 3))
  }
}
