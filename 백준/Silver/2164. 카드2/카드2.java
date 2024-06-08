// 카드2 2164

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // input
    int numberOfCards = Integer.parseInt(br.readLine());
    ArrQueue queue = new ArrQueue(numberOfCards);

    while (queue.size() > 1) {
      queue.pop(); // 제일 위의 카드를 버림
      queue.push(queue.pop()); // 제일 위의 카드를 아래로 옮김
    }

    // 마지막으로 남는 카드 출력
    System.out.println(queue.pop());
    br.close();
  }
}

class ArrQueue {

  private int[] queue; // 원소를 담을 배열
  private int head = 0;
  private int tail = 0;
  private int size;
  private int capacity;

  public ArrQueue(int capacity) {
    this.capacity = capacity;
    this.queue = new int[capacity];
    for (int i = 0; i < capacity; i++) {
      queue[i] = i + 1;
    }
    this.size = capacity;
  }

  public int pop() {
    if (!isEmpty()) {
      int value = queue[head];
      head = (head + 1) % capacity;
      size--;
      return value;
    }
    return -1; // 큐가 비었을 때 -1 리턴
  }

  public void push(int data) {
    queue[tail] = data;
    tail = (tail + 1) % capacity;
    size++;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public int size() {
    return size;
  }
}