package in.shabhushan.cp_trials.math.euler;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class P119PowerSumDigTest {

    private static void testing(long act, long exp) {
        assertEquals(exp, act);
    }

    @Test
    public void test1() {
        testing(P119PowerSumDig.powerSumDigTerm(1), 81);
        testing(P119PowerSumDig.powerSumDigTerm(2), 512);
        testing(P119PowerSumDig.powerSumDigTerm(3), 2401);
        testing(P119PowerSumDig.powerSumDigTerm(4), 4913);
    }
}
