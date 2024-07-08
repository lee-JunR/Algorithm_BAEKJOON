import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static int n;
  static int m;
  static int[] arr;
  static boolean[] isUsed;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    arr = new int[m];
    isUsed = new boolean[n + 1];

    recur(0, 1);

    br.close();
  }

  public static void recur(int k, int start) {
    if (k == m) {
      for (int i = 0; i < m; i++) {
        System.out.print(arr[i] + " ");
      }
      System.out.println();
      return;
    }

    for (int i = start; i <= n; i++) {
      if (!isUsed[i]) {
        arr[k] = i;
        isUsed[i] = true;
        recur(k + 1, i + 1);
        isUsed[i] = false;
      }
    }
  }
}