package in.shabhushan.cp_trials.google_interview;

import java.util.*;

/**
 * Given a Set of airports and List of routes from and to airport
 * Give the minimum number of Routes you would need to add from a starting airport to give route to all the other airports in the network.
 */
public class AirportRoutes {
  public static int totalRoutes(Set<String> airports, List<String[]> availableRoutes, String sourceAirport) {
    Map<String, Integer> map = new HashMap<>();

    int i = 0;
    for (String airport: airports) {
      map.put(airport, i++);
    }

    List<Integer> l = new ArrayList<>(10000);

    for (String[] route: availableRoutes) {
      l.add(map.get(route[0]), map.get(route[1]));
    }

    return 0;
  }

  private static String existsInValues(Map<String, Set<String>> m, String route) {
    for (String s: m.keySet()) {
      if (m.get(s).contains(route))
        return s;
    }

    return null;
  }
}
