package in.shabhushan.cp_trials.sweepline;

import java.util.*;

/**
 * Given an array of start event time and end event time, deduce the maximum number of events
 * you could accommodate. You could process only one event at a time.
 */
public class SchedulingEvents {

  private static class Interval implements Comparable<Interval> {
    int start;
    int end;

    public Interval(int start, int end) {
      this.start = start;
      this.end = end;
    }

    @Override
    public int compareTo(Interval interval) {
      if (interval.end != this.end) {
        return this.end - interval.end;
      } else {
        // if both ending at same time, choose one with less time interval
        return (this.end - this.start) - (interval.end - interval.start);
      }
    }
  }

  /**
   * We could not select the minimum interval possible. Check Second example in test case
   * We also could not select using start time. Check Third Example for this test case.
   *
   * We need to sort by the ending interval. Always select the next possible event that ends ASAP.
   */
  public static int maxEvents(int[][] intervals) {
    List<Interval> list = new ArrayList<>();

    for (int[] interval: intervals) {
      list.add(new Interval(interval[0], interval[1]));
    }

    Collections.sort(list);

    int ans = 1;
    int currentEnd = list.get(0).end;

    for (int i = 1; i < list.size(); i++) {
      Interval currentInterval = list.get(i);

      if (currentEnd <= currentInterval.start) {
        // choose start from this interval
        currentEnd = currentInterval.end;
        ans++;
      }
    }
    return ans;
  }
}
