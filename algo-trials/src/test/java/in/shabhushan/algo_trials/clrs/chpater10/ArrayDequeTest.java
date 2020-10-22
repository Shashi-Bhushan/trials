package in.shabhushan.algo_trials.clrs.chpater10;

import in.shabhushan.algo_trials.clrs.chapter10.ArrayDeque;
import org.junit.Assert;
import org.junit.Test;

public class ArrayDequeTest {
  @Test(expected = IllegalStateException.class)
  public void testArrayDeque() {
    ArrayDeque deque = new ArrayDeque(5);

    deque.pushBack(5);
    Assert.assertArrayEquals(new int[]{5,0,0,0,0}, deque.getArray());
    deque.removeBack();
    Assert.assertArrayEquals(new int[]{0,0,0,0,0}, deque.getArray());
    deque.pushFront(5);
    Assert.assertArrayEquals(new int[]{0,0,0,0,5}, deque.getArray());
    deque.pushBack(6);
    Assert.assertArrayEquals(new int[]{6,0,0,0,5}, deque.getArray());
    deque.pushFront(3);
    Assert.assertArrayEquals(new int[]{6,0,0,3,5}, deque.getArray());
    deque.pushFront(4);
    Assert.assertArrayEquals(new int[]{6,0,4,3,5}, deque.getArray());
    deque.pushBack(7);
    Assert.assertArrayEquals(new int[]{6,7,4,3,5}, deque.getArray());

    // At this point, Illegal state exception
    deque.pushBack(8);
  }
}
