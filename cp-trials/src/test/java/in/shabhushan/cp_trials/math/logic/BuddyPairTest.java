package in.shabhushan.cp_trials.math.logic;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BuddyPairTest {

    private static void testing(long start, long limit, String expected) {
        System.out.println("start: " + start);
        System.out.println("limit: " + limit);
        String actual = BuddyPair.buddy(start, limit);
        System.out.println("Expect: " + expected);
        assertEquals(expected, actual);
    }

    @Test
    public void test() {
        testing(1071625, 1103735, "(1081184 1331967)");
        testing(2382, 3679, "Nothing");
        testing(381, 4318, "(1050 1925)");
    }
}
