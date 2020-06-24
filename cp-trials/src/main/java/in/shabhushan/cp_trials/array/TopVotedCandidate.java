package in.shabhushan.cp_trials.array;

import java.util.*;

class TopVotedCandidate {

  // person to frequency map
  private Map<Integer, Integer> freq;
  // time to leader
  private TreeMap<Integer, Integer> count;

  public TopVotedCandidate(int[] persons, int[] times) {
    freq = new HashMap<>();
    count = new TreeMap<>();

    int maxFrequency = 0;
    int leader = persons[0];

    for (int i = 0; i < persons.length; i++) {
      freq.put(persons[i], freq.getOrDefault(persons[i], 0) + 1);

      int f = freq.get(persons[i]);

      if (f >= maxFrequency) {
        maxFrequency = f;

        if (leader != persons[i])
          leader = persons[i];
      }

      count.put(times[i], leader);
    }
  }

  public int q(int t) {
    return count.get(count.floorKey(t));
  }

  // person to frequency map
  private int[] topVoted;

  public TopVotedCandidate(int[] persons, int[] times, int toDistinguishFromPreviousConstructor) {
    topVoted = new int[times[times.length - 1] + 1];
    int[] votes = new int[persons.length];

    int leader = persons[0];

    for (int i = 0; i < persons.length; i++) {
      int person = persons[i];
      int time = times[i];

      votes[person]++;

      if (votes[leader] <= votes[person])
        leader = person;

      topVoted[time] = leader;

      // between last time and current time
      if (i > 0) {
        for (int j = times[i - 1] + 1; j < time; j++)  {
          topVoted[j] = topVoted[j - 1];
        }
      }
    }
  }

  public int q2(int t) {
    return t < topVoted.length ? topVoted[t] : topVoted[topVoted.length - 1];
  }
}

/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate obj = new TopVotedCandidate(persons, times);
 * int param_1 = obj.q(t);
 */
