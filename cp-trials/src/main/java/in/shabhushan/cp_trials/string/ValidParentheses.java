package in.shabhushan.cp_trials.string;

import java.util.*;

/**
 * Leetcode solution for
 * https://leetcode.com/problems/valid-parenthesis-string/solution/
 */
class ValidParentheses {
  private static class Point {
    int position;
    char character;

    public Point(int position, char character) {
      this.position = position;
      this.character = character;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (!(o instanceof Point)) return false;
      Point point = (Point) o;
      return position == point.position &&
          character == point.character;
    }

    @Override
    public int hashCode() {
      return Objects.hash(position, character);
    }
  }

  public static boolean checkValidString(String s) {
    Stack<Integer> startParenthesis = new Stack<>();
    Stack<Integer> stars = new Stack<>();

    char[] chars = s.toCharArray();

    // For each ( or *, check if there are corresponding )
    for (int index = 0; index < chars.length; index++) {
      if (chars[index] == '(')
        startParenthesis.push(index);
      else if (chars[index] == '*')
        stars.push(index);
      else { // if (chars[index] == ')')
        if (!startParenthesis.isEmpty())
          startParenthesis.pop();
        else if (!stars.isEmpty())
          stars.pop();
        else
          return false;
      }
    }

    while (!startParenthesis.isEmpty()) {
      // if no stars left, there's nothing to match with this '('
      if (stars.isEmpty())
        return false;

      int parenPosition = startParenthesis.pop();
      int starPosition = stars.pop();

      if (starPosition < parenPosition)
        return false;
    }

    return startParenthesis.isEmpty() && 0 <= stars.size();
  }
}
