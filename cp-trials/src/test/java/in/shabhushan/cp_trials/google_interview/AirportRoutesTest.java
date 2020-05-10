package in.shabhushan.cp_trials.google_interview;

import org.junit.Test;

import java.util.List;
import java.util.Set;

import static in.shabhushan.cp_trials.google_interview.AirportRoutes.totalRoutes;
import static org.junit.Assert.assertEquals;

public class AirportRoutesTest {
  @Test
  public void testAirportRoutes() {
    assertEquals(2,
        totalRoutes(Set.of("BGI", "CDG", "DEL", "DOH", "DSM", "EWR", "EYW", "HND",
            "ICN", "JFK", "LGA", "LHR", "ORD", "SAN", "SFO", "SIN", "TLV", "BUD"),
          List.of(
              new String[]{"DSM", "ORD"},
              new String[]{"ORD", "BGI"},
              new String[]{"BGI", "LGA"},
              new String[]{"SIN", "CDG"},
              new String[]{"CDG", "SIN"},
              new String[]{"CDG", "BUD"},
              new String[]{"DEL", "DOH"},
              new String[]{"DEL", "CDG"},
              new String[]{"TLV", "DEL"},
              new String[]{"EWR", "HND"},
            new String[]{"HND", "ICN"},
            new String[]{"HND", "JFK"},
            new String[]{"ICN", "JFK"},
            new String[]{"JFK", "LGA"},
            new String[]{"EYW", "LHR"},
            new String[]{"LHR", "SFO"},
            new String[]{"SFO", "SAN"},
            new String[]{"SFO", "DSM"},
            new String[]{"SAN", "EYW"}
          ),
          "LGA"
      ));
  }
}
