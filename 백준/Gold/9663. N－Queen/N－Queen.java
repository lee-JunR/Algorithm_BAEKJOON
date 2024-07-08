// N-Queen 9663

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  private static int count = 0;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    br.close();

    countNQueens(n);
    System.out.println(count);
  }

  private static boolean isSafe(int[] board, int row, int col) {
    for (int i = 0; i < row; i++) {
      if (board[i] == col ||
          board[i] - i == col - row ||
          board[i] + i == col + row) {
        return false;
      }
    }
    return true;
  }

  private static void placeQueens(int[] board, int row, int n) {
    if (row == n) { // 모든 행에 퀸 배치.
      count++;
      return;
    }

    for (int col = 0; col < n; col++) {
      if (isSafe(board, row, col)) { // 각열에 퀸을 배치해보고 isSafe로 확인.
        board[row] = col;
        placeQueens(board, row + 1, n);
      }
    }
  }

  private static void countNQueens(int n) {
    int[] board = new int[n];
    placeQueens(board, 0, n);
  }
}
