package `in`.shabhushan.cp_trials.dsbook.`chapter3-linkedlist`

import java.util.*

class CustomLinkedList<T> {
  var head: Node<T>? = null
  var length: Int = 0

  data class Node<T>(
    var data: T,
    var next: Node<T>? = null
  ) {
    override fun toString(): String {
      return "Node(data=$data)"
    }
  }

  fun pushToFront(n: T) = Node(n).let {
    it.next = head
    head = it

    this.length++
  }


  fun removeFromFront(): Node<T>? = if (!this.isEmpty()) head.also {
    head = head?.next
  } else null

  fun peek(): Node<T>? = if (!this.isEmpty()) head else null

  fun usingDoubleIteration(
    n: Int
  ): Node<T>? = this.head?.let {
    var current: Node<T>? = this.head
    var length = 0

    while (current?.next != null) {
      current = current.next
      length++
    }

    current = head
    var nodeNum = 0
    while (nodeNum != (length - n + 1)) {
      current = current?.next
      nodeNum++
    }

    current
  }

  fun usingTwoPointer(
    n: Int
  ): Node<T>? = this.head?.let {
    var firstPointer: Node<T>? = this.head
    var length = 0

    while (length != n) {
      firstPointer = firstPointer?.next
      length++
    }

    var secondPointer: Node<T>? = this.head

    while (firstPointer != null) {
      firstPointer = firstPointer.next
      secondPointer = secondPointer?.next
    }

    secondPointer
  }

  fun isEmpty() = this.length == 0

  companion object {
    fun <T> getReverseList(
      node: Node<T>?
    ): List<T> = node?.let {
      mutableListOf(it.data).apply {
        this.addAll(getReverseList(node.next))
      }.toList()
    } ?: emptyList()

    fun <T> toList(
      node: Node<T>?
    ): List<T> = node?.let {
      mutableListOf(it.data).apply {
        this.addAll(toList(it.next))
      }.toList()
    } ?: emptyList()

    fun mergeTwoLists(
      l1: Node<Int>?,
      l2: Node<Int>?
    ): Node<Int>? = if (l1 == null) l2 else if (l2 == null) l1 else {
      var pointerA = l1
      var pointerB = l2

      val dummyNode = Node(0)
      var tail: Node<Int>? = dummyNode

      while (true) {
        if (pointerA == null) {
          tail?.next = pointerB
          break
        } else if (pointerB == null) {
          tail?.next = pointerA
          break
        } else if (pointerA.data <= pointerB.data) {
          tail?.next = Node(pointerA.data)
          pointerA = pointerA.next
        } else {
          tail?.next = Node(pointerB.data)
          pointerB = pointerB.next
        }

        tail = tail?.next
      }

      dummyNode.next
    }

    /**
     * Reverse a Linked list in pair:
     * 1 > 2 > 3 > 4 > 5 >>>>>>>>>>>>>> TO >>>>>>>>>>>>>> 2 > 1 > 4 > 3 > 5
     */
    fun sortInPair(
      l1: Node<Int>?
    ) {
      var current = l1

      while (current?.next != null) {
        // swap data for current and current.next
        val temp = current.data
        current.data = current!!.next!!.data
        current.next?.data = temp

        current = current.next?.next
      }
    }

    fun isPalindrome(
      head: Node<Int>?
    ): Boolean {
      val stack = Stack<Node<Int>>()

      var current = head
      while (current != null) {
        stack.push(current)
        current = current.next
      }

      current = head

      while (current != null) {
        if (stack.pop().data != current.data) {
          return false
        }

        current = current.next
      }

      return true
    }

    /**
     * Get a sorted list by Even elements first, and then Odd elements
     */
    fun sortEvenOdd(
      head: Node<Int>?
    ): Node<Int>? = head?.let {
      val even = Node(Integer.MIN_VALUE)
      val odd = Node(Integer.MIN_VALUE)

      var current: Node<Int>? = head
      var evenCurrent: Node<Int>? = even
      var oddCurrent: Node<Int>? = odd

      while (current != null) {
        if (current.data % 2 == 0) {
          evenCurrent?.next = Node(current.data)
          evenCurrent = evenCurrent?.next
        } else {
          oddCurrent?.next = Node(current.data)
          oddCurrent = oddCurrent?.next
        }

        current = current.next
      }

      evenCurrent?.next = odd.next

      even.next
    }

    /**
     * Find first from the end whose n%k = 0, n is length of linked list and k is a number
     */
    fun findFirstFromEnd(
      head: Node<Int>?,
      k: Int
    ): Node<Int>? = head?.let {
      val map = getListAsMap(head)

      val length = map.size

      map[length - k - 1]
    }

    fun <T> getLength(
      head: Node<T>?,
      lengthSoFar: Int = 0
    ): Int = if (head == null) lengthSoFar else getLength(head.next, lengthSoFar + 1)

    fun <T> getListAsMap(
      head: Node<T>?,
      lengthSoFar: Int = 0
    ): Map<Int, Node<T>?> = if (head?.next == null) {
      mapOf(lengthSoFar to head)
    } else {
      val forwardMap: Map<Int, Node<T>?> = getListAsMap(head.next, lengthSoFar + 1)

      mutableMapOf<Int, Node<T>?>(lengthSoFar to head).apply {
        this.putAll(forwardMap)
      }.toMap()
    }

    /**
     * Given it's head, removes duplicates from Linked list
     *
     * Removes duplicates one node at a time
     */
    fun <T> getDedup(
      head: Node<T>?
    ): Node<T>? = when {
      // terminal condition
      head?.next == null -> head
      // data equal, skip one node and check this node again
      head.data == head.next?.data -> {
        head.next = head.next?.next
        getDedup(head)
      }
      // check next node onwards
      else -> {
        head.next = getDedup(head.next)
        head
      }
    }

    /**
     * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
     *
     * You should preserve the original relative order of the nodes in each of the two partitions.
     *
     * Example:
     *
     * Input: head = 1->4->3->2->5->2, x = 3
     * Output: 1->2->2->4->3->5
     */
    fun listSortByX(
      head: Node<Int>?,
      x: Int
    ) = head?.next?.let {
      val nodeA = Node(head.data)
      val nodeB = Node(head.data)

      var pointerA: Node<Int>? = nodeA
      var pointerB: Node<Int>? = nodeB

      var current = head

      while (current != null) {
        if (current.data < x) {
          pointerA?.next = Node(current.data)
          pointerA = pointerA?.next
        } else {
          pointerB?.next = Node(current.data)
          pointerB = pointerB?.next
        }

        current = current.next
      }

      pointerA?.next = nodeB.next
      nodeA.next
    } ?: head
  }
}
