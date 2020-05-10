package in.shabhushan.cp_trials.logic;

import java.util.ArrayList;
import java.util.List;

public class BalancedParens {

  public static List<String> balancedParens(int n) {
    List<String> result = new ArrayList<>();
    dfs(result, new StringBuilder(), 0, 0, n);
    return result;
  }

  private static void dfs(List<String> result, StringBuilder inter, int startBracket, int closeBracket, int maxBrackets) {
    if (closeBracket == maxBrackets) {
      result.add(inter.toString());
    } else {
      if (startBracket < maxBrackets) {
        inter.append("(");
        dfs(result, inter, startBracket + 1, closeBracket, maxBrackets);
        inter.deleteCharAt(inter.length() - 1);
      }

      if (closeBracket < startBracket) {
        inter.append(")");
        dfs(result, inter, startBracket, closeBracket + 1, maxBrackets);
        inter.deleteCharAt(inter.length() - 1);
      }
    }
  }
}
