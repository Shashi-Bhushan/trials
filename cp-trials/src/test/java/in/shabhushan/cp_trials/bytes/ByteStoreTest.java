package in.shabhushan.cp_trials.bytes;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class ByteStoreTest {

  @Test
  public void test_0() throws IOException {
    ByteStore store = new ByteStore();

    byte[] dummy = {0};
    byte[] input = {};
    int b = 0;

    assertEquals(-1, store.read(dummy, 0, 1));
    assertEquals(-1, store.write(dummy, 0, 1));
    store.reset(true);
    assertEquals(-1, store.read(dummy, 0, 1));

    assertEquals(0, store.write(input, 0, b));

    byte[] output = new byte[b];

    assertEquals(-1, store.read(dummy, 0, 1));
    store.reset(false);
    assertEquals(-1, store.write(dummy, 0, 1));

    assertEquals(0, store.read(output, 0, b));
    assertEquals(-1, store.read(dummy, 0, 1));
    assertArrayEquals(output, input);
  }


  @Test
  public void test_1() throws IOException {
    ByteStore store = new ByteStore();

    byte[] dummy = {0};
    byte[] input = "Hello World".getBytes();
    int b = input.length;

    assertEquals(-1, store.read(dummy, 0, 1));
    assertEquals(-1, store.write(dummy, 0, 1));
    store.reset(true);
    assertEquals(-1, store.read(dummy, 0, 1));

    for (int t = 0; t != b; ) {
      int d = store.write(input, t, b - t);
      assertTrue("out of write storage", d >= 0);
      t += d;
    }

    byte[] output = new byte[b];

    assertEquals(-1, store.read(dummy, 0, 1));
    store.reset(false);
    assertEquals(-1, store.write(dummy, 0, 1));

    for (int t = 0; t != b; ) {
      int d = store.read(output, t, b - t);
      assertTrue("out of read storage", d >= 0);
      t += d;
    }

    assertEquals(-1, store.read(dummy, 0, 1));
    assertArrayEquals(output, input);

    input = "Good bye".getBytes();
    b = input.length;

    assertEquals(-1, store.write(dummy, 0, 1));
    store.reset(true);
    assertEquals(-1, store.read(dummy, 0, 1));

    for (int t = 0; t != b; ) {
      int d = store.write(input, t, b - t);
      assertTrue("out of write storage", d >= 0);
      t += d;
    }

    output = new byte[b];

    assertEquals(-1, store.read(dummy, 0, 1));
    store.reset(false);
    assertEquals(-1, store.write(dummy, 0, 1));

    for (int t = 0; t != b; ) {
      int d = store.read(output, t, b - t);
      assertTrue("out of read storage", d >= 0);
      t += d;
    }

    assertEquals(-1, store.read(dummy, 0, 1));
    assertArrayEquals(output, input);
  }
}
