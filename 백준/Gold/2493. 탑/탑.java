// 탑 2493

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.stream.Stream;
import java.util.Stack;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    //input
    int n = Integer.parseInt(br.readLine());
    int[] heightsOfTowers = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

    int[] receivers = new int[n];
    Stack<Integer> stack = new Stack<>();

    for (int i = n - 1; i >= 0; i--) {
      // 스택이 비어있지 않고, 스택의 탑의 높이가 현재 탑보다 낮을 때
      while (!stack.isEmpty() && heightsOfTowers[stack.peek()] < heightsOfTowers[i]) {
        receivers[stack.pop()] = i + 1; // 수신하는 탑의 번호 기록
      }
      stack.push(i); // 현재 탑을 스택에 추가
    }

    //output
    for (int i = 0; i < n; i++) {
      sb.append(receivers[i]).append(" ");
    }
    System.out.println(sb.toString());
  }
}