import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;

public class Main {

  public static void main(String[] args) throws IOException {
    // TC 분리
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine()); // TC개수

    // 각 TC 당 하나씩 처리.
    for (int test_case = 1; test_case <= T; test_case++) {
      // Input
      LinkedList<Character> keyLogList = new LinkedList<>();
      String keyLog = br.readLine();
      ListIterator<Character> cursor = keyLogList.listIterator();

      for (char c : keyLog.toCharArray()) {
        switch (c) {
          case '>':
            if (cursor.hasNext()) {
              cursor.next();
            }
            break;
          case '<':
            if (cursor.hasPrevious()) {
              cursor.previous();
            }
            break;
          case '-':
            if (cursor.hasPrevious()) {
              cursor.previous();
              cursor.remove();
            }
            break;
          default:
            cursor.add(c);
            break;
        }
      }

      // Output
      StringBuilder sb = new StringBuilder();
      for (char c : keyLogList) {
        sb.append(c);
      }
      System.out.println(sb.toString());
    }
    br.close();
  }
}