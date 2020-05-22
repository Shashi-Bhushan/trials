package in.shabhushan.cp_trials.sweepline;

import java.util.*;

class RightInterval {

  private static class Interval implements Comparable<Interval> {
    // value of interval
    int point;
    // whether the Interval denotes start or end position
    int start;
    // the position (index) of interval in array
    int position;

    public Interval(int point, int start, int position) {
      this.point = point;
      this.start = start;
      this.position = position;
    }

    @Override
    public int compareTo(Interval anotherInterval) {
      // First sort by smaller point,
      // if two points are equal, then end before start

      if (this.point != anotherInterval.point) {
        return this.point - anotherInterval.point;
      } else {
        return this.start - anotherInterval.start;
      }
    }
  }

  public static int[] findRightInterval(int[][] intervals) {

    List<Interval> list = new ArrayList<>();

    int i = 0;
    for (int[] interval : intervals) {
      list.add(new Interval(interval[0], 1, i));
      list.add(new Interval(interval[1], 0, i));
      i++;
    }

    Collections.sort(list);

    int[] ans = new int[intervals.length];
    Arrays.fill(ans, -1);
    List<Integer> prevIndex = new ArrayList<>();
    for (Interval interval : list) {
      if (interval.start == 1) {
        for (int prev : prevIndex) {
          ans[prev] = interval.position;
        }

        prevIndex = new ArrayList<>();
      } else {
        prevIndex.add(interval.position);
      }
    }

    return ans;
  }
}
