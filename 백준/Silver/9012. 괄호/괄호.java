//괄호 9012

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Stack;

class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int tc = Integer.parseInt(br.readLine());
    for (int i = 0; i < tc; i++) {
      String line = br.readLine();
      if (isBalanced(line)) {
        sb.append("YES\n");
      } else {
        sb.append("NO\n");
      }
    }

    System.out.print(sb.toString());
    br.close();
  }

  private static boolean isBalanced(String line) {
    Stack<Character> bracketStack = new Stack<>();
    HashMap<Character, Character> bracketDict = new HashMap<>();
    bracketDict.put('(', ')');

    for (char c : line.toCharArray()) {
      if (c == '(') {
        bracketStack.push(c);
      } else if (c == ')') {
        if (bracketStack.isEmpty()) {
          return false;
        }
        char openBracket = bracketStack.pop();
        if (bracketDict.get(openBracket) != c) {
          return false;
        }
      }
    }
    return bracketStack.isEmpty();
  }
}
