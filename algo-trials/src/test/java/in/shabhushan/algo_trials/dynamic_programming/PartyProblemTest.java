package in.shabhushan.algo_trials.dynamic_programming;

import org.junit.Ignore;
import org.junit.Test;

import java.util.List;

import static in.shabhushan.algo_trials.dynamic_programming.PartyProblem.getPartyProblem;
import static in.shabhushan.algo_trials.dynamic_programming.PartyProblem.getPartyProblemList;
import static org.junit.Assert.assertEquals;

public class PartyProblemTest {
  @Test
  public void testPartyProblem() {
    assertEquals(1, getPartyProblem(1));
    assertEquals(2, getPartyProblem(2));
    assertEquals(4, getPartyProblem(3));
    assertEquals(10, getPartyProblem(4));
  }

  @Ignore
  @Test
  public void testPartyProblemTest() {
    List<List<Integer>> list = getPartyProblemList(4);
    int size = list.size();
    assertEquals(8, size);

    assertEquals(List.of(

    ), list);
  }
}
