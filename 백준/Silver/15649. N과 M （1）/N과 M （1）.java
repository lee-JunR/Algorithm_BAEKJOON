import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static int n; // 1~n 까지의 자연수
  static int m; // 길이가 m 인 수열의 길이
  static int[] arr;
  static boolean[] isUsed;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    arr = new int[10];
    isUsed = new boolean[10];
    
    // input
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    
    recur(0);
    
    
    br.close();
  }

  public static void recur(int k) {
    if (k == m) {
      for (int i = 0; i < m; i++) {
        System.out.print(arr[i] + " ");
      }
      System.out.println();
    }
    for (int i = 1; i <= n; i++) {
      if (!isUsed[i]) {
        arr[k] = i;
        isUsed[i] = true;
        recur(k+1);
        isUsed[i] = false;
      }
    }
  }
}
