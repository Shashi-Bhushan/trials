package in.shabhushan.cp_trials.math.logic;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class RotateMatrixTest {
    @Test
    public void exampleTests() {
        int[][] matrix = new int[][]{new int[]{5, 3, 6, 1},
                new int[]{5, 8, 7, 4},
                new int[]{1, 2, 4, 3},
                new int[]{3, 1, 2, 2}};

        int[][] expected = new int[][]{new int[]{1, 4, 3, 2},
                new int[]{6, 4, 2, 2},
                new int[]{3, 7, 8, 1},
                new int[]{5, 5, 1, 3}};

        int[][] actual = RotateMatrix.rotateLikeAVortex(matrix);
        String message = "Your result:\n" + matrixToString(actual) + "\n\nExpected result:\n" + matrixToString(expected) + "\n";
        assertEquals(message, expected, actual);
    }

    private String matrixToString(int[][] matrix) {
        if (matrix == null) return "No result";
        String[] lines = new String[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            lines[i] = Arrays.toString(matrix[i]);
        }
        return String.join("\n", lines);
    }
}
