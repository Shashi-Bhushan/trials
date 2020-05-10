package in.shabhushan.cp_trials.math.algebra;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.assertEquals;

public class XbonacciTest {
    private Xbonacci variabonacci;

    @Before
    public void setUp() throws Exception {
        variabonacci = new Xbonacci();
    }

    @After
    public void tearDown() throws Exception {
        variabonacci = null;
    }

    @Test
    public void basicTests() {
        assertArrayEquals(new double[]{0, 1, 1, 2, 3, 5, 8, 13, 21, 34}, variabonacci.xbonacci(new double[]{0, 1}, 10));
        assertArrayEquals(new double[]{1, 1, 2, 3, 5, 8, 13, 21, 34, 55}, variabonacci.xbonacci(new double[]{1, 1}, 10));
        assertArrayEquals(new double[]{0, 0, 0, 0, 1, 1, 2, 4, 8, 16}, variabonacci.xbonacci(new double[]{0, 0, 0, 0, 1}, 10));
        assertArrayEquals(new double[]{1, 0, 0, 0, 0, 0, 1, 2, 3, 6}, variabonacci.xbonacci(new double[]{1, 0, 0, 0, 0, 0, 1}, 10));
    }

    @Test
    public void advancedTests() {
        assertArrayEquals(new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0},
                variabonacci.xbonacci(new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0}, 20));

        assertArrayEquals(new double[]{1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0},
                variabonacci.xbonacci(new double[]{1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 0.0}, 9));

        assertArrayEquals(new double[]{1.0, 0.0, 3.0, 4.0, 2.0, 20.0, 20.0, 5.0, 3.0, 12.0, 13.0, 3.0, 86.0, 171.0, 342.0, 681.0, 1358.0, 2714.0, 5408.0, 10796.0, 21587.0, 43171.0, 86330.0, 172647.0, 345291.0, 690496.0, 1380821.0, 2761300.0, 5521919.0, 1.104248E7, 2.2082246E7, 4.4159084E7, 8.8307372E7, 1.76593157E8, 3.53143143E8, 7.06199956E8, 1.412227265E9, 2.824109239E9, 5.647527982E9, 1.1293675143E10, 2.2584588986E10, 4.5163656053E10, 9.0316269626E10, 1.80610457006E11, 3.61176754928E11, 7.22265202484E11, 1.444353811811E12, 2.888354480479E12, 5.776002761002E12, 1.1550593294739E13, 2.3098362480239E13, 4.6191077432496E13, 9.2370861189849E13, 1.84719137790712E14, 3.69393111925371E14, 7.38695907581116E14, 1.477211204705226E15, 2.954061232655524E15, 5.907400200108564E15, 1.1813356046405316E16, 2.3623823738330152E16, 4.7241871473899304E16},
                variabonacci.xbonacci(new double[]{1.0, 0.0, 3.0, 4.0, 2.0, 20.0, 20.0, 5.0, 3.0, 12.0, 13.0, 3.0}, 62));
    }

    private void assertArrayEquals(double[] expecteds, double[] actuals) {
        for (int i = 0; i < actuals.length; i++)
            assertEquals(expecteds[i], actuals[i], 1e-10);
    }
}
