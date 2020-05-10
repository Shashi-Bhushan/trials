package in.shabhushan.cp_trials.logic;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

// TODO: Replace examples and use TDD development by writing your own tests

public class TCPFiniteStateMachineTest {

  @Test
  public void SampleTests() {
    assertEquals("CLOSE_WAIT", TCPFiniteStateMachine.traverseStates(new String[]{"APP_ACTIVE_OPEN", "RCV_SYN_ACK", "RCV_FIN"}));
    assertEquals("ESTABLISHED", TCPFiniteStateMachine.traverseStates(new String[]{"APP_PASSIVE_OPEN", "RCV_SYN", "RCV_ACK"}));
    assertEquals("LAST_ACK", TCPFiniteStateMachine.traverseStates(new String[]{"APP_ACTIVE_OPEN", "RCV_SYN_ACK", "RCV_FIN", "APP_CLOSE"}));
    assertEquals("SYN_SENT", TCPFiniteStateMachine.traverseStates(new String[]{"APP_ACTIVE_OPEN"}));
    assertEquals("ERROR", TCPFiniteStateMachine.traverseStates(new String[]{"APP_PASSIVE_OPEN", "RCV_SYN", "RCV_ACK", "APP_CLOSE", "APP_SEND"}));
  }
}
