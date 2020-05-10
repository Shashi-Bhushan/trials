package `in`.shabhushan.cp_trials.dsbook.methods.backtracking

import `in`.shabhushan.cp_trials.dsbook.methods.backtracking.CombinationSum4.backwardDFSWithCaching
import `in`.shabhushan.cp_trials.dsbook.methods.backtracking.CombinationSum4.backwardDFSWithoutCaching
import `in`.shabhushan.cp_trials.dsbook.methods.backtracking.CombinationSum4.backwardDynamicProgramming
import `in`.shabhushan.cp_trials.dsbook.methods.backtracking.CombinationSum4.backwardRecursiveWithCaching
import `in`.shabhushan.cp_trials.dsbook.methods.backtracking.CombinationSum4.backwardRecursiveWithoutCaching
import `in`.shabhushan.cp_trials.dsbook.methods.backtracking.CombinationSum4.forwardDFSWithCaching
import `in`.shabhushan.cp_trials.dsbook.methods.backtracking.CombinationSum4.forwardDFSWithoutCaching
import `in`.shabhushan.cp_trials.dsbook.methods.backtracking.CombinationSum4.forwardOrPushIterativeDynamicProgramming
import `in`.shabhushan.cp_trials.dsbook.methods.backtracking.CombinationSum4.iterativeDynamicProgramming
import kotlin.system.measureNanoTime
import kotlin.test.Test
import kotlin.test.assertEquals

class CombinationSumTest {
  @Test
  fun testCombinationSum() {
    val result = combinationSum(intArrayOf(1, 2, 3), 4)
    println(result.joinToString(","))
    //assertEquals(4, combinationSum(intArrayOf(2, 3, 6, 7), 7))
  }

  @Test
  fun testCombinationSum4_forwardDfs_withoutCaching() {
    measureNanoTime {
      assertEquals(7, forwardDFSWithoutCaching(intArrayOf(1, 2, 3), 4))
      assertEquals(6, forwardDFSWithoutCaching(intArrayOf(1, 2, 4), 4))
      assertEquals(4, forwardDFSWithoutCaching(intArrayOf(2, 3, 6, 7), 7))

      assertEquals(169, forwardDFSWithoutCaching(intArrayOf(4, 2, 1), 10))
    }.let { time ->
      println("Time taken for Forward DFS (Without Caching) :: ${time}")
    }
  }

  @Test
  fun testCombinationSum4_backwardDfs_withoutCaching() {
    measureNanoTime {
      assertEquals(7, backwardDFSWithoutCaching(intArrayOf(1, 2, 3), 4))
      assertEquals(6, backwardDFSWithoutCaching(intArrayOf(1, 2, 4), 4))
      assertEquals(4, backwardDFSWithoutCaching(intArrayOf(2, 3, 6, 7), 7))

      assertEquals(169, backwardDFSWithoutCaching(intArrayOf(4, 2, 1), 10))
    }.let { time ->
      println("Time taken for Backward DFS (Without Caching) :: ${time}")
    }
  }

  @Test
  fun testCombinationSum4_backwardDfs_withCaching() {
    measureNanoTime {
      assertEquals(7, backwardDFSWithCaching(intArrayOf(1, 2, 3), 4))
      assertEquals(6, backwardDFSWithCaching(intArrayOf(1, 2, 4), 4))
      assertEquals(4, backwardDFSWithCaching(intArrayOf(2, 3, 6, 7), 7))

      assertEquals(169, backwardDFSWithCaching(intArrayOf(4, 2, 1), 10))
    }.let { time ->
      println("Time taken for Backward DFS (With Caching) :: ${time}")
    }
  }

  @Test
  fun testCombinationSum4_forwardDfs_withCaching() {
    measureNanoTime {
      assertEquals(7, forwardDFSWithCaching(intArrayOf(1, 2, 3), 4))
      assertEquals(6, forwardDFSWithCaching(intArrayOf(1, 2, 4), 4))
      assertEquals(4, forwardDFSWithCaching(intArrayOf(2, 3, 6, 7), 7))

      assertEquals(169, forwardDFSWithCaching(intArrayOf(4, 2, 1), 10))
    }.let { time ->
      println("Time taken for Forward DFS (With Caching) :: ${time}")
    }
  }

  @Test
  fun testCombinationSum4_recursive_withoutCaching() {
    measureNanoTime {
      assertEquals(7, backwardRecursiveWithoutCaching(intArrayOf(1, 2, 3), 4))
      assertEquals(6, backwardRecursiveWithoutCaching(intArrayOf(1, 2, 4), 4))
      assertEquals(4, backwardRecursiveWithoutCaching(intArrayOf(2, 3, 6, 7), 7))

      assertEquals(169, backwardRecursiveWithoutCaching(intArrayOf(4, 2, 1), 10))
    }.let { time ->
      println("Time taken for Recursive (without Caching) :: ${time}")
    }
  }

  @Test
  fun testCombinationSum4_recursive_withCaching() {
    measureNanoTime {
      assertEquals(7, backwardRecursiveWithCaching(intArrayOf(1, 2, 3), 4))
      assertEquals(6, backwardRecursiveWithCaching(intArrayOf(1, 2, 4), 4))
      assertEquals(4, backwardRecursiveWithCaching(intArrayOf(2, 3, 6, 7), 7))

      assertEquals(169, backwardRecursiveWithCaching(intArrayOf(4, 2, 1), 10))
    }.let { time ->
      println("Time taken for Recursive (with Caching) :: ${time}")
    }
  }

  @Test
  fun testCombinationSum4_dp_withoutCaching() {
    measureNanoTime {
      assertEquals(7, backwardDynamicProgramming(intArrayOf(1, 2, 3), 4))
      assertEquals(6, backwardDynamicProgramming(intArrayOf(1, 2, 4), 4))
      assertEquals(4, backwardDynamicProgramming(intArrayOf(2, 3, 6, 7), 7))

      assertEquals(169, backwardDynamicProgramming(intArrayOf(4, 2, 1), 10))
    }.let { time ->
      println("Time taken for Recursive DP :: ${time}")
    }
  }

  @Test
  fun testCombinationSum4_IterativeDP() {
    measureNanoTime {
      assertEquals(7, iterativeDynamicProgramming(intArrayOf(1, 2, 3), 4))
      assertEquals(6, iterativeDynamicProgramming(intArrayOf(1, 2, 4), 4))
      assertEquals(4, iterativeDynamicProgramming(intArrayOf(2, 3, 6, 7), 7))

      assertEquals(169, iterativeDynamicProgramming(intArrayOf(4, 2, 1), 10))
    }.let { time ->
      println("Time taken for Iterative DP :: ${time}")
    }
  }

  @Test
  fun testCombinationSum4_forwardOrPushIterativeDP() {
    measureNanoTime {
      assertEquals(7, forwardOrPushIterativeDynamicProgramming(intArrayOf(1, 2, 3), 4))
      assertEquals(6, forwardOrPushIterativeDynamicProgramming(intArrayOf(1, 2, 4), 4))
      assertEquals(4, forwardOrPushIterativeDynamicProgramming(intArrayOf(2, 3, 6, 7), 7))

      assertEquals(169, forwardOrPushIterativeDynamicProgramming(intArrayOf(4, 2, 1), 10))
    }.let { time ->
      println("Time taken for Iterative Push DP :: ${time}")
    }
  }
}
