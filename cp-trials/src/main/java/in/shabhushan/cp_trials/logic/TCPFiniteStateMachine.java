package in.shabhushan.cp_trials.logic;

import java.util.Map;

import static java.util.Map.entry;

public class TCPFiniteStateMachine {

  private enum State {
    CLOSED, LISTEN, SYN_SENT, SYN_RCVD, ESTABLISHED, CLOSE_WAIT, LAST_ACK, FIN_WAIT_1, FIN_WAIT_2, CLOSING, TIME_WAIT;

    public static Map<String, State> map = Map.ofEntries(
        entry("CLOSED", CLOSED),
        entry("LISTEN", LISTEN),
        entry("SYN_SENT", SYN_SENT),
        entry("SYN_RCVD", SYN_RCVD),
        entry("ESTABLISHED", ESTABLISHED),
        entry("CLOSE_WAIT", CLOSE_WAIT),
        entry("LAST_ACK", LAST_ACK),
        entry("FIN_WAIT_1", FIN_WAIT_1),
        entry("FIN_WAIT_2", FIN_WAIT_2),
        entry("CLOSING", CLOSING),
        entry("TIME_WAIT", TIME_WAIT)
    );
    }

  private enum Event {
    APP_PASSIVE_OPEN, APP_ACTIVE_OPEN, APP_SEND, APP_CLOSE, APP_TIMEOUT, RCV_SYN, RCV_ACK, RCV_SYN_ACK, RCV_FIN, RCV_FIN_ACK;

    public static Map<String, Event> map = Map.ofEntries(
        entry("APP_PASSIVE_OPEN", APP_PASSIVE_OPEN),
        entry("APP_ACTIVE_OPEN", APP_ACTIVE_OPEN),
        entry("APP_SEND", APP_SEND),
        entry("APP_CLOSE", APP_CLOSE),
        entry("APP_TIMEOUT", APP_TIMEOUT),
        entry("RCV_SYN", RCV_SYN),
        entry("RCV_ACK", RCV_ACK),
        entry("RCV_SYN_ACK", RCV_SYN_ACK),
        entry("RCV_FIN", RCV_FIN),
        entry("RCV_FIN_ACK", RCV_FIN_ACK)
    );
  }

  private static Map<State, Map<Event, State>> statesTransitionMap = Map.ofEntries(
      entry(
          State.CLOSED, Map.of(
              Event.APP_PASSIVE_OPEN, State.LISTEN,
              Event.APP_ACTIVE_OPEN, State.SYN_SENT
          )
      ),
      entry(
          State.LISTEN, Map.of(
              Event.RCV_SYN, State.SYN_RCVD,
              Event.APP_SEND, State.SYN_SENT,
              Event.APP_CLOSE, State.CLOSED
          )
      ),

      entry(State.SYN_RCVD, Map.of(
          Event.APP_CLOSE, State.FIN_WAIT_1,
          Event.RCV_ACK, State.ESTABLISHED
      )),

      entry(State.SYN_SENT, Map.of(
          Event.RCV_SYN, State.SYN_RCVD,
          Event.RCV_SYN_ACK, State.ESTABLISHED,
          Event.APP_CLOSE, State.CLOSED
      )),

      entry(State.ESTABLISHED, Map.of(
          Event.APP_CLOSE, State.FIN_WAIT_1,
          Event.RCV_FIN, State.CLOSE_WAIT
      )),

      entry(State.FIN_WAIT_1, Map.of(
          Event.RCV_FIN, State.CLOSING,
          Event.RCV_FIN_ACK, State.TIME_WAIT,
          Event.RCV_ACK, State.FIN_WAIT_2
      )),

      entry(State.CLOSING, Map.of(
          Event.RCV_ACK, State.TIME_WAIT
      )),

      entry(State.FIN_WAIT_2, Map.of(
          Event.RCV_FIN, State.TIME_WAIT
      )),

      entry(State.TIME_WAIT, Map.of(
          Event.APP_TIMEOUT, State.CLOSED
      )),

      entry(State.CLOSE_WAIT, Map.of(
          Event.APP_CLOSE, State.LAST_ACK
      )),

      entry(State.LAST_ACK, Map.of(
          Event.RCV_ACK, State.CLOSED
          )
      )
  );

  public static String traverseStates(String[] events) {
    State state = State.CLOSED;

    for (String event : events) {
      Map<Event, State> m = statesTransitionMap.get(state);
      Event e = Event.map.get(event);

      if (m.containsKey(e))
        state = m.get(e);
      else
        return "ERROR";
    }

    return state.toString();
  }
}
