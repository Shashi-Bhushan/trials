package in.shabhushan.cp_trials.math.logic;

import org.junit.Test;

import static in.shabhushan.cp_trials.math.logic.BalancedNumber.balancedNum;
import static org.junit.Assert.assertEquals;

public class BalancedNumberTest {
    @Test
    public void Check_Balanced_Number()
    {
        assertEquals("Balanced", balancedNum(7));
        assertEquals("Balanced", balancedNum(17));
        assertEquals("Balanced", balancedNum(959));
        assertEquals("Balanced", balancedNum(13));
        assertEquals("Not Balanced", balancedNum(432));
        assertEquals("Balanced", balancedNum(424));
    }
    @Test
    public void Check_Larger_Number()
    {
        assertEquals("Not Balanced", balancedNum(1024));
        assertEquals("Not Balanced", balancedNum(66545));
        assertEquals("Not Balanced", balancedNum(295591));
        assertEquals("Not Balanced", balancedNum(1230987));
        assertEquals("Balanced", balancedNum(56239814));
    }
}
