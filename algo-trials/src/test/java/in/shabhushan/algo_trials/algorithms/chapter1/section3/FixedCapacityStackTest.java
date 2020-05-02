package in.shabhushan.algo_trials.algorithms.chapter1.section3;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FixedCapacityStackTest {
  @Test
  public void testStringStack() {
    FixedCapacityStack<String> stack = new FixedCapacityStack<>(5);

    stack.push("This");
    stack.push("is");
    stack.push("the");
    stack.push("new");

    assertEquals("new", stack.pop());
    stack.push("old");
    stack.push("order");

    assertEquals(5, stack.size());
  }

  @Test(expected = ArrayIndexOutOfBoundsException.class)
  public void testOutofBounds() {
    FixedCapacityStack<String> stack = new FixedCapacityStack<>(0);

    stack.push("Error");
  }
}
