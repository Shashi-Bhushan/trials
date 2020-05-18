package in.shabhushan.cp_trials.ds.tree;

import static org.junit.Assert.*;

import in.shabhushan.cp_trials.ds.tree.DoubleLinear;
import org.junit.Test;


public class DoubleLinearTest {

    private static void testing(int actual, int expected) {
        assertEquals(expected, actual);
    }

    @Test
    public void test() {
        System.out.println("Fixed Tests dblLinear");
        testing(DoubleLinear.dblLinear(10), 22);
        testing(DoubleLinear.dblLinear(20), 57);
        testing(DoubleLinear.dblLinear(30), 91);
        testing(DoubleLinear.dblLinear(50), 175);

    }
}
