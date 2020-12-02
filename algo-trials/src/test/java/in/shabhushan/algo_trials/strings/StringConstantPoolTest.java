package in.shabhushan.algo_trials.strings;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class StringConstantPoolTest {
  @Test
  public void testStringBuilder() {
    String a = new String("You can not change me");
    String b = new String("You can not change me");

    assertFalse(a == b);

    String c = "You can not change me";
    assertFalse(c == b);

    String d = "You can not change me";
    assertTrue(c == d); // String Constant Pool

    String e = "You can not " + "change me";
    assertTrue(e == d); // String Literals, resolved at compile time

    String f = "You can not";
    String g = f + " change me";
    assertFalse(g == c); // reference + Literal, resolved at compile time

    final String h = "You can not";
    String i = h + " change me";
    assertTrue(i == c); // final reference, replaced at compile time
  }
}
