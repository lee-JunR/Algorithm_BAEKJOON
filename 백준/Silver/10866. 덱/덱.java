import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        Deque<String> deque = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            String[] command = br.readLine().split(" ");

            switch (command[0]) {
                case "push_front":
                    deque.addFirst(command[1]);
                    break;
                case "push_back":
                    deque.addLast(command[1]);
                    break;
                case "pop_front":
                    if (deque.isEmpty()) {
                        sb.append("-1\n");
                    } else {
                        sb.append(deque.removeFirst()).append("\n");
                    }
                    break;
                case "pop_back":
                    if (deque.isEmpty()) {
                        sb.append("-1\n");
                    } else {
                        sb.append(deque.removeLast()).append("\n");
                    }
                    break;
                case "size":
                    sb.append(deque.size()).append("\n");
                    break;
                case "empty":
                    sb.append(deque.isEmpty() ? "1\n" : "0\n");
                    break;
                case "front":
                    if (deque.isEmpty()) {
                        sb.append("-1\n");
                    } else {
                        sb.append(deque.peekFirst()).append("\n");
                    }
                    break;
                case "back":
                    if (deque.isEmpty()) {
                        sb.append("-1\n");
                    } else {
                        sb.append(deque.peekLast()).append("\n");
                    }
                    break;
            }
        }

        System.out.print(sb.toString());
    }
}