
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
// 먹을 것인가 먹힐 것인가 7795
public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int tc = Integer.parseInt(br.readLine());
    StringTokenizer st;
    int lengthOfA;
    int lengthOfB;

    for (int i = 0; i < tc; i++) {
      // 초기화
      st = new StringTokenizer(br.readLine());
      lengthOfA = Integer.parseInt(st.nextToken());
      lengthOfB = Integer.parseInt(st.nextToken());

      int[] a = new int[lengthOfA];
      int[] b = new int[lengthOfB];

      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < lengthOfA; j++) {
        a[j] = Integer.parseInt(st.nextToken());
      }

      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < lengthOfB; j++) {
        b[j] = Integer.parseInt(st.nextToken());
      }

      Arrays.sort(a);
      Arrays.sort(b);

      int result = 0;
      int k = 0;

      for (int j = 0; j < lengthOfA; j++) {
        while (k < lengthOfB && b[k] < a[j]) {
          k++;
        }
        result += k;
      }

      sb.append(result).append('\n');
    }

    System.out.println(sb.toString());
    br.close();
  }
}
