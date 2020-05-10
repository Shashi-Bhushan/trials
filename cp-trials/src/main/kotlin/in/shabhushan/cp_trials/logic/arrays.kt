package `in`.shabhushan.cp_trials.logic

import java.util.*

fun containsDuplicate(nums: IntArray): Boolean {
  val map = mutableSetOf<Int>()

  nums.forEach {
    if (map.contains(it))
      return true
    else
      map.add(it)
  }

  return false
}

/**
 * Leetcode: 219
 */
fun containsNearbyDuplicate(
  nums: IntArray,
  k: Int
): Boolean = if (nums.size < 2 || k < 1) {
  false
} else {
  val set = hashSetOf<Int>()

  nums.indices.forEach { index ->
    if (set.contains(nums[index]))
      return true
    else {
      set.add(nums[index])
    }

    if (set.size > k)
      set.remove(nums[index - k])
  }

  false
}

fun containsNearbyAlmostDuplicate(
  nums: IntArray,
  k: Int,
  t: Int
): Boolean = if (t < 0 || k < 1) {
  false
} else {
  val set = TreeSet<Long>()

  nums.indices.forEach { index ->
    val current = nums[index].toLong()

    // greatest element less than current
    val floor = set.floor(current)?.toLong()
    // least element more than current
    var ceil = set.ceiling(current)?.toLong()

    if (
      // difference between floor and current is [0, t]
      (floor != null && current - floor <= t) ||
      // difference between ceil and current is [0, t]
      (ceil != null && ceil - current <= t)
    ) {
      return true
    }

    set.add(current)

    if (set.size > k)
      // if size is more than k, remove the element added first
      set.remove(nums[index - k].toLong())
  }

  false
}

/**
 * Leetcode 80
 * Algorithm: remove duplicates from array, keeping two of same

Given nums = [1,1,1,2,2,3]

[1,1,2,2,3]

Given nums = [0,0,1,1,1,1,2,3,3]

[0, 0, 1, 1, 2, 3 , 3]
 * Also check https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/discuss/27987/Short-and-Simple-Java-solution-(easy-to-understand)
 */
fun removeDuplicates(nums: IntArray): Int = if (nums.size < 3) nums.size else {
  var prev = 1
  //var prevPrev = 0

  (2 until nums.size).forEach{ current ->
    //println("PrevPrev ${prevPrev}, pev ${prev}, current ${current}")
    //println("Values: PrevPrev ${nums[prevPrev]}, pev ${nums[prev]}, current ${nums[current]}")
    if (nums[prev - 1] != nums[current]) {
      prev++

      //if (nums[prev] != nums[current]) {
      nums[prev] = nums[current]
      //}
    }
  }

  prev + 1
}

