package `in`.shabhushan.cp_trials.dsbook.`chapter3-linkedlist`

import `in`.shabhushan.cp_trials.dsbook.`chapter3-linkedlist`.CustomLinkedList.Companion.findFirstFromEnd
import `in`.shabhushan.cp_trials.dsbook.`chapter3-linkedlist`.CustomLinkedList.Companion.getDedup
import `in`.shabhushan.cp_trials.dsbook.`chapter3-linkedlist`.CustomLinkedList.Companion.getReverseList
import `in`.shabhushan.cp_trials.dsbook.`chapter3-linkedlist`.CustomLinkedList.Companion.isPalindrome
import `in`.shabhushan.cp_trials.dsbook.`chapter3-linkedlist`.CustomLinkedList.Companion.listSortByX
import `in`.shabhushan.cp_trials.dsbook.`chapter3-linkedlist`.CustomLinkedList.Companion.mergeTwoLists
import `in`.shabhushan.cp_trials.dsbook.`chapter3-linkedlist`.CustomLinkedList.Companion.sortEvenOdd
import `in`.shabhushan.cp_trials.dsbook.`chapter3-linkedlist`.CustomLinkedList.Companion.sortInPair
import `in`.shabhushan.cp_trials.dsbook.`chapter3-linkedlist`.CustomLinkedList.Companion.toList
import org.junit.Assert.assertArrayEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import kotlin.test.Test
import kotlin.test.assertEquals

class NthNodeFromLastTest {
  @Test
  fun testNthNodeFromLast_usingDoubleIteration() {
    val list = CustomLinkedList<String>().also { list ->
      list.pushToFront("first")
      list.pushToFront("second")
      list.pushToFront("third")
      list.pushToFront("fourth")
      list.pushToFront("fifth")
      list.pushToFront("sixth")
      list.pushToFront("seventh")
      list.pushToFront("eighth")
      list.pushToFront("ninth")
    }

    assertEquals("third", list.usingDoubleIteration(3)?.data)
    assertEquals("third", list.usingTwoPointer(3)?.data)
  }

  @Test
  fun testMergeSortedList() {
    val list = CustomLinkedList<Int>().also { list ->
      list.pushToFront(7)
      list.pushToFront(3)
      list.pushToFront(2)
      list.pushToFront(0)
      list.pushToFront(0)
    }

    val list2 = CustomLinkedList<Int>().also { list ->
      list.pushToFront(9)
      list.pushToFront(6)
      list.pushToFront(6)
      list.pushToFront(1)
      list.pushToFront(-1)
    }

    val mergedList = toList(mergeTwoLists(list.head, list2.head))

    assertArrayEquals(arrayOf(-1, 0, 0, 1, 2, 3, 6, 6, 7, 9), mergedList.toTypedArray())
  }

  @Test
  fun testSortedInPair() {
    val list = CustomLinkedList<Int>().also { list ->
      list.pushToFront(5)
      list.pushToFront(4)
      list.pushToFront(3)
      list.pushToFront(2)
      list.pushToFront(1)
    }

    sortInPair(list.head)

    assertArrayEquals(arrayOf(2, 1, 4, 3, 5), toList(list.head).toTypedArray())
  }

  @Test
  fun testGetReverseLinkedList() {
    val list = CustomLinkedList<Int>().also { list ->
      list.pushToFront(5)
      list.pushToFront(4)
      list.pushToFront(3)
      list.pushToFront(2)
      list.pushToFront(1)
    }

    val reverseList = getReverseList(list.head)
    assertArrayEquals(arrayOf(1, 2, 3, 4, 5), reverseList.toTypedArray())
  }

  @Test
  fun testIsPalindrome() {
    val list = CustomLinkedList<Int>().also { list ->
      list.pushToFront(5)
      list.pushToFront(4)
      list.pushToFront(3)
      list.pushToFront(2)
      list.pushToFront(1)
    }

    assertFalse(isPalindrome(list.head))
  }

  @Test
  fun testIsPalindromeForValidValue() {
    val list = CustomLinkedList<Int>().also { list ->
      list.pushToFront(1)
      list.pushToFront(2)
      list.pushToFront(3)
      list.pushToFront(2)
      list.pushToFront(1)
    }

    assertTrue(isPalindrome(list.head))
  }

  @Test
  fun testSortEvenOdd() {
    val list = CustomLinkedList<Int>().also { list ->
      list.pushToFront(5)
      list.pushToFront(4)
      list.pushToFront(3)
      list.pushToFront(2)
      list.pushToFront(1)
    }

    val result = sortEvenOdd(list.head)
    assertArrayEquals(arrayOf(2, 4, 1, 3, 5), toList(result).toTypedArray())
  }

  @Test
  fun testFindFirstFromEnd() {
    val list = CustomLinkedList<Int>().also { list ->
      list.pushToFront(12)
      list.pushToFront(11)
      list.pushToFront(10)
      list.pushToFront(9)
      list.pushToFront(8)
      list.pushToFront(7)
      list.pushToFront(6)
      list.pushToFront(5)
      list.pushToFront(4)
      list.pushToFront(3)
      list.pushToFront(2)
      list.pushToFront(1)
    }

    val result = findFirstFromEnd(list.head, 3)
    assertEquals(9, result?.data)
  }

  @Test
  fun testDedup() {
    val list = CustomLinkedList<Int>().also { list ->
      list.pushToFront(5)
      list.pushToFront(5)
      list.pushToFront(3)
      list.pushToFront(2)
      list.pushToFront(2)
      list.pushToFront(2)
      list.pushToFront(2)
      list.pushToFront(2)
      list.pushToFront(1)
      list.pushToFront(1)
      list.pushToFront(1)
      list.pushToFront(1)
      list.pushToFront(0)
    }

    val result = getDedup(list.head)
    assertArrayEquals(arrayOf(0, 1, 2, 3, 5), toList(result).toTypedArray())
  }
  @Test
  fun testListSortByX() {
    val list = CustomLinkedList<Int>().also { list ->
      list.pushToFront(2)
      list.pushToFront(5)
      list.pushToFront(2)
      list.pushToFront(3)
      list.pushToFront(4)
      list.pushToFront(1)
    }

    val result = listSortByX(list.head, 3)
    assertArrayEquals(arrayOf(1, 2, 2, 4, 3, 5), toList(result).toTypedArray())
  }
}
