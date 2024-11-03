import java.util.*;

class Solution {
    static int[][] grid;
    static boolean[][] vis;
    static int N; // length of r
    static int M; // length of c
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    
    public int solution(int[][] maps) {
        grid = maps;
        N = grid.length;
        M = grid[0].length;
        vis = new boolean[N][M];
        
        return bfs(0,0);
    }
    
    private int bfs(int r, int c){
        Queue<Node> que = new ArrayDeque<>();
        
        //첫 노드 큐에 넣기
        que.add(new Node(r,c,1));
        vis[r][c] = true;
        
        while(!que.isEmpty()){
            // 하나씩 큐에 등록하자
            for(int i=0; i < que.size() ; i++){
                //첫번째 큐 실행
                Node cur = que.poll();
                
                
                // base case
                if(cur.r == N-1 && cur.c == M-1){
                    return cur.dist;
                }
                
                for(int j = 0; j < 4 ; j++){
                    int nr = cur.r + dr[j];
                    int nc = cur.c + dc[j];
                    
                    if(isValid(nr, nc)){
                        que.add(new Node(nr, nc, cur.dist+1));
                        vis[nr][nc] = true;
                    }
                    
                }
            }
        }
        return -1;
    }
    public boolean isValid(int r, int c){
        return (0<= r && r < N) && (0 <= c && c < M) && (grid[r][c] == 1) && (!vis[r][c]);
    }
    
    class Node{
        int r;
        int c;
        int dist;
        
        public Node(int r, int c, int dist){
            this.r = r;
            this.c = c;
            this.dist = dist;
        }
    }
}