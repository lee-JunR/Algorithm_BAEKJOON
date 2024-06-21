// 우정님 에러 로직 분리 안한 풀이
import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuilder sb = new StringBuilder();

    int testCase = Integer.parseInt(br.readLine());
    for (int i = 0; i < testCase; i++) {
      String command = br.readLine();
      int size = Integer.parseInt(br.readLine());
      boolean direction = true;
      boolean isError = false;

      String input = br.readLine();
      input = input.substring(1, input.length() - 1);

      Deque<Integer> deque = new ArrayDeque<>();
      if (!input.isEmpty()) {
        String[] tokens = input.split(",");
        for (int j = 0; j < size; j++) {
          deque.addLast(Integer.parseInt(tokens[j].trim()));
        }
      }

      for (int j = 0; j < command.length(); j++) {
        switch (command.charAt(j)) {
          case 'R':
            direction = !direction;
            break;
          case 'D':
            if (deque.isEmpty()) {
              isError = true;
              break;
            }
            if (direction) {
              deque.pollFirst();
            } else {
              deque.pollLast();
            }
            break;
        }
      }

      if (isError) {
        bw.write("error\n");
      } else {
        sb.setLength(0);
        sb.append("[");
        if (direction) {
          while (!deque.isEmpty()) {
            sb.append(deque.pollFirst()).append(',');
          }
        } else {
          while (!deque.isEmpty()) {
            sb.append(deque.pollLast()).append(',');
          }
        }
        if (sb.length() > 1) {
          sb.setLength(sb.length() - 1);
        }
        sb.append("]\n");
        bw.write(sb.toString());
      }
    }

    br.close();
    bw.close();
  }
}