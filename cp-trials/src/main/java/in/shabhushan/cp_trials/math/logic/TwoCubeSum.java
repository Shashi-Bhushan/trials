package in.shabhushan.cp_trials.math.logic;

public class TwoCubeSum {
    /**
     * all 4 numbers will be smaller than cube root of n
     */
    public static boolean hasTwoCubeSums(int n) {
        double cubeRoot = Math.pow(n, 1.0 / 3);

        boolean foundFirst = false;

        for (var i = 1; i < cubeRoot; i++) {
            for (var j = i; j < cubeRoot; j++) {
                var num = (i * i * i) + (j * j * j);

                if (num == n) {
                    // 2. if this was already set to true, that means this is the second pair that sums up to the number
                    if (foundFirst)
                        return true;

                    // 1. if sum of cube is equal to num, set this to true
                    foundFirst = true;
                }
            }
        }

        return false;
    }
}
