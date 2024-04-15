from collections import defaultdict, deque

def dfs(graph, start):
    visited = set()
    stack = [start]
    result = []

    while stack:
        vertex = stack.pop()
        if vertex not in visited:
            visited.add(vertex)
            result.append(vertex)
            stack.extend(sorted(graph[vertex], reverse=True))
    
    return result

def bfs(graph, start):
    visited = set()
    queue = deque([start])
    result = []

    while queue:
        vertex = queue.popleft()
        if vertex not in visited:
            visited.add(vertex)
            result.append(vertex)
            queue.extend(sorted(graph[vertex]))
    
    return result

# 입력 받기
N, M, V = map(int, input().split())
graph = defaultdict(list)

for _ in range(M):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

# DFS와 BFS 수행
dfs_result = dfs(graph, V)
bfs_result = bfs(graph, V)

# 결과 출력
print(' '.join(map(str, dfs_result)))
print(' '.join(map(str, bfs_result)))
