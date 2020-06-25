package in.shabhushan.cp_trials.stack;

import java.util.*;

/**
 * Leetcode solution for
 * https://leetcode.com/problems/maximum-frequency-stack/submissions/
 */
class FreqStack {
  Map<Integer, Integer> freq;
  Map<Integer, Stack<Integer>> group;
  int maxfreq;


  public FreqStack() {
    freq = new HashMap<>();
    group = new HashMap<>();
    maxfreq = 0;
  }

  public void push(int x) {
    freq.put(x, freq.getOrDefault(x, 0) + 1);

    if (freq.get(x) > maxfreq) {
      maxfreq = freq.get(x);
    }

    if (!group.containsKey(freq.get(x))) {
      group.put(freq.get(x), new Stack<>());
    }

    group.get(freq.get(x)).push(x);
  }

  public int pop() {
    int x = group.get(maxfreq).pop();

    freq.put(x, freq.get(x) - 1);

    if (group.get(maxfreq).isEmpty())
      maxfreq--;

    return x;
  }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 */
