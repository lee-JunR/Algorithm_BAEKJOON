from collections import defaultdict

def dfs(node, graph, visited):
    # 시작 노드를 방문한 것으로 표시하고, 해당 노드를 포함하여 현재 연결된 노드의 개수를 1로 초기화
    visited.add(node)
    count = 1
    # 연결 노드들에 재귀적으로 dfs 함수를 호출하여 이웃 노드를 방문하여 count 누적.
    for neighbor in graph[node]:
        if neighbor not in visited:
            count += dfs(neighbor, graph, visited)
    return count

def solution(n, wires):
    # 그래프 구성
    graph = defaultdict(list)
    for v1, v2 in wires:
        graph[v1].append(v2)
        graph[v2].append(v1)
    min_diff = float('inf')
    for v1, v2 in wires:
        # 전선 한 개를 끊어서 두 서브트리로 나누기
        graph[v1].remove(v2)
        graph[v2].remove(v1)

        # 각 서브트리의 노드 수 계산
        visited = set()
        count1 = dfs(v1, graph, visited)
        count2 = n - count1

        # 두 서브트리의 노드 수 차이의 최솟값 갱신
        min_diff = min(min_diff, abs(count1 - count2))

        # 그래프 복원
        graph[v1].append(v2)
        graph[v2].append(v1)

    return min_diff