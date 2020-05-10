package in.shabhushan.cp_trials;

import org.junit.Test;

import static in.shabhushan.cp_trials.XbonacciJava.fibonacci;
import static in.shabhushan.cp_trials.XbonacciJava.tribonacci;
import static org.junit.Assert.assertArrayEquals;

public class XbonacciJavaTest {
    private double precision = 1e-10;

    @Test
    public void basicTests() {
        assertArrayEquals(
                new double[]{ 1.0,1.0,1.0,3.0,5.0,9.0,17.0,31.0,57.0,105.0 },
                tribonacci(new double[]{1.0,1.0,1.0},10),
                precision
        );
        assertArrayEquals(
                new double[]{0.0,0.0,1.0,1.0,2.0,4.0,7.0,13.0,24.0,44.0},
                tribonacci(new double[]{0.0,0.0,1.0},10),
                precision
        );
        assertArrayEquals(
                new double[]{0.0,1.0,1.0,2.0,4.0,7.0,13.0,24.0,44.0,81.0},
                tribonacci(new double[]{0.0,1.0,1.0},10),
                precision
        );
    }

    @Test
    public void tribonacciLessThan3ElementsTest() {
        assertArrayEquals(new double[]{0.0}, tribonacci(new double[]{0.0},10), precision);
    }

    @Test
    public void tribonacciNIsLessThanSizeOfArray() {
        assertArrayEquals(new double[]{0.0}, tribonacci(new double[]{0.0, 1.0, 2.0},1), precision);
    }

    @Test
    public void basicFibonacciTest() {
        assertArrayEquals(
                new double[]{1.0, 1.0, 2.0, 3.0, 5.0},
                fibonacci(new double[]{1.0, 1.0}, 5),
                precision
        );
    }
}
