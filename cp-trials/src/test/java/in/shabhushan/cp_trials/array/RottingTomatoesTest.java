package in.shabhushan.cp_trials.array;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class RottingTomatoesTest {
    @Test
    public void testRottenTomatoes() {
        int[][] matrix = new int[][]{
                new int[]{2, 1, 1},
                new int[]{1, 1, 0},
                new int[]{0, 1 ,1}
        };

        int minutes = new RottingTomatoes().orangesRotting(matrix);
        assertEquals(4, minutes);
    }
}
