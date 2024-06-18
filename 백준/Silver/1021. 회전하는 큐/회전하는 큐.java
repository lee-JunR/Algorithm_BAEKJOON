//회전하는 큐 1021

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // input
    String[] input = br.readLine().split(" ");
    int N = Integer.parseInt(input[0]);
    int M = Integer.parseInt(input[1]);

    input = br.readLine().split(" ");
    int[] targets = new int[M];
    for (int i = 0; i < M; i++) {
      targets[i] = Integer.parseInt(input[i]);
    }

    // 큐 초기화
    Deque<Integer> deque = new ArrayDeque<>();
    for (int num = 1; num <= N; num++) {
      deque.offer(num);
    }

    int totalMoveCount = 0;

    for (int i = 0; i < M; i++) {
      int targetElement = targets[i];

      // 왼쪽으로 이동하는 횟수 하나만 확인하면 다른 횟수를 체크 가능
      int leftMoveCount = 0;
      while (deque.peekFirst() != targetElement) {
        deque.offerLast(deque.pollFirst());
        leftMoveCount++;
      }

      int rightMoveCount = deque.size() - leftMoveCount;

      // 최소 이동 횟수를 더함
      totalMoveCount += Math.min(leftMoveCount, rightMoveCount);

      // 뽑은 원소 제거
      deque.pollFirst();
    }

    // output
    System.out.println(totalMoveCount);

    br.close();
  }
}
