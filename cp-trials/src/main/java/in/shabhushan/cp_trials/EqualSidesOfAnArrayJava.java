package in.shabhushan.cp_trials;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class EqualSidesOfAnArrayJava {
    public static int findEvenIndex(int[] arr) {

        final AtomicInteger equalIndex = new AtomicInteger(-1);

        IntStream.range(0, arr.length).forEach(index -> {
            int leftSum = IntStream.range(0, index).map(ind -> arr[ind]).sum();

            int rightSum = IntStream.range(index + 1, arr.length).map(ind -> arr[ind]).sum();

            if (leftSum == rightSum) equalIndex.set(index);
        });

        return equalIndex.get();
    }

    public static int findEvenIndex2(int[] arr) {
        int rightSum = Arrays.stream(arr).sum() - arr[0];
        int leftSum = 0;

        for (int index = 1; index < arr.length; index++) {
            if (rightSum == leftSum) return index - 1;

            rightSum -= arr[index];
            leftSum += arr[index - 1];
        }

        return -1;
    }
}
