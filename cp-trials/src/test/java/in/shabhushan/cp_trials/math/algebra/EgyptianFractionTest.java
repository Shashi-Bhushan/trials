package in.shabhushan.cp_trials.math.algebra;

import static in.shabhushan.cp_trials.math.algebra.EgyptianFraction.decompose;
import static org.junit.Assert.*;
import org.junit.Test;

public class EgyptianFractionTest {

    private static void testing(String actual, String expected) {
        assertEquals(expected, actual);
    }
    @Test
    public void test1() {
        testing(decompose("3", "4"), "[1/2, 1/4]");
        testing(decompose("12", "4"), "[3]");
        testing(decompose("0", "2"), "[]");
        testing(decompose("9", "10"), "[1/2, 1/3, 1/15]");
        testing(decompose("50", "4187"), "[1/84, 1/27055, 1/1359351420]");
        testing(decompose("989", "1000"), "[1/2, 1/3, 1/7, 1/79, 1/6610, 1/99690819, 1/12146761380509000]");
    }
}
