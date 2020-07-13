package in.shabhushan.cp_trials.stack;

import org.junit.Test;

import static in.shabhushan.cp_trials.stack.TowerofHanoi.towerOfHanoi;

public class TowerofHanoiTest {
  @Test
  public void testTowerOfHanoi() {
    towerOfHanoi(4, "A", "B", "C");
  }

}
