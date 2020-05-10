package `in`.shabhushan.cp_trials.contest.aprilContest

import java.util.*

// Problem 2
/*fun solve(num: Int): Int = generateSequence(num to 0) {
  val rem = it.first % 10
  Pair(it.first / 10, (it.second + rem * rem))
}.takeWhile { it.first != 0 }.last().let {
  it.first * it.first + it.second
}*/

fun solve(num: Int): Int {
  var i = num
  var sum = 0

  while (i != 0) {
    val x = i % 10
    sum += (x * x)
    i /= 10
  }

  return sum
}

fun isHappy(n: Int): Boolean {
  val set = mutableSetOf<Int>()

  var num = n

  while (num != 1) {
    val solve = solve(num)

    if (set.contains(solve)) {
      return false
    }

    set.add(num)
    num = solve
  }

  return true
}

// Problem 3:
/**
 * BRUTE FORCE SOLUTION
 */
fun maxSubArray(nums: IntArray): Int {

  var max = Integer.MIN_VALUE

  nums.indices.forEach { i ->
    var sum = 0
    var tripMax = Integer.MIN_VALUE

    (i until nums.size).forEach { j ->
      sum += nums[j]

      tripMax = Math.max(tripMax, sum)
    }

    max = Math.max(max, tripMax)
  }

  return max
}

/**
 * KADANE's ALGORITHM
 * O(n) time (1) Space
 */
fun maxSubArray2(nums: IntArray): Int {
  var ans = Integer.MIN_VALUE
  var a = 0

  nums.forEach { num ->
    a += num
    ans = Math.max(ans, a)
    a = Math.max(0, a)
  }

  return ans
}

/**
 * O(n) Time O(n) Space Solution
 */
fun maxSubArray3(nums: IntArray): Int {
  val arraySum = mutableListOf<Int>()

  arraySum.add(nums[0])

  (1 until nums.size).forEach { index ->
    arraySum.add(nums[index] + arraySum.last())
  }

  var minInSumArray = 0
  var ans = Integer.MIN_VALUE

  nums.indices.forEach { index ->
    ans = Math.max(ans, arraySum[index] - minInSumArray)
    minInSumArray = Math.min(minInSumArray, arraySum[index])
    println()
  }

  return ans
}

fun countLargestGroup(n: Int): Int {
  val map = (1..n).map {
    digitSum(it)
  }.groupBy { it }

  var max = Integer.MIN_VALUE
  var count = 0

  println("map ${map.keys.joinToString(",")} -- ${map.values.joinToString(",")}")

  map.values.forEach {
    if (it.size > max) {
      count = 1
      max = it.size
    } else if (it.size == max) {
      count++
    }
  }

  return count
}

fun digitSum(n: Int): Int {
  var i = 0

  var num = n

  while (num != 0) {
    i += (num % 10)
    num /= 10
  }

  return i
}

data class CircleType(val x: Int, val y: Int, val r: Int)

data class RectType(val x: Int, val y: Int, val x2: Int, val y2: Int)

fun checkOverlap(radius: Int, x: Int, y: Int, x1: Int, y1: Int, x2: Int, y2: Int): Boolean {
  val nearestX = Math.max(x1, Math.min(x, x1 + (x2 - x1)))
  val nearestY = Math.max(y1, Math.min(y, y1 + (y2 - y1)))
  //println("(${nearestX}, ${nearestY})")

  val deltaX = x - nearestX;
  val deltaY = y - nearestY;
  return (deltaX * deltaX + deltaY * deltaY) <= (radius * radius);
}

val map = mutableMapOf<Int, Int>()

fun climbStairs(n: Int): Int = when {
  n < 0 -> 0
  n == 0 || n == 1 -> n
  else -> {
    var a = 1
    var b = 2

    (3..n).forEach { _ ->
      b += a
      a = b - a
    }

    a
  }
}

fun groupAnagrams(strs: Array<String>): List<List<String>> =
  strs.map {
    it to it.toCharArray().apply { this.sort() }.joinToString("")
  }.groupBy {
    it.second
  }.map {
    it.value.map { it.first }
  }

fun backspaceCompare(S: String, T: String): Boolean {
  val stackOne = Stack<Char>()
  val stackTwo = Stack<Char>()

  S.forEach { char ->
    if (char != '#')
      stackOne.push(char)
    else if (stackOne.isNotEmpty())
      stackOne.pop()
  }

  T.forEach { char ->
    if (char != '#')
      stackTwo.push(char)
    else if (stackTwo.isNotEmpty())
      stackTwo.pop()
  }

  return stackOne == stackTwo
}
