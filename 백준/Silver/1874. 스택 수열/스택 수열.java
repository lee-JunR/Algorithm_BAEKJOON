import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    Stack<Integer> stack = new Stack<>();

    int n = Integer.parseInt(br.readLine());
    int[] init = new int[n];
    for (int i = 0; i < n; i++) {
      init[i] = Integer.parseInt(br.readLine());
    }

    int cur = 1;
    boolean possible = true;

    for (int i = 0; i < n; i++) {
      int value = init[i];

      if (value >= cur) {
        while (value >= cur) {
          stack.push(cur++);
          sb.append('+').append('\n');
        }
        stack.pop();
        sb.append('-').append('\n');
      } else {
        if (stack.peek() != value) {
          possible = false;
          break;
        } else {
          stack.pop();
          sb.append('-').append('\n');
        }
      }
    }

    if (possible) {
      System.out.println(sb.toString());
    } else {
      System.out.println("NO");
    }

    br.close();
  }
}