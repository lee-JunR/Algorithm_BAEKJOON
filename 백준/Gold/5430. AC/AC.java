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
      sb.setLength(0);
      char[] cmds = br.readLine().toCharArray();
      int lengthOfArr = Integer.parseInt(br.readLine());
      String[] arr = br.readLine().replace("[", "").replace("]", "").split(",");

      Deque<String> deque = new LinkedList<>();
      for (int j = 0; j < lengthOfArr; j++) {
        if (!arr[j].isEmpty()) {
          deque.offerLast(arr[j]);
        }
      }

      boolean isReversed = false;
      boolean errorOccurred = false;

      for (char c : cmds) {
        switch (c) {
          case 'R':
            isReversed = !isReversed;
            break;
          case 'D':
            if (deque.isEmpty()) {
              sb.append("error");
              errorOccurred = true;
              break;
            }
            if (isReversed) {
              deque.removeLast();
            } else {
              deque.removeFirst();
            }
            break;
        }
        if (errorOccurred) break;
      }

      if (!errorOccurred) {
        sb.append("[");
        while (!deque.isEmpty()) {
          if (isReversed) {
            sb.append(deque.removeLast());
          } else {
            sb.append(deque.removeFirst());
          }
          if (!deque.isEmpty()) {
            sb.append(",");
          }
        }
        sb.append("]");
      }

      System.out.println(sb.toString());
    }
    
    br.close();
  }
}