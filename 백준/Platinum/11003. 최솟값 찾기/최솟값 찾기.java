//회전하는 큐 1021

// 이것은 탑 문제와 비슷
// 각 탑의 위치별 크기를 비교하면서 해당 덱의 크기를 내보내면서 비교함. 근데 왜 덱문제지?
//

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Deque;
import java.util.LinkedList;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    // input
    String[] input = br.readLine().split(" ");
    int N = Integer.parseInt(input[0]);
    int L = Integer.parseInt(input[1]);

    String[] inputA = br.readLine().split(" ");
    int[] A = new int[N];
    for (int i = 0; i < N; i++) {
      A[i] = Integer.parseInt(inputA[i]);
    }
    // 덱 초기화
    Deque<Integer> deque = new LinkedList<>();

    for (int i = 0; i < N; i++) {
//      if (!deque.isEmpty() && deque.peekLast() < i - L + 1) {
//        deque.removeLast();
//      }
//      while (!deque.isEmpty() && A[deque.peekFirst()] > A[i]) {
//        deque.removeFirst();
//      }
//      deque.addFirst(A[i]);
//      sb.append(A[deque.peekLast()]).append(" ");


      if (!deque.isEmpty() && deque.peekFirst() < i - L + 1) {
        deque.removeFirst();
      }
      while (!deque.isEmpty() && A[deque.peekLast()] > A[i]) {
        deque.removeLast();
      }
      deque.addLast(i);
      sb.append(A[deque.peekFirst()]).append(" ");

    }
    System.out.println(sb.toString());
    br.close();
  }
}
//12 3
//1 5 2 3 6 2 3 7 3 5 2 6
//1 1 1 2 2 2 2 2 3 3 2 2