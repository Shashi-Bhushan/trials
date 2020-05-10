package in.shabhushan.cp_trials.math.logic;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TwoCubeSumTest {

    @Test
    public void test1() {
        assertEquals(false, TwoCubeSum.hasTwoCubeSums(1));
    }

    @Test
    public void test2() {
        assertEquals(true, TwoCubeSum.hasTwoCubeSums(1729));
    }

    @Test
    public void test3() {
        assertEquals(false, TwoCubeSum.hasTwoCubeSums(42));
    }

    @Test
    public void test4() {
        assertEquals(true, TwoCubeSum.hasTwoCubeSums(4104));
    }

    @Test
    public void test5() {
        assertEquals(false, TwoCubeSum.hasTwoCubeSums(4105));
    }
}
