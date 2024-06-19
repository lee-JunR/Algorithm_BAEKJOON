//카드 놓기 18115

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Deque;
import java.util.LinkedList;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    Deque<Integer> originalDeck = new LinkedList<>();

    //input
    int N = Integer.parseInt(br.readLine());
    String[] cmds = br.readLine().split(" ");

    for (int i = N - 1; i >= 0; i--) {
      switch (cmds[i]) {
        case "1":
          originalDeck.addFirst(N-i);
          break;
        case "2":
          int temp = originalDeck.peekFirst();
          originalDeck.removeFirst();
          originalDeck.addFirst(N-i);
          originalDeck.addFirst(temp);
          break;
        case "3":
          originalDeck.addLast(N-i);
          break;
      }
    }
    for (int i = 0; i < N; i++) {
      sb.append(originalDeck.pollFirst()).append(' ');
    }
    System.out.println(sb.toString());
    br.close();
  }
}