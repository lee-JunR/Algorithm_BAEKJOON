import sys
sys.setrecursionlimit(10000)

T = int(sys.stdin.readline())
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def dfs(x, y, graph, visited):
  if x <= -1 or x >= len(graph) or y <= -1 or y >= len(graph[0]):
    return

  if (x, y) in visited or graph[x][y] == 0:
    return

  visited.add((x, y))

  for i in range(4):
    dfs(x + dx[i], y + dy[i], graph, visited)

def main():
  for _ in range(T):
    m, n, k = map(int, sys.stdin.readline().split())
    graph = [[0] * m for _ in range(n)]

    for _ in range(k):
      x, y = map(int, input().split())
      graph[y][x] = 1

    visited = set()
    count = 0
    for i in range(n):
      for j in range(m):
        if (i, j) not in visited and graph[i][j] == 1:
          dfs(i, j, graph, visited)
          count += 1

    print(count)

if __name__ == "__main__":
  main()