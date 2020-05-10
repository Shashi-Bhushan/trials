package in.shabhushan.cp_trials.logic;

import java.util.regex.*;
import java.util.*;

public class ScreenLock {

  private final String LINES = "ABC,DEF,GHI,ADG,BEH,CFI,AEI,CEG";

  private static Map<Character, Integer> map = new HashMap<>();

  static {
    map.put('A', 0);
    map.put('B', 1);
    map.put('C', 2);
    map.put('D', 3);
    map.put('E', 4);
    map.put('F', 5);
    map.put('G', 6);
    map.put('H', 7);
    map.put('I', 8);
  }

  private boolean[] grid = new boolean[9];

  public int calculateCombinations(char startPosition, int patternLength){
    if (patternLength == 1) return 1;

    grid[map.get(startPosition)] = true;

    int totalCombinations = 0;
    for(char c = 'A'; c <= 'I'; c++) {
      if (!grid[map.get(c)] && isValidLine(startPosition, c)) {
        totalCombinations += calculateCombinations(c, patternLength - 1);
      }
    }
    grid[map.get(startPosition)] = false;

    return totalCombinations;
  }

  private boolean isValidLine(char startPosition, char point) {
    String pattern = startPosition < point ? startPosition + "(\\w)" + point : point + "(\\w)" + startPosition;
    Matcher matcher = Pattern.compile(pattern).matcher(LINES);
    return !matcher.find() || grid[map.get(matcher.group(1).charAt(0))];
  }
}
