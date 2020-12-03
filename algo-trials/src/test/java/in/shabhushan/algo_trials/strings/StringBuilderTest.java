package in.shabhushan.algo_trials.strings;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringBuilderTest {
  @Test
  public void testStringBuilderCapacity() throws InterruptedException {
    StringBuilder sb = new StringBuilder();

    assertEquals(16, sb.capacity());

    sb.append("abcdefghijklmnop");

    assertEquals(16, sb.capacity());

    sb.append("abcdefghijklmnop");

    assertEquals(34, sb.capacity());

    sb.append("qrs"); // s is 35th character

    assertEquals(70, sb.capacity());
  }

  @Test
  public void testStringBuilderThread() {
    StringBuilder sb = new StringBuilder(100);

    for (int i = 0; i < 10; i++) {
      new Thread(() -> {
        sb.append("a");
      }).start();

      new Thread(() -> {
        sb.append("b");
      }).start();
    }

    System.out.println(sb.toString());
  }

  @Test
  public void testStringBufferThread() {
    StringBuffer sb = new StringBuffer(100);

    for (int i = 0; i < 10; i++) {
      new Thread(() -> {
        sb.append("a");
      }).start();

      new Thread(() -> {
        sb.append("b");
      }).start();
    }

    System.out.println(sb.toString());
  }
}
