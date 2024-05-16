import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    // 윗부분
    for (int i = 0; i < n; i++) {
      // 공백 출력
      for (int j = 0; j < i; j++) {
        System.out.print(' ');
      }
      // 별출력
      for (int j = 0; j < (n - i) * 2 - 1; j++) {
        System.out.print('*');
      }
      System.out.println();
    }

    // 아랫부분 (공백, 별 반대로 하고 range 조정)
    for (int i = n - 2; i >= 0; i--) {
      // 공백 출력
      for (int j = 0; j < i; j++) {
        System.out.print(' ');
      }
      // 별출력
      for (int j = 0; j < (n - i) * 2 - 1; j++) {
        System.out.print('*');
      }
      System.out.println();
    }

    br.close();

  }
}