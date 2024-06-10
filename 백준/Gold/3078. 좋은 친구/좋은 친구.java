import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] input = br.readLine().split(" ");
    int N = Integer.parseInt(input[0]);
    int K = Integer.parseInt(input[1]);
    long result = 0;
    Queue<Integer>[] q = new LinkedList[21]; // 이름 길이는 2 ~ 20글자

    for (int i = 2; i <= 20; i++) {
      q[i] = new LinkedList<>();
    }

    for (int i = 0; i < N; i++) {
      String s = br.readLine();
      int len = s.length();
      while (!q[len].isEmpty() && i - q[len].peek() > K) {
        q[len].poll();
      }
      result += q[len].size();
      q[len].offer(i);
    }

    System.out.println(result);
    br.close();
  }
}
