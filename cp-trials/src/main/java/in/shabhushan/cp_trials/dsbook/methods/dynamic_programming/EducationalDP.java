package in.shabhushan.cp_trials.dsbook.methods.dynamic_programming;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class EducationalDP {
  public static void main(String[] args) {
    InputStream inputStream = System.in;
    OutputStream outputStream = System.out;

    InputReader in = new InputReader(inputStream);
    PrintWriter out = new PrintWriter(outputStream);

    int N = in.nextInt();
    int arr[] = new int[N];

    for (int i = 0; i < N; i++) {
      arr[i] = in.nextInt();
    }

    out.println(Frog.frogOne(N, arr));

    out.close();
  }
}

class InputReader {
  public BufferedReader reader;
  public StringTokenizer tokenizer;

  public InputReader(InputStream stream) {
    reader = new BufferedReader(new InputStreamReader(stream), 32768);
    tokenizer = null;
  }

  public String next() {
    while (tokenizer == null || !tokenizer.hasMoreTokens()) {
      try {
        tokenizer = new StringTokenizer(reader.readLine());
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    }
    return tokenizer.nextToken();
  }

  public int nextInt() {
    return Integer.parseInt(next());
  }

}

class Frog {
  public static int frogOne(int N, int[] h) {
    int[] dp = new int[N];

    Arrays.fill(dp, Integer.MAX_VALUE);
    dp[0] = 0;

    for (int i = 0; i < N; i++) {
      for (int j : new int[]{i + 1, i + 2}) {
        if (j < N) {
          dp[j] = Math.min(dp[j], dp[i] + Math.abs(h[i] - h[j]));
        }
      }
    }

    return dp[N - 1];
  }
}
