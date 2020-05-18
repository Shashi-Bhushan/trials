package in.shabhushan.cp_trials.dynamic_programming;

public class LongestCommonSubsequence {
  public static String lcs(String x, String y) {
    if (x.isBlank() || y.isBlank())
      return "";

    // for the fourth test case, the result would become apq intermittently,
    // that's why there is result.length() > maxResult.length() condition
    // when for loop moves forward and get a 'c' in both, there it will find longer substring
    String maxResult = "";
    String result = "";

    for(int i = 0; i < x.length(); i++) {
      int index = y.indexOf(x.charAt(i));

      if (index >= 0)
        result = x.charAt(i) + lcs(x.substring(i + 1), y.substring(index + 1));

      if (result.length() > maxResult.length())
        maxResult = result;
    }

    return maxResult;
  }
}
