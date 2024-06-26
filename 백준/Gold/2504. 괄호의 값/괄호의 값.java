import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Stack;

class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    char[] line = br.readLine().toCharArray();
    Stack<Character> stack = new Stack<>();
    Stack<Integer> calculateStack = new Stack<>();
    HashMap<Character, Character> bracketDict = new HashMap<>();
    int result = 0;
    int tempValue = 1;

    bracketDict.put('(', ')');
    bracketDict.put('[', ']');

    for (int i = 0; i < line.length; i++) {
      if (line[i] == '(') {
        stack.push('(');
        calculateStack.push(tempValue);
        tempValue *= 2;
      } else if (line[i] == '[') {
        stack.push('[');
        calculateStack.push(tempValue);
        tempValue *= 3;
      } else if (line[i] == ')' || line[i] == ']') {
        if (stack.isEmpty() || line[i] != bracketDict.get(stack.pop())) {
          result = 0;
          break;
        }
        if (line[i - 1] == '(' || line[i - 1] == '[') {
          result += tempValue;
        }
        tempValue = calculateStack.pop();
      }
    }

    if (!stack.isEmpty()) {
      result = 0;
    }

    System.out.println(result);
  }
}
