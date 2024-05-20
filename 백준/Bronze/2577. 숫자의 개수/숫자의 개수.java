// 숫자의_개수_3577
// 숫자 -> 배열로 변환하는 문제.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    // Input
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int N = Integer.parseInt(br.readLine());
    for (int i = 0; i < 2; i++) {
      N *= Integer.parseInt(br.readLine());
    }
    br.close();

    char[] str_N = String.valueOf(N).toCharArray();

    // 계수 행렬로 초기화
    int[] countArr = new int[10];
    for (char c : str_N) {
      countArr[Character.getNumericValue(c)] += 1;
    }

    // Output
    for (int i : countArr) {
      sb.append(i);
      sb.append("\n");
    }

    System.out.println(sb.toString());
  }
}