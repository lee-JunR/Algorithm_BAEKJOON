import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    // Input
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    String str = br.readLine();
    br.close();


    // 계수 행렬로 초기화
    int[] countArr = new int[26];
    for (int i = 0; i < str.length(); i++) {
      countArr[Integer.valueOf(str.charAt(i)) - 97] += 1; // 아스키 코드 만큼 빼줌 a: 97
    }

    for (int s : countArr) {
      sb.append(s);
      sb.append(" ");
    }

    System.out.println(sb.toString());
  }
}