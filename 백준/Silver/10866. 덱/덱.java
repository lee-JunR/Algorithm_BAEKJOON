import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class ArrDeque {
  private int[] deque;
  private int head;
  private int tail;
  private int capacity;

  public ArrDeque(int capacity) {
    this.capacity = capacity;
    deque = new int[capacity];
    head = capacity / 2;
    tail = capacity / 2;
  }

  public void push_front(int data) {
    if (head == 0) {
      System.out.println("Deque is full at the front");
      return;
    }
    deque[--head] = data;
  }

  public void push_back(int data) {
    if (tail == capacity) {
      System.out.println("Deque is full at the back");
      return;
    }
    deque[tail++] = data;
  }

  public int pop_front() {
    if (isEmpty()) {
      return -1;
    }
    return deque[head++];
  }

  public int pop_back() {
    if (isEmpty()) {
      return -1;
    }
    return deque[--tail];
  }

  public int front() {
    if (isEmpty()) {
      return -1;
    }
    return deque[head];
  }

  public int back() {
    if (isEmpty()) {
      return -1;
    }
    return deque[tail - 1];
  }

  public int size() {
    return tail - head;
  }

  public int empty() {
    return isEmpty() ? 1 : 0;
  }

  private boolean isEmpty() {
    return tail == head;
  }
}

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int n = Integer.parseInt(br.readLine());

    ArrDeque deque = new ArrDeque(10000); // 명령의 수 N외 최댓값으로 가정

    for (int i = 0; i < n; i++) {
      String[] command = br.readLine().split(" ");

      switch (command[0]) {
        case "push_front":
          deque.push_front(Integer.parseInt(command[1]));
          break;
        case "push_back":
          deque.push_back(Integer.parseInt(command[1]));
          break;
        case "pop_front":
          sb.append(deque.pop_front()).append("\n");
          break;
        case "pop_back":
          sb.append(deque.pop_back()).append("\n");
          break;
        case "size":
          sb.append(deque.size()).append("\n");
          break;
        case "empty":
          sb.append(deque.empty()).append("\n");
          break;
        case "front":
          sb.append(deque.front()).append("\n");
          break;
        case "back":
          sb.append(deque.back()).append("\n");
          break;
      }
    }

    System.out.print(sb.toString());
  }
}
