package in.shabhushan.cp_trials.competition.atcoder;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int A = sc.nextInt();
    int B = sc.nextInt();
    int c = sc.nextInt();

    List<String> l = new ArrayList<>();

    while (N-- > 0) {
      String s = sc.nextLine();

      if (s.equals("AB")) {
        // check a or b has max
        if (A > B) {
          // subtract from A, Add C to list
        }
      } else if (s.equals("AC")) {

      } else {

      }
    }
  }
}
