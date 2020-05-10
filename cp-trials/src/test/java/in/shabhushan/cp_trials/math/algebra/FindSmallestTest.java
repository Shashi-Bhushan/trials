package in.shabhushan.cp_trials.math.algebra;

import static in.shabhushan.cp_trials.math.algebra.FindSmallest.smallest;
import static org.junit.Assert.*;
import java.util.Arrays;

import org.junit.Ignore;
import org.junit.Test;

public class FindSmallestTest {

    private static void testing(long n, String res) {
        assertEquals(res,
                Arrays.toString(smallest(n)));
    }
    @Ignore
    @Test
    public void test() {
        System.out.println("Basic Tests smallest");
        testing(261235, "[126235, 2, 0]");
        testing(209917, "[29917, 0, 1]");
        testing(285365, "[238565, 3, 1]");
        testing(269045, "[26945, 3, 0]");
        testing(296837, "[239687, 4, 1]");
        testing(624543407134441600L, "[62454340713444160, 16, 0]");
        testing(199819884756L, "[119989884756, 4, 0]");
    }
}
