// N-Queen 9663

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    br.close();

    System.out.println(countNQueens(n));
  }

  private static boolean isSafe(int[] board, int row, int col, int n) {
    for (int i = 0; i < row; i++) {
      if (board[i] == col ||
          board[i] - i == col - row ||
          board[i] + i == col + row) {
        return false;
      }
    }
    return true;
  }

  private static void countNQueensUtil(int[] board, int row, int n, int[] count) {
    if (row == n) {
      count[0]++;
      return;
    }

    for (int col = 0; col < n; col++) {
      if (isSafe(board, row, col, n)) {
        board[row] = col;
        countNQueensUtil(board, row + 1, n, count);
      }
    }
  }

  private static int countNQueens(int n) {
    int[] count = {0};
    int[] board = new int[n];
    countNQueensUtil(board, 0, n, count);
    return count[0];
  }
}
