package in.shabhushan.cp_trials.math.logic;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SumDigNthTest {

    private static void testing(long act, long exp) {
        assertEquals(exp, act);
    }

    @Test
    public void test1() {
        System.out.println("Basic Tests **** sumDigNthTerm");
        testing(SumDigNth.sumDigNthTerm(10, new long[]{2, 1, 3}, 6), 10);
        testing(SumDigNth.sumDigNthTerm(10, new long[]{2, 1, 3}, 15), 10);
        testing(SumDigNth.sumDigNthTerm(10, new long[]{2, 1, 3}, 50), 9);
        testing(SumDigNth.sumDigNthTerm(10, new long[]{2, 1, 3}, 78), 10);
        testing(SumDigNth.sumDigNthTerm(10, new long[]{2, 1, 3}, 157), 7);
    }
}
