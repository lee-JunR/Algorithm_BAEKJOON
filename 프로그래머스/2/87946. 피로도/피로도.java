class Solution {

  static int[][] board;
  static boolean[] visited;
  int answer = 0;

  public int solution(int k, int[][] dungeons) {

    board = dungeons;
    visited = new boolean[board.length];
    backtracking(k, 0);
    return answer;
  }

  private void backtracking(int curK, int count) {
    if(count > answer){
      answer = count;
    }
    //recursive call
    for (int i = 0; i < board.length; i++) {
      // base case 필요 피로도보다 현재 피로도보다 크면
      if (curK >= board[i][0] && !visited[i]){
        visited[i] = true;
        backtracking(curK - board[i][1], count + 1);
        visited[i] = false;
      }
    }
  }
}