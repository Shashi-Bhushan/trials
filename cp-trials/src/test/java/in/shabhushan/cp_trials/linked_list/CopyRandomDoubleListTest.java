package in.shabhushan.cp_trials.linked_list;

import org.junit.BeforeClass;
import org.junit.Test;
import static in.shabhushan.cp_trials.linked_list.CopyRandomDoubleList.DRLinkedList;
import static in.shabhushan.cp_trials.linked_list.CopyRandomDoubleList.getDeepCopy;
import static org.junit.Assert.*;

public class CopyRandomDoubleListTest {
  private static DRLinkedList<Integer> head;

  @BeforeClass
  public static void setup() {
    DRLinkedList<Integer> first = new DRLinkedList<>(1);
    DRLinkedList<Integer> second = new DRLinkedList<>(2);
    DRLinkedList<Integer> third = new DRLinkedList<>(12);
    DRLinkedList<Integer> fourth = new DRLinkedList<>(12);

    first.next = second;
    second.next = third;
    third.next = fourth;

    first.random = third;
    second.random = first;
    third.random = third;
    fourth.random = first;

    head = first;
  }

  @Test
  public void testDeepCopy() {
    DRLinkedList<Integer> copy = getDeepCopy(head);

    DRLinkedList<Integer> current = head;
    DRLinkedList<Integer> copyCurrent = copy;


    while (current != null) {
      assertEquals(current.data, copyCurrent.data);
      assertEquals(current.random.data, copyCurrent.random.data);
      assertNotEquals(current, copyCurrent);

      current = current.next;
      copyCurrent = copyCurrent.next;
    }
  }
}
