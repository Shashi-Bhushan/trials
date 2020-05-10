package in.shabhushan.cp_trials.math.logic;

public class BirdMountain {

    public static int peakHeight(char[][] mountain) {
        int height = 0;
        int row = mountain.length;
        int column = mountain[0].length;

        boolean found;
        do {
            found = false;
            char[][] temp = new char[row][column];

            // iterate over array
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < column; j++) {
                    if (mountain[i][j] == '^' &&
                        (i == 0 || j == 0 || i == row - 1 || j == column - 1 ||
                        mountain[i + 1][j] == ' ' || mountain[i][j + 1] == ' ' ||
                        mountain[i - 1][j] == ' ' || mountain[i][j - 1] == ' ')
                    ) {
                        // found atleast one entry in this layer
                        found = true;
                        // set this layer's char to 0
                        temp[i][j] = ' ';
                    } else
                        temp[i][j] = mountain[i][j];
                }
            }

            if (found) {
                height++;
                mountain = temp;
            }
        } while (found);

        return height;
    }

}
