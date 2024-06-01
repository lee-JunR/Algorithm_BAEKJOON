// 제로 10773

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

  public static void main(String[] args) throws IOException {
    //초기화 및 Input
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Stack<Integer> stack = new Stack<>();
    int n = Integer.parseInt(br.readLine());
    int result = 0;

    //stack에 규칙을 지키며 초기화
    for (int i = 0; i < n; i++) {
      int index = Integer.parseInt(br.readLine());
      if (index == 0) {
        stack.pop();
      } else {
        stack.push(index);
      }
    }

    //초기화된 stack의 전체 합을 구함.
    while (!stack.isEmpty()) {
      result += stack.pop();
    }
    System.out.println(result);
    br.close();
  }
}