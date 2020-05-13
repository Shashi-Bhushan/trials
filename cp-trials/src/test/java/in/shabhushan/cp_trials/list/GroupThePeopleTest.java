package in.shabhushan.cp_trials.list;

import org.junit.Test;

import java.util.List;

import static in.shabhushan.cp_trials.list.GroupThePeople.groupThePeople;
import static in.shabhushan.cp_trials.list.GroupThePeople.groupThePeople2;
import static org.junit.Assert.assertEquals;

public class GroupThePeopleTest {
  @Test
  public void testGroupThePeople() {
    List<List<Integer>> answer = groupThePeople(new int[]{3, 3, 3, 3, 3, 1, 3});
    assertEquals(List.of(List.of(5), List.of(0, 1, 2), List.of(3, 4, 6)), answer);
  }

  @Test
  public void testGroupThePeople2() {
    List<List<Integer>> answer = groupThePeople2(new int[]{3, 3, 3, 3, 3, 1, 3});
    assertEquals(List.of(List.of(0, 1, 2), List.of(5), List.of(3, 4, 6)), answer);
  }
}
