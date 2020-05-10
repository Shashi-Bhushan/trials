package in.shabhushan.cp_trials.math.logic;

import org.junit.Test;

import static in.shabhushan.cp_trials.math.logic.DisariumNumber.disariumNumber;
import static org.junit.Assert.assertEquals;

public class DisariumNumberTest
{
    @Test
    public void Disarium_Or_NOT()
    {
        assertEquals("Disarium !!", disariumNumber(89));
        assertEquals("Not !!", disariumNumber(564));
        assertEquals("Not !!", disariumNumber(1024));
    }
    @Test
    public void Larger_Numbers()
    {
        assertEquals("Not !!", disariumNumber(64599));
        assertEquals("Not !!", disariumNumber(136586));
        assertEquals("Not !!", disariumNumber(1048576));
    }
}
