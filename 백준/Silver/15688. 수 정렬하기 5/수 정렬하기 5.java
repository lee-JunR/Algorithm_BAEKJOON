import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 수 정렬하기 5 - 카운팅 sort
public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[2000001]; // -1,000,000 ~ 1,000,000 범위
    int offset = 1000000; // 배열 인덱스를 양수로 만들기 위해 오프셋 사용

    for (int i = 0; i < n; i++) {
      int cur = Integer.parseInt(br.readLine());
      arr[cur + offset] += 1;
    }

    for (int i = 0; i < arr.length; i++) {
      while (arr[i] > 0) {
        sb.append(i - offset).append('\n');
        arr[i]--;
      }
    }
    System.out.print(sb.toString());
  }
}
