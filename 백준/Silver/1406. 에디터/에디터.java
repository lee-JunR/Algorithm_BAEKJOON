import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;

public class Main {

  public static void main(String[] args) throws IOException {
    // Input
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String initialStr = br.readLine();
    int m = Integer.parseInt(br.readLine()); // 입력할 정수의 개수
    String[] cmdList = new String[m];

    for (int i = 0; i < m; i++) {
      cmdList[i] = br.readLine();
    }
    br.close();

    // LinkedList 사용
    LinkedList<Character> list = new LinkedList<>();
    for (char c : initialStr.toCharArray()) {
      list.add(c);
    }

    ListIterator<Character> iterator = list.listIterator(list.size());

    for (String command : cmdList) {
      char cmd = command.charAt(0);
      switch (cmd) {
        case 'L':
          if (iterator.hasPrevious()) {
            iterator.previous();
          }
          break;
        case 'D':
          if (iterator.hasNext()) {
            iterator.next();
          }
          break;
        case 'B':
          if (iterator.hasPrevious()) {
            iterator.previous();
            iterator.remove();
          }
          break;
        case 'P':
          char argument = command.charAt(2); // P 명령어 뒤에 오는 첫 번째 문자
          iterator.add(argument);
          break;
      }
    }

    // Output
    StringBuilder result = new StringBuilder();
    for (char c : list) {
      result.append(c);
    }
    System.out.println(result.toString());
  }
}
