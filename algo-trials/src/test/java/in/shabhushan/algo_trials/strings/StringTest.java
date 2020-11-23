package in.shabhushan.algo_trials.strings;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class StringTest {
  @Test
  public void testUTF8Chars() throws UnsupportedEncodingException {
    // Working example, since it's UTF-8 character
//    byte[] b = "\u000B".getBytes(StandardCharsets.UTF_16);
//
    System.out.println(new String("\u007b\u007d"));

    String \u006E = "This is strange looking variable name";

    System.out.println(n);

    String str = "\u0F0F";

    // or try with ABC༏汉
    byte[] bytes = str.getBytes(StandardCharsets.UTF_16);

    System.out.println("Bytes :: " + Arrays.toString(bytes));
    //assertNotEquals(str, new String(bytes));

   // assertEquals(str, new String(bytes, StandardCharsets.UTF_8));

    byte[] encoding1 = "你好吗".getBytes("UTF-8");
    String string1 = new String(encoding1, "ISO8859-1");
    for (byte b : encoding1) {
      System.out.printf("%2x ", b);
    }
    System.out.println();
    byte[] encoding2 = string1.getBytes("UTF-8");
    for (byte b : encoding2) {
      System.out.printf("%2x ", b);
    }
    System.out.println();
  }
}
