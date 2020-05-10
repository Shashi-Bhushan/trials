package in.shabhushan.cp_trials.math.logic;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class CountPositivesSumNegativesTest {
    @Test
    public void countPositivesSumNegatives_BasicTest() {
        int[] expectedResult = new int[]{10, -65};
        assertArrayEquals(expectedResult, CountPositivesSumNegatives.countPositivesSumNegatives(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -11, -12, -13, -14, -15}));
    }

    @Test
    public void countPositivesSumNegatives_InputWithZeroes() {
        int[] expectedResult = new int[]{8, -50};
        assertArrayEquals(expectedResult, CountPositivesSumNegatives.countPositivesSumNegatives(new int[]{0, 2, 3, 0, 5, 6, 7, 8, 9, 10, -11, -12, -13, -14}));
    }
}
