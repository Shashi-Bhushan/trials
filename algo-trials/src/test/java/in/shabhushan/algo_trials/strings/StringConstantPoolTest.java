package in.shabhushan.algo_trials.strings;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class StringConstantPoolTest {
  @Test
  public void testStringConcatenations() {
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

    final String j = "You can".concat(" not");
    String k = j + " change me";
    assertFalse(k == c); // final reference itself is resolved at runtime, Java doesn't know it's value at compile time
  }

  @Test
  public void testStringRuntimeOperations() {
    String a = new String("shashi");

    String b = a.toLowerCase();

    String c = "shashi";

    assertTrue(a == b); // Runtime operation, will point to heap

    assertFalse(b == c); // heap != StringLiteralPool
    assertFalse(a == c); // c is in StringLiteralPool
  }

  @Test
  public void testStringRuntimeOperations2() {
    String a = "shashi";

    String b = a.toString();

    String c = a.toLowerCase();

    String d = a.toUpperCase();

    assertTrue(a == b); // toString() returns this

    assertTrue(a == c); // both pointing to same object in StringLiteralPool

    assertFalse(a == d); // Both different objects in StringLiteralPool

    System.out.println(new StringBuilder("abcdef").capacity());
  }
}
