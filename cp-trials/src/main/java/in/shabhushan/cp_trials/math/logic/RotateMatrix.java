package in.shabhushan.cp_trials.math.logic;

public class RotateMatrix {
    public static int[][] rotateLikeAVortex(int[][] matrix) {
        int[][] newMatrix = getCopy(matrix);

        for (int i = 0; i < newMatrix.length / 2; i++) {
            for (int j = 0; j < i + 1; j++) {
                rotateOnce(newMatrix, i, newMatrix.length - i - 1);
            }
        }

        return newMatrix;
    }

    private static void rotateOnce(int[][] array, int row, int column) {
        int i = row;
        int j = column;

        while (j > row) {
            int temp = array[row][j];

            array[row][j] = array[j][column];
            array[j][column] = array[column][i];
            array[column][i] = array[i][row];
            array[i][row] = temp;

            i++;
            j--;
        }
    }

    private static int[][] getCopy(int[][] matrix) {
        int[][] newMatrix = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                newMatrix[i][j] = matrix[i][j];
            }
        }

        return newMatrix;
    }
}
