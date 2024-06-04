import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Stack<Integer> stack = new Stack<>();
    long result = 0;
    //input
    int n = Integer.parseInt(br.readLine());
    int[] heightsOfBuildings = new int[n];
    for (int i = 0; i < n; i++) {
      heightsOfBuildings[i] = Integer.parseInt(br.readLine());
    }

    for (int i = 0; i < n; i++) {
      while (!stack.isEmpty() && heightsOfBuildings[i] >= stack.peek()) {
        stack.pop();
      }
      result += stack.size();
      stack.push(heightsOfBuildings[i]);
    }

    //output
    System.out.println(result);


    br.close();
  }
}
