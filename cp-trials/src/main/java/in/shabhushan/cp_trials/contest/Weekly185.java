package in.shabhushan.cp_trials.contest;

import java.util.*;

public class Weekly185 {
  /**
   * Leetcode solution for https://leetcode.com/contest/weekly-contest-185/problems/minimum-number-of-frogs-croaking/
   * @param croakOfFrogs
   * @return
   */
  public static int minNumberOfFrogs(String croakOfFrogs) {
    String croak = "croak";
    int[] f = new int[6];

    for (int i = 0; i < croakOfFrogs.length(); i++) {
      int c = croak.indexOf(croakOfFrogs.charAt(i));

      // start of String
      if (c == 0) {
        // first character, increment it
        f[1]++;

        if (f[5] > 0) // new frog, so decrement by 1
          f[5]--;
      } else {
        if (f[c] == 0) return -1;

        f[c]--;
        f[c + 1]++;
      }
    }

    for (int i = 0; i < f.length - 1; i++) {
      if (f[i] != 0)
        return -1; // there is atleast 1 frog that didn't finished croak
    }

    return f[5];
  }

  public static int minNumberOfFrogs2(String croakOfFrogs) {
    char[] s = croakOfFrogs.toCharArray();
    String C = "croak";
    int[] f = new int[6];
    for (char c : s) {
      int ind = C.indexOf(c);
      if (ind > 0) {
        if (f[ind] == 0) return -1;
        f[ind]--;
        f[ind + 1]++;
      } else {
        if (f[5] > 0) {
          f[5]--;
        }
        f[1]++;
      }
    }
    for (int i = 1; i < 5; i++) {
      if (f[i] > 0) return -1;
    }
    return f[5];
  }

  public String getHappyString(int n, int k) {
    List<String> s = new ArrayList<>();
    s.addAll(generateStrings("a", n));
    s.addAll(generateStrings("b", n));
    s.addAll(generateStrings("c", n));

    return s.get(k - 1);
  }

  /**
   * Leetcode solution for
   * https://leetcode.com/contest/biweekly-contest-24/problems/the-k-th-lexicographical-string-of-all-happy-strings-of-length-n/
   */
  private List<String> generateStrings(String currentString, int total) {
    if (currentString.length() == total) {
      List<String> l = new ArrayList<String>();
      l.add(currentString);

      return l;
    }

    char c = currentString.charAt(currentString.length() - 1);
    List<String> l = new ArrayList<>();

    switch (c) {
      case 'a': {
        l.addAll(generateStrings(currentString + 'b', total));
        l.addAll(generateStrings(currentString + 'c', total));
        break;
      }
      case 'b': {
        l.addAll(generateStrings(currentString + 'a', total));
        l.addAll(generateStrings(currentString + 'c', total));
        break;
      }
      case 'c': {
        l.addAll(generateStrings(currentString + 'a', total));
        l.addAll(generateStrings(currentString + 'b', total));
      }
    }

    return l;
  }

  public String reformat(String s) {
    char[] answer = new char[s.length()];

    int cl = 0, dl = 0;

    for (int i = 0; i < s.length(); i++) {
      if (Character.isLetter(s.charAt(i))) cl++;
      else dl++;
    }

    if (1 < Math.abs(cl - dl)) return "";

    if (cl == dl) {
      int c = 0;
      int d = 0;

      for (int i = 0; i < s.length(); ) {
        while (c < s.length() && !Character.isLetter(s.charAt(c))) c++;
        while (d < s.length() && !Character.isDigit(s.charAt(d))) d++;

        answer[i] = s.charAt(c++);
        answer[i + 1] = s.charAt(d++);
        i += 2;
      }

      return new String(answer);
    } else if (cl < dl) {
      int c = 0;
      int d = 0;

      for (int i = 0; i < s.length(); ) {
        while (c < s.length() && !Character.isLetter(s.charAt(c))) c++;
        while (d < s.length() && !Character.isDigit(s.charAt(d))) d++;

        if (c < s.length()) {
          answer[i] = s.charAt(d++);
          answer[i + 1] = s.charAt(c++);

          i += 2;
        } else {
          answer[i] = s.charAt(d++);
          i++;
        }
      }

      return new String(answer);
    } else {
      int c = 0;
      int d = 0;

      for (int i = 0; i < s.length(); ) {
        while (c < s.length() && !Character.isLetter(s.charAt(c))) c++;
        while (d < s.length() && !Character.isDigit(s.charAt(d))) d++;

        if (d < s.length()) {
          answer[i] = s.charAt(c++);
          answer[i + 1] = s.charAt(d++);

          i += 2;
        } else {
          answer[i] = s.charAt(c++);
          i++;
        }
      }

      return new String(answer);
    }
  }

  public List<List<String>> displayTable(List<List<String>> orders) {
    Set<String> items = new TreeSet<>();

    for (List<String> l : orders) {
      items.add(l.get(2));
    }

    // Map<TableNo, Map<Item, Count>>
    Map<Integer, Map<String, Integer>> map = new TreeMap<>();

    for (List<String> l : orders) {
      items.add(l.get(2));

      String tableNo = l.get(1);

      if (!map.containsKey(tableNo)) {
        map.put(Integer.parseInt(tableNo), new HashMap<String, Integer>());
      }

      Map<String, Integer> tableItems = map.get(tableNo);

      if (!tableItems.containsKey(l.get(2))) {
        tableItems.put(l.get(2), 1);
      } else {
        tableItems.put(l.get(2), tableItems.get(l.get(2)) + 1);
      }
    }

    List<List<String>> answer = new ArrayList<>();
    List<String> first = new ArrayList<>();
    first.add("Table");
    first.addAll(items);

    answer.add(first);

    for (Map.Entry<Integer, Map<String, Integer>> m : map.entrySet()) {
      List<String> l = new ArrayList<>();
      l.add(String.valueOf(m.getKey()));

      items.forEach(item -> {
        if (m.getValue().containsKey(item))
          l.add(String.valueOf(m.getValue().get(item)));
        else
          l.add("0");
      });

      answer.add(l);
    }

    return answer;
  }
}
