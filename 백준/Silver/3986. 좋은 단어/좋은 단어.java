// 좋은 단어 3986

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    //input
    int tc = Integer.parseInt(br.readLine());
    int count = 0;

    for (int i = 0; i < tc; i++) {
      char[] words = br.readLine().toCharArray();
      if (checkGoodWords(words)) {
        count += 1;
      }
    }
    System.out.println(count);

    br.close();
  }

  private static Boolean checkGoodWords(char[] words) {
    Stack<Character> stack = new Stack<Character>();
    for (int i = 0; i < words.length; i++) {
      if (stack.isEmpty()) {
        stack.push(words[i]);
      } else if (stack.peek() == words[i]) {
        stack.pop();
      } else{
        stack.push(words[i]);
      }
    }
    return stack.isEmpty();
  }
}