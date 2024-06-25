// 쇠막대기 10799

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    //input
    char[] barAndRazor = br.readLine().toCharArray();
    int count = 0;
    Stack<Character> stack = new Stack<Character>();
    for (int i = 0; i < barAndRazor.length; i++) {
      if (barAndRazor[i] == '(') {
        stack.push(barAndRazor[i]);
      } else if (barAndRazor[i] == ')') {
        if (barAndRazor[i - 1] == '(') {
          stack.pop();
          count += stack.size();
        } else {
          stack.pop();
          count += 1;
        }
      }
    }

    System.out.println(count);
    br.close();
  }
}