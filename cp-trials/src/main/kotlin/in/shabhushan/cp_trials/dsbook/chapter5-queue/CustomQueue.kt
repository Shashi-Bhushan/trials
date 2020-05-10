package `in`.shabhushan.cp_trials.dsbook.`chapter5-queue`

import java.util.*

class CustomQueue<E>(override val size: Int) : Queue<E>, AbstractCollection<E>(){

  var head = 0
  var tail = 0
  private var elements: Array<Any?> = Array(size) { null }
  private val MAX_ARRAY_SIZE = 12

  //////////////
  // ADD Methods
  //////////////
  /**
   * Throws exception if can't add
   */
  override fun add(element: E): Boolean {
    elements[tail] = element

    // round to 0 if more than length
    tail = increment(tail)
    if (head == tail) {
      grow()
    }

    return true
  }

  /**
   * Gives false if can't add
   */
  override fun offer(e: E): Boolean {
    TODO("Not yet implemented")
  }

  /////////////////
  // REMOVE Methods
  /////////////////
  /**
   * throws exception if queue is empty
   */
  override fun remove(): E? = elements[head]?.let { element ->
    elements[head] = null
    head = increment(head)

    element as E
  }

  /**
   * returns null if the queue is empty
   */
  override fun poll(): E? {
    TODO("Not yet implemented")
  }

  //////////////////
  // Inspect Methods
  //////////////////
  /**
   * throws exception if the queue is empty
   */
  override fun element(): E? = elements[tail]?.let { it as E }
  /**
   * returns null if the queue is empty
   */
  override fun peek(): E {
    TODO("Not yet implemented")
  }

  override fun iterator(): MutableIterator<E> {
    TODO("Not yet implemented")
  }

  ////////////////
  // Util Methods
  ////////////////
  private fun increment(i: Int, modulus: Int = elements.size) = if (i + 1 >= modulus) 0 else i + 1

  /**
   * Increases the capacity of this deque by at least the given amount.
   */
  private fun grow() {
    val oldCapacity = elements.size

    // Double capacity if small; else grow by 50%
    val jump = if (oldCapacity < 8) oldCapacity + 2 else oldCapacity shr 1
    //if (jump < needed || )
    val newCapacity = oldCapacity + jump

    elements = elements.copyOf(newCapacity)

    if (tail < head || (tail == head && elements[head] != null)) {
      // wrap around; slide first leg forward to end of array
      val newSpace = newCapacity - oldCapacity
      System.arraycopy(elements, head, elements, head + newSpace, oldCapacity - head)

      var i = head
      val to = newSpace.let { head += it; head }
      while (i < to) {
        elements[i] = null
        i++
      }
    }
  }

  override fun toString(): String {
    return "CustomQueue(elements = ${elements.contentToString()}, size = ${elements.size})"
  }
}

fun highlight(code: String): String = code
  .replace("F+".toRegex()) { it.value }
  .replace("L+".toRegex()) { it.value }
  .replace("R+".toRegex()) { it.value }
  .replace("[0-9]+".toRegex()) { it.value }

fun syntax(value: String , color:String):String = "<span style=\"color: $color\">$value</span>"
