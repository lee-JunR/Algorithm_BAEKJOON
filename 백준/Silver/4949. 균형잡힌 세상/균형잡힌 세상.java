import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Stack;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        while (true) {
            String line = br.readLine();
            if (line.equals(".")) {
                break;
            }
            if (isBalanced(line)) {
                sb.append("yes\n");
            } else {
                sb.append("no\n");
            }
        }

        System.out.print(sb.toString());
        br.close();
    }

    private static boolean isBalanced(String line) {
        Stack<Character> bracketStack = new Stack<>();
        HashMap<Character, Character> bracketDict = new HashMap<>();
        bracketDict.put('(', ')');
        bracketDict.put('[', ']');

        for (char c : line.toCharArray()) {
            if (c == '[' || c == '(') {
                bracketStack.push(c);
            } else if (c == ']' || c == ')') {
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
