package in.shabhushan.cp_trials.math.algebra;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SumDigPowerTest {

    private static void testing(long a, long b, long[] res) {
        assertEquals(Arrays.toString(res),
                Arrays.toString(SumDigPower.sumDigPow(a, b).toArray()));
    }

    @Test
    public void test() {
        System.out.println("Basic Tests");
        testing(1, 10, new long[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
        testing(1, 100, new long[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 89});
        testing(10, 100, new long[]{89});
        testing(90, 100, new long[]{});
        testing(90, 150, new long[]{135});
        testing(50, 150, new long[]{89, 135});
        testing(10, 150, new long[]{89, 135});
    }

    @Test
    public void testIsNumEqual() {
        assertTrue(SumDigPower.isNumEquals(89));
    }
}
