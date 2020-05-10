package in.shabhushan.cp_trials.math.logic;

import org.junit.Test;

import java.util.stream.IntStream;

import static in.shabhushan.cp_trials.math.logic.SortTheOdd.sortArray;
import static org.junit.Assert.assertArrayEquals;

public class SortTheOddTest {
    @Test
    public void exampleTest1() {
        IntStream.of(0, 100000).forEach(index -> {
            assertArrayEquals(new int[]{1, 3, 2, 8, 5, 4}, sortArray(new int[]{5, 3, 2, 8, 1, 4}));
        });
    }

    @Test
    public void exampleTest2() {
        IntStream.of(0, 100000).forEach(index -> {
            assertArrayEquals(new int[]{1, 3, 5, 8, 0}, sortArray(new int[]{5, 3, 1, 8, 0}));
        });
    }

    @Test
    public void exampleTest3() {
        IntStream.of(0, 100000).forEach(index -> {
            assertArrayEquals(new int[]{}, sortArray(new int[]{}));
        });
    }

    @Test
    public void exampleTest4() {
        IntStream.of(0, 100000).forEach(index -> {
            assertArrayEquals(new int[]{1, 3, 2, 8, 5, 4}, sortArray(new int[]{5, 3, 2, 8, 1, 4}));
        });
    }

    @Test
    public void exampleTest5() {
        IntStream.of(0, 100000).forEach(index -> {
            assertArrayEquals(new int[]{1, 3, 5, 8, 0}, sortArray(new int[]{5, 3, 1, 8, 0}));
        });
    }

    @Test
    public void exampleTest6() {
        IntStream.of(0, 100000).forEach(index -> {
            assertArrayEquals(new int[]{}, sortArray(new int[]{}));
        });
    }
}
