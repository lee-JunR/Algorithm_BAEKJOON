import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  static char[][] board;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int n = Integer.parseInt(br.readLine()); // n = 3^k 형태. 3, 9, 27
    board = new char[n][n];

    //board 초기화
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board.length; j++) {
        board[i][j] = '*';
      }
    }

    recursion(n, 0, 0);

    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board.length; j++) {
        sb.append(board[i][j]);
      }
      sb.append("\n");
    }

    System.out.println(sb.toString());
  }

  private static void recursion(int n, int r, int c) {
    if (n == 3) {
      board[r + 1][c + 1] = ' '; // 가운데를 비운다.
      return;
    }

    int oneThird = n / 3;

    for (int i = r + oneThird; i < r + 2 * oneThird; i++) {
      for (int j = c + oneThird; j < c + 2 * oneThird; j++) {
        board[i][j] = ' ';
      }
    }
    // 0 ~ m-1
    recursion(oneThird, r, c);
    recursion(oneThird, r, c + oneThird);
    recursion(oneThird, r, c + oneThird * 2);

    recursion(oneThird, r + oneThird, c);
    recursion(oneThird, r + oneThird, c + oneThird);
    recursion(oneThird, r + oneThird, c + 2 * oneThird);

    recursion(oneThird, r + oneThird * 2, c);
    recursion(oneThird, r + oneThird * 2, c + oneThird);
    recursion(oneThird, r + oneThird * 2, c + 2 * oneThird);


  }


}
