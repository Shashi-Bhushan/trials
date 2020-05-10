package in.shabhushan.cp_trials.string;

import org.junit.Test;

import static in.shabhushan.cp_trials.string.ValidParentheses.checkValidString;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ValidParenthesesTest {
  @Test
  public void test() {
    assertTrue(checkValidString("()"));
    assertTrue(checkValidString("(*)"));
    assertTrue(checkValidString("(*))"));
    assertTrue(checkValidString("((*)"));
    assertTrue(checkValidString("()*)"));
    assertTrue(checkValidString("()(*"));
    assertFalse(checkValidString("(()"));
    assertFalse(checkValidString("(())((())()()(*)(*()(())())())()()((()())((()))(*"));
    assertFalse(checkValidString("**((*"));
  }
}
