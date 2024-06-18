import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Deque;
import java.util.LinkedList;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int tc = Integer.parseInt(br.readLine());

    for (int i = 0; i < tc; i++) {
      char[] cmds = br.readLine().toCharArray();
      int lengthOfArr = Integer.parseInt(br.readLine());
      String inputArr = br.readLine().replace("[", "").replace("]", "").trim();
      Deque<Integer> deque = new LinkedList<>();

      if (!inputArr.isEmpty()) {
        for (String num : inputArr.split(",")) {
          deque.offerLast(Integer.parseInt(num));
        }
      }

      boolean isReversed = false;
      boolean errorOccurred = false;

      for (char cmd : cmds) {
        if (cmd == 'R') {
          isReversed = !isReversed;
        } else if (cmd == 'D') {
          if (deque.isEmpty()) {
            sb.append("error\n");
            errorOccurred = true;
            break;
          } else {
            if (isReversed) {
              deque.pollLast();
            } else {
              deque.pollFirst();
            }
          }
        }
      }

      if (!errorOccurred) {
        sb.append("[");
        if (isReversed) {
          while (!deque.isEmpty()) {
            sb.append(deque.pollLast());
            if (!deque.isEmpty()) sb.append(",");
          }
        } else {
          while (!deque.isEmpty()) {
            sb.append(deque.pollFirst());
            if (!deque.isEmpty()) sb.append(",");
          }
        }
        sb.append("]\n");
      }
    }

    System.out.print(sb.toString());
    br.close();
  }
}