import java.io.*;
import java.util.*;

/**
 * INPUT: 
 * 3
 * 1 2 3
 * 
 * OUTPUT
 * []
 * [1]
 * [2]
 * [1, 2]
 * [3]
 * [1, 3]
 * [2, 3]
 * [1, 2, 3]
 */
public class SubsetGeneration {
  private static Scanner getInput() throws IOException {
    return new Scanner(new File("input.txt"));
  }

  private static PrintWriter getOutput() throws IOException {
    return new PrintWriter(new FileWriter("output.txt"));
  }

  public static void main(String... args) throws IOException {
    Scanner sc = getInput();
    PrintWriter out = getOutput();

    int n = sc.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }

    Set<Set<Integer>> subset = new HashSet<>();
    search(0, n, arr, new HashSet<Integer>(), subset);

    for (Set<Integer> set: subset) {
      out.println(Arrays.toString(set.toArray()));
    }

    out.close();
  }

  private static void search(int arrIndex, int n, int[] arr, Set<Integer> set, Set<Set<Integer>> finalSet) {
    if (arrIndex == n) {
      Set<Integer> s = new HashSet<>();
      s.addAll(set);

      finalSet.add(s);
    } else {
      set.add(arr[arrIndex]);
      search(arrIndex + 1, n, arr, set, finalSet);
      set.remove(arr[arrIndex]);
      search(arrIndex + 1, n, arr, set, finalSet);
    }
  }
}