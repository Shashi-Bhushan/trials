package in.shabhushan.cp_trials.competition.cses.chapter2;

import java.io.*;
import java.util.*;

public class PermutationGeneration {
  private static final String DIR = System.getenv("HOME");

  private static Scanner getInput() throws IOException {
    return new Scanner(new File(DIR + "/input.txt"));
  }

  private static PrintWriter getOutput() throws IOException {
    return new PrintWriter(new FileWriter(DIR + "/output.txt"));
  }

  public static void main(String... args) throws IOException {
    Scanner sc = getInput();
    PrintWriter out =  getOutput();

    //Scanner sc = new Scanner(System.in);
    //PrintStream out = System.out;

    int n = sc.nextInt();
    int[] arr = new int[n];

    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }

    boolean[] chosen = new boolean[n + 1];

    List<List<Integer>> answer = new ArrayList<>();

    search(new ArrayList<Integer>(), chosen, arr, answer);

    answer.forEach(a -> {
      StringJoiner joiner = new StringJoiner(", ");
      a.forEach(p -> joiner.add(String.valueOf(p)));
      out.println(joiner.toString());
    });

    out.close();
  }

  private static void search(List<Integer> perm, boolean[] chosen, int[] arr, List<List<Integer>> answer) {
    System.out.println("Perm :: " + perm);
    if (perm.size() == arr.length) {
      System.out.println("Array : " + perm);
      answer.add(new ArrayList<Integer>(perm));
    } else {
      for (int i = 0; i < arr.length; i++) {
        System.out.println("i " + i + " - ");

        if (chosen[i])
          continue;

        chosen[i] = true;

        perm.add(i);
        search(perm, chosen, arr, answer);
        chosen[i] = false;
        perm.remove(i);
      }
    }
  }
}
