package in.shabhushan.cp_trials.math.logic;

import org.junit.Test;

import static in.shabhushan.cp_trials.math.logic.ExtraPerfectNumber.binary;
import static in.shabhushan.cp_trials.math.logic.ExtraPerfectNumber.extraPerfect;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class ExtraPerfectNumberTest {
    @Test
    public void Check_Small_Positive_Values()
    {
        assertArrayEquals(new int[]{1,3},     extraPerfect(3));
        assertArrayEquals(new int[]{1,3,5},   extraPerfect(5));
        assertArrayEquals(new int[]{1,3,5,7}, extraPerfect(8));
    }

    @Test
    public void Check_Larger_Positive_Values()
    {
        assertArrayEquals(new int[]{1,3,5,7,9,11,13,15,17,19,21,23,25,27}, extraPerfect(28));
        assertArrayEquals(new int[]{1,3,5,7,9,11,13,15,17,19,21,23,25,27,29,31,33,35,37,39}, extraPerfect(39));
    }

    @Test
    public void testBinary() {
        assertEquals("110", binary(6));
    }
}
