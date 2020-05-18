package in.shabhushan.cp_trials.bytes;

import in.shabhushan.cp_trials.logic.bytes.ByteStream;
import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class ByteStreamTest {

  @Ignore
  @Test
  public void test_0() throws IOException {
    ByteStream stream = new ByteStream();
    try {
      stream.write((byte) 0);
      fail("exception expected");
    } catch (IOException ignored) {
    }
    try {
      stream.read();
      fail("exception expected");
    } catch (IOException ignored) {
    }

    stream.flip();
    try {
      stream.read();
      fail("exception expected");
    } catch (IOException ignored) {
    }
    // write nothing

    stream.flip();
    try {
      stream.write((byte) 0);
      fail("exception expected");
    } catch (IOException ignored) {
    }
    assertEquals(-1, stream.read());
    assertEquals(-1, stream.read());

    stream.flip();
    try {
      stream.read();
      fail("exception expected");
    } catch (IOException ignored) {
    }
    stream.write((byte) 0);

    stream.flip();
    try {
      stream.write((byte) 0);
      fail("exception expected");
    } catch (IOException ignored) {
    }
    assertEquals(0, stream.read());
    assertEquals(-1, stream.read());
    assertEquals(-1, stream.read());
  }

  @Ignore
  @Test
  public void test_1() throws IOException {
    ByteStream stream = new ByteStream();

    byte[] input = "Hello World".getBytes();
    int b = input.length;

    stream.flip();
    for (int j = 0; j < b; j++) {
      stream.write(input[j]);
    }

    byte[] output = new byte[b];

    stream.flip();
    for (int j = 0; j < b; j++) {
      int d = stream.read();
      assertTrue("out of read storage", d >= 0);
      output[j] = (byte) d;
    }

    assertEquals(-1, stream.read());
    assertArrayEquals(input, output);

    input = "Good bye".getBytes();
    b = input.length;

    stream.flip();
    for (int j = 0; j < b; j++) {
      stream.write(input[j]);
    }

    output = new byte[b];

    stream.flip();
    for (int j = 0; j < b; j++) {
      int d = stream.read();
      assertTrue("out of read storage", d >= 0);
      output[j] = (byte) d;
    }

    assertEquals(-1, stream.read());
    assertArrayEquals(output, input);
  }
}
