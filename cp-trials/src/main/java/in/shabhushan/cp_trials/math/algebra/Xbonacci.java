package in.shabhushan.cp_trials.math.algebra;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toList;

public class Xbonacci {
    // only a wrapper function that boxes and unboxes array to List
    public static double[] xbonacci(double[] signature, int n) {
        List<Double> collect = stream(signature).boxed().collect(toList());

        return xbonacci(collect, n).stream().mapToDouble(elem -> elem).toArray();
    }

    public static List<Double> xbonacci(List<Double> signature, int length) {
        if (signature.size() > length) {
            return signature.subList(0, length);
        } else if (signature.size() == length)
            return signature;
        else {
            // Create New List with first element
            List<Double> newList = new java.util.ArrayList<>(List.of(signature.get(0)));

            // Create new list with second..last element
            List<Double> doubles = signature.subList(1, signature.size());
            // Add first+second+third..+last
            doubles.add(signature.parallelStream().reduce(0.0, Double::sum));

            newList.addAll(xbonacci(doubles, length - 1));
            return newList;
        }
    }

    public static void main(String[] args) {
        double[] signature = new double[1000];
        for (int i = 0; i < 1000; i++) {
            signature[i] = new Random().nextDouble();
        }

        Long init = new Date().getTime();
        xbonacciStreams(signature, 10000);
        Long end = new Date().getTime();
        System.out.println("Time xbonacciStreams (millis): " + (end - init));


        init = new Date().getTime();
        xbonacciFors(signature, 10000);
        end = new Date().getTime();
        System.out.println("Time xbonacciFors (millis): " + (end - init));

        init = new Date().getTime();
        xbonacci(signature, 10000);
        end = new Date().getTime();
        System.out.println("Time xbonacciFors (millis): " + (end - init));
    }

    public static double[] xbonacciStreams(double[] signature, int n) {
        int x = signature.length;
        double[] result = Arrays.copyOf(signature, n);

        for (int i = x; i < n; i++)
            result[i] = Arrays.stream(result, i - x, i).sum();
        return result;
    }

    public static double[] xbonacciFors(double[] signature, int n) {
        int x = signature.length;

        double[] xbonacci = new double[n];

        for (int i = 0; i < n; i++) {
            if (i < x) {
                xbonacci[i] = signature[i];
            } else {
                for (int j = i - x; j < i; j++) {
                    xbonacci[i] += xbonacci[j];
                }
            }
        }

        return xbonacci;
    }
}
