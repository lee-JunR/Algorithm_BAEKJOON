import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.IntFunction;

public class Main {

  static int n, m;
  static int[][] graph;
  static boolean[][] visited;
  static int count = 0;
  static int[][] pos = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};


  static void bfs(int x, int y) {
    visited[x][y] = true;
    Queue<int[]> queue = new LinkedList<>();
    queue.add(new int[]{x, y});

    while (!queue.isEmpty()) {
      int[] arr = queue.poll();
      int nowX = arr[0];
      int nowY = arr[1];

      for (int i = 0; i < pos.length; i++) {
        int nx = nowX + pos[i][0];
        int ny = nowY + pos[i][1];

        if (nx >= 0 && nx < n && ny >= 0 && ny < m && graph[nx][ny] == 1 && !visited[nx][ny]) {
          count++;
          visited[nx][ny] = true;
          queue.add(new int[]{nx, ny});
        }
      }
    }

  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] input = br.readLine().split(" ");
    n = Integer.parseInt(input[0]);
    m = Integer.parseInt(input[1]);
    boolean isZero = true;
    List<Integer> answer = new ArrayList<>();

    graph = new int[n][m];
    visited = new boolean[n][m];

    for (int i = 0; i < n; i++) {
      String[] inputArr = br.readLine().split(" ");
      for (int j = 0; j < m; j++) {
        graph[i][j] = Integer.parseInt(inputArr[j]);
        if (graph[i][j] == 1) {
          isZero = false;
        }
      }
    }

    if (isZero == true) {
      System.out.println("0");
      System.out.println("0");
      return;
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        count = 0;
        if (graph[i][j] == 1 && !visited[i][j]) {
          count++;
          bfs(i, j);
          answer.add(count);
        }
      }
    }
    Collections.sort(answer);
    System.out.println(answer.size());
    System.out.println(answer.get(answer.size() - 1));

    br.close();
  }
}
