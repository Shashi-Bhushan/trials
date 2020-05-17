package in.shabhushan.cp_trials.contest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Weekly189 {
  /**
   * Leetcode solution for
   */
  public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
    List<Set<String>> listSet = new ArrayList<>();

    for (List<String> list : favoriteCompanies) {
      listSet.add(new HashSet<String>(list));
    }

    List<Integer> answer = new ArrayList<>();

    outer:
    for (int i = 0; i < favoriteCompanies.size(); i++) {

      inner:
      for (int j = 0; j < favoriteCompanies.size(); j++) {
        if (i == j)
          continue;

        // check for all strings in set i
        for (String string: favoriteCompanies.get(i)) {
          // if all names are there, it will break through inner loop
          if (!listSet.get(j).contains(string))
            continue inner;
        }

        continue outer;
      }

      answer.add(i);
    }

    return answer;
  }


}
