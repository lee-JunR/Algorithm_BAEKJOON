import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());

    // 위쪽 부분
    for (int i = 0; i < n; i++) {
      // 공백 출력
      for (int j = 0; j < n - 1 - i; j++) {
        System.out.print(" ");
      }
      // 별 출력
      for (int j = 0; j < 2 * i + 1; j++) {
        System.out.print("*");
      }
      System.out.println();
    }

    // 아래쪽 부분
    for (int i = n - 2; i >= 0; i--) {
      // 공백 출력
      for (int j = 0; j < n - 1 - i; j++) {
        System.out.print(" ");
      }
      // 별 출력
      for (int j = 0; j < 2 * i + 1; j++) {
        System.out.print("*");
      }
      System.out.println();
    }

    br.close();
  }
}
