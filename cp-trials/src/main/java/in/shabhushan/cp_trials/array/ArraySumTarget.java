package in.shabhushan.cp_trials.array;

/**
 * leetcode solution for
 * https://leetcode.com/problems/number-of-submatrices-that-sum-to-target/submissions/
 */
class ArraySumTarget {
  public static int numSubmatrixSumTarget(int[][] matrix, int target) {
    if (matrix.length == 0 || matrix[0].length == 0)
      return 0;

    int rows = matrix.length;
    int cols = matrix[0].length;

    int result = 0;

    for (int i = 0; i < cols; i++) {
      int[] colSum = new int[rows];

      for (int j = i; j < cols; j++) {
        // add for current column
        for (int row = 0; row < rows; row++) {
          colSum[row] += matrix[row][j];
        }

        for (int x = 0; x < colSum.length; x++) {
          int c = 0;
          for (int y = x; y < colSum.length; y++) {
            c += colSum[y];

            if (c == target) {
              result++;
            }
          }
        }
      }
    }

    return result;
  }
}
