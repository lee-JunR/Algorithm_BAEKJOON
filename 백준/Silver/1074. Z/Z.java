import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    // 2^N x 2^N 인 행렬의 r 행 c 열 의 숫자 구하기
    int n = Integer.parseInt(st.nextToken());
    int r = Integer.parseInt(st.nextToken());
    int c = Integer.parseInt(st.nextToken());

    // N = 3
    // 0~3 행 0~3 열 4~7행 0~3열 -> 2^0~2^2-1행 ~ 2^2~2^3열
    // 0~3 행 4~7 열 4~7행 4~7열
    // 4행 7 열
    // 행 -> 2의 몇승인지 확인 -> 2^2 승임
    // 열 -> 2의 몇승인지 확인 -> 2^2승 + 2^1

    System.out.println(z(n, r, c));

    br.close();
  }
  private static int z(int n, int r, int c) {
    if (n == 0) {
      return 0;
    }
    int half = (int) Math.pow(2, n - 1);
    if (r < half && c < half) {
      // 왼쪽 위 부분
      return z(n - 1, r, c);
    } else if (r < half && c >= half) {
      // 오른쪽 위 부분
      return half * half + z(n - 1, r, c - half);
    } else if (r >= half && c < half) {
      // 왼쪽 아래 부분
      return 2 * half * half + z(n - 1, r - half, c);
    } else {
      // 오른쪽 아래 부분
      return 3 * half * half + z(n - 1, r - half, c - half);
    }
  }
}
