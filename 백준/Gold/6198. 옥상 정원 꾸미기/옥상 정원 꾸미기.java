// 옥상 정원 꾸미기 6198
// 빌딩의 높이를 가진 자료가 1_000_000_000 개이므로 O(n)의 시간복잡도를 떠올리자.

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    //input
    int n = Integer.parseInt(br.readLine());
    int[] heightsOfBuildings = new int[n];
    for (int i = 0; i < n; i++) {
      heightsOfBuildings[i] = Integer.parseInt(br.readLine());
    }

    long totalViewCount = 0;
    Stack<Integer> stack = new Stack<>();

    for (int i = 0; i < n; i++) {
      // 현재 빌딩보다 낮은 빌딩을 스택에서 제거
      while (!stack.isEmpty() && stack.peek() <= heightsOfBuildings[i]) {
        stack.pop();
      }
      // 스택에 남아있는 빌딩은 현재 빌딩에서 볼 수 있는 빌딩
      totalViewCount += stack.size();
      // 현재 빌딩을 스택에 추가
      stack.push(heightsOfBuildings[i]);
    }

    // Output
    System.out.println(totalViewCount);
  }
}
