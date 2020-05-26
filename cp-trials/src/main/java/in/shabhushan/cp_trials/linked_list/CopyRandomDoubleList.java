package in.shabhushan.cp_trials.linked_list;

/**
 * You are given a double linked list with two pointers, `next` and `random`.
 * Devise an algorithm to deep copy the linked list, along with next and random pointers.
 *
 * Solved in O(n) time and O(1) space(except for the new linked list)
 * Check out https://www.youtube.com/watch?v=xbpUHSKoALg for reference
 */
public class CopyRandomDoubleList{
  /**
   * Stands for Doubly Random Linked List
   * @param <T>
   */
  public static class DRLinkedList<T> {
    public T data;
    public DRLinkedList<T> next;
    public DRLinkedList<T> random;

    public DRLinkedList(T data) {
      this.data = data;
    }
  }

  public static <T> DRLinkedList<T> getDeepCopy(DRLinkedList<T> head) {
    addNextPointers(head);

    updateRandomPointers(head);

    return delinkHeadNode(head);
  }

  private static <T> void addNextPointers(DRLinkedList<T> node) {
    while (node != null) {
      DRLinkedList<T> next = node.next;

      DRLinkedList<T> newNode = new DRLinkedList<>(node.data);
      newNode.next = next;

      node.next = newNode;

      node = node.next.next;
    }
  }

  private static <T> void updateRandomPointers(DRLinkedList<T> node) {
    while (node != null) {
      node.next.random = node.random.next;

      node = node.next.next;
    }
  }

  private static <T> DRLinkedList<T> delinkHeadNode(DRLinkedList<T> node) {
    DRLinkedList<T> head = node.next;

    DRLinkedList<T> current = node;
    DRLinkedList<T> copyCurrent = node.next;

    while (current != null && copyCurrent != null) {
      DRLinkedList<T> next = copyCurrent.next;

      if (next != null) {
        copyCurrent.next = next.next;
        current.next = next;
      } else {
        copyCurrent.next = null;
        current.next = null;
      }

      current = current.next;
      copyCurrent = copyCurrent.next;
    }

    return head;
  }
}
