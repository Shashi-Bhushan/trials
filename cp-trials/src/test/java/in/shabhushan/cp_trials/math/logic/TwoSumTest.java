package in.shabhushan.cp_trials.math.logic;

import org.junit.Test;

import static org.junit.Assert.*;

public class TwoSumTest {
    @Test
    public void basicTests() {
        doTest(new int[]{1, 2, 3}, new int[]{0, 2});
        doTest(new int[]{3, 3}, new int[]{0, 1});
        doTest(new int[]{3, 2, 4}, new int[]{1, 2});
        doTest(new int[]{1234, 5678, 9012}, new int[]{1, 2});
        doTest(new int[]{2, 2, 3}, new int[]{0, 1});
        doTest(new int[]{22, 650, 864, 548, -953, -40, 584, 993, -878, 178, -44, 385, 617, -33, -687, -613, -777, 604, 433, 382, -18, -776, -461, 600, 907, 479, -331, 718, 170, -803, 926, 356, 525, 13, -972, -748, 380, 622, 110, 803, 82, -963, 764, 851, -530, -921, 285, -356, -290, 774, 124, 157, 569, 285, 12, -40, -656, -507, 384, -679, -706, -946, 539, 259, 967, -26, 282, -331, -817, 35, 16, -692, -237, 954, -544, 347, -556, 873, -52, -855, -611, 903, 31, -597, -669, 764, 98, -791, 719, -473, -988, 282, -21, 819, 167, -415, -994, 522, -854, 547, -831, -295, -379, -995, -444, 194, 174, -466, -604, -956, 845, 284, 385, -237, 79, 940, -283, -947, 379, -796, 623, 70, 853, -971, -100, 697, 548, 720, 602, -135, -82, 852, 636, 335, -541, 990, -4, -6, -889, -730, -583, -129, -384, 987, 306, 781, 737, -82, 730, 441, 983, 393, 794, 227, -336, -573, -630, -703, 490, -692, 539, -214, -112, -810, -500, 914, 518, 805, 823, -901, 768, -498, -808, -156, -669, 381, -525, 199, -424, -487, -78, 632, -913, -225, 967, 10, 845, 206, 402, -712, 280, -376, -710, -721, 238, 3, 151, -515, -403, 322, 815, -478, -147, -875, 402, -502, 375, -869, -54, 730, -916, 83, 565, -584, 454, 143, 588, -534, -243, 186, -725, 259, 86, -255, -584}, new int[]{0, 1});
    }

    private void doTest(int[] numbers, int[] expected) {
        int target = numbers[expected[0]] + numbers[expected[1]];
        int[] actual = TwoSum.twoSum(numbers, target);
        if (null == actual) {
            System.out.format("Received a null\n");
            assertNotNull(actual);
        }
        if (actual.length != 2) {
            System.out.format("Received an array that's not of length 2\n");
            assertTrue(false);
        }
        int received = numbers[actual[0]] + numbers[actual[1]];
        assertEquals(target, received);
    }
}
