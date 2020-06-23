package in.shabhushan.cp_trials.string;

import java.util.*;

/**
 * Leetcode solution for
 * https://leetcode.com/problems/top-k-frequent-words/
 */
class TopKFrequentStrings {
  public List<String> topKFrequent(String[] words, int k) {
    Map<String, Integer> map = new HashMap<>();

    for (String word: words) {
      map.put(word, map.getOrDefault(word, 0) + 1);
    }

    List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(map.entrySet());

    Collections.sort(list, (a, b) -> {
      if (b.getValue() != a.getValue())
        return b.getValue().compareTo(a.getValue());
      else
        return a.getKey().compareTo(b.getKey());
    });

    List<String> answer = new ArrayList<>();

    for(int i = 0; i < k; i++)
        answer.add(list.get(i).getKey());
    return answer;
  }
}
