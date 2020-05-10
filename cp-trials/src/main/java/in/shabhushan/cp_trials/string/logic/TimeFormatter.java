package in.shabhushan.cp_trials.string.logic;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.joining;

public class TimeFormatter {

  private static final int YEAR = 31536000;
  private static final int DAY = 86400;
  private static final int HOUR = 3600;
  private static final int MINUTE = 60;

  public static String formatDuration(int seconds) {
      List<String> list = new ArrayList<>();

      if (seconds >= YEAR) {
        int years = seconds / YEAR;
        seconds = seconds % YEAR;

        if (years == 1) {
          list.add(String.format("%d year", years));
        } else {
          list.add(String.format("%d years", years));
        }
      }

      if (seconds >= DAY) {
        int day = seconds / DAY;
        seconds = seconds % DAY;

        if (day == 1) {
          list.add(String.format("%d day", day));
        } else {
          list.add(String.format("%d days", day));
        }
      }

      if (seconds >= HOUR) {
        int hour = seconds / HOUR;
        seconds = seconds % HOUR;

        if (hour == 1) {
          list.add(String.format("%d hour", hour));
        } else {
          list.add(String.format("%d hours", hour));
        }
      }

      if (seconds >= MINUTE) {
        int minute = seconds / MINUTE;
        seconds = seconds % MINUTE;

        if (minute == 1) {
          list.add(String.format("%d minute", minute));
        } else {
          list.add(String.format("%d minutes", minute));
        }
      }

      if (seconds == 1) {
          list.add(String.format("%d second", seconds));
        } else if (seconds != 0) {
          list.add(String.format("%d seconds", seconds));
      }

      String result = list.stream().collect(joining(", "));

    StringBuilder sb = new StringBuilder(result);
    int last = sb.lastIndexOf(",");
    if (last == -1)
      return sb.toString();
    else
      return sb.replace(last, last + 1, " and").toString();
  }
}
