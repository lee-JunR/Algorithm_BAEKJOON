import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    // BufferedReader를 사용
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int x = Integer.parseInt(st.nextToken());

    int[] A = new int[n];

    // 두 번째 줄에서 배열 A의 요소들을 입력받고, 동시에 x보다 작은 요소를 한번에 처리
    st = new StringTokenizer(br.readLine());
    StringBuilder result = new StringBuilder();
    for (int i = 0; i < n; i++) {
      A[i] = Integer.parseInt(st.nextToken());
      if (A[i] < x) {
        // x보다 작은 요소들을 StringBuilder에 추가
        result.append(A[i]).append(" ");
      }
    }

    System.out.println(result.toString());

    br.close();
  }
}
