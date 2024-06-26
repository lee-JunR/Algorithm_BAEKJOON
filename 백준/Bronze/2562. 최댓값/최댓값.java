import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    // Input
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int max = 0;
    int curIndex = 0;

    for (int i = 0; i < 9; i++) {
      int cur = Integer.parseInt(br.readLine());
      if (max < cur) {
        max = cur;
        curIndex = i + 1;
      }
    }
    br.close();
    System.out.println(max);
    System.out.println(curIndex);
  }
}