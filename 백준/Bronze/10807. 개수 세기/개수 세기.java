// 개수_세기_10807
//

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.StringTokenizer;


public class Main {

  public static void main(String[] args) throws IOException {
    // Input
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    br.readLine(); // n 제거
    String str = br.readLine();
    StringTokenizer st = new StringTokenizer(str, " ");
    String v = br.readLine();

    int cnt = 0;

    while (st.hasMoreTokens()) {
      if (Objects.equals(st.nextToken(), v)) { // equals 를 사용하는것이 좋음.
        cnt++;
      }
    }
    System.out.println(cnt);
    
    br.close();
  }
}