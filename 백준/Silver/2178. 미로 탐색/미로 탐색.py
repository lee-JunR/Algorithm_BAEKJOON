from collections import deque
import sys




def shortest_path(maze, n, m):
    # 방향 이동을 위한 배열: 상하좌우
    directions = [(-1, 0), (1, 0), (0, -1), (0, 1)]
    # 방문 기록을 위한 배열
    visited = [[False for _ in range(m)] for _ in range(n)]
    # BFS를 위한 큐
    queue = deque([(0, 0, 1)])  # 시작 위치 (row, column, distance)
    visited[0][0] = True

    while queue:
        row, col, distance = queue.popleft()
        # 도착 위치에 도달한 경우
        if row == n - 1 and col == m - 1:
            return distance

        # 4방향으로 이동
        for dr, dc in directions:
            new_row = row + dr
            new_col = col + dc
            # 미로의 범위를 벗어나지 않고, 이동할 수 있는 칸이며, 아직 방문하지 않은 경우
            if 0 <= new_row < n and 0 <= new_col < m and maze[new_row][new_col] == 1 and not visited[new_row][new_col]:
                queue.append((new_row, new_col, distance + 1))
                visited[new_row][new_col] = True


# 입력 예시
input = sys.stdin.readline
N, M = map(int, input().split())
maze = [list(map(int, ' '.join(input().split()))) for _ in range(N)]

print(shortest_path(maze, N, M))