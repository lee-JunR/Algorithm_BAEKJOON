import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    //input
    int numberOfCount = Integer.parseInt(br.readLine());
    ArrQueue queue = new ArrQueue(numberOfCount);

    for (int i = 0; i < numberOfCount; i++) {
      String[] cmd = br.readLine().split(" ");
      switch (cmd[0]) {
        case "push": // push X: 정수 X를 큐에 넣는 연산이다.
          queue.push(Integer.parseInt(cmd[1]));
          break;
        case "pop": // pop: 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
          sb.append(queue.pop()).append('\n');
          break;
        case "size": // size: 큐에 들어있는 정수의 개수를 출력한다.
          sb.append(queue.size()).append('\n');
          break;
        case "empty": // empty: 큐가 비어있으면 1, 아니면 0을 출력한다.
          sb.append(queue.empty()).append('\n');
          break;
        case "front": // front: 큐의 가장 앞에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
          sb.append(queue.front()).append('\n');
          break;
        case "back": // back: 큐의 가장 뒤에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
          sb.append(queue.back()).append('\n');
          break;
      }
    }

    System.out.println(sb.toString());
    br.close();
  }
}

class ArrQueue {

  private int[] Queue; // 원소를 담을 배열 1개
  private int head = 0;
  private int tail = 0;

  public ArrQueue(int capacity) {
    Queue = new int[capacity];
  }

  public void push(int data) {
    Queue[tail++] = data;
  }

  public int pop() {
    if (!isEmpty()) {
      return Queue[head++];
    }
    return -1;
  }

  public int front() { // 제일 앞(밑)쪽에 원소를 반환하는 함수.
    if (!isEmpty()) {
      return Queue[head];
    }
    return -1;
  }

  public int back() { // 제일 뒷(윗)쪽의 원소를 반환하는 함수
    if (!isEmpty()) {
      return Queue[tail - 1];
    }
    return -1;
  }

  public int size() {
    return tail - head;
  }

  public int empty() {
    if (isEmpty()) {
      return 1;
    }
    return 0;
  }

  public boolean isEmpty() {
    return tail - head <= 0;
  }
}