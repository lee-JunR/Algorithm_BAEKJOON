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
    int offset = 1000000; // 배열 인덱스를 양수로 만들기 위한 오프셋
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;

    // 입력 받기 및 범위 계산
    for (int i = 0; i < n; i++) {
      int cur = Integer.parseInt(br.readLine());
      arr[cur + offset] += 1;
      if (cur < min) min = cur;
      if (cur > max) max = cur;
    }

    // 정렬된 결과 생성
    for (int i = min + offset; i <= max + offset; i++) {
      while (arr[i] > 0) {
        sb.append(i - offset).append('\n');
        arr[i]--;
      }
    }

    // 결과 출력
    System.out.print(sb.toString());
  }
}
