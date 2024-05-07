from collections import deque

def solution(x, y, n):
    # 큐와 방문한 노드를 저장할 set
    queue = deque([(x, 0)])  # (현재 값, 연산 횟수)
    visited = set([x])

    while queue:
        current, operations = queue.popleft()

        if current == y:
            return operations  # `y`에 도달했을 때 연산 횟수 반환

        # 다음 가능한 연산을 계산
        # 1. `n` 더하기
        next1 = current + n
        # 2. 2배 곱하기
        next2 = current * 2
        # 3. 3배 곱하기
        next3 = current * 3

        # 각각에 대해 범위 안이고 방문하지 않은 경우 큐에 추가
        if next1 <= y and next1 not in visited:
            queue.append((next1, operations + 1))
            visited.add(next1)
        
        if next2 <= y and next2 not in visited:
            queue.append((next2, operations + 1))
            visited.add(next2)
        
        if next3 <= y and next3 not in visited:
            queue.append((next3, operations + 1))
            visited.add(next3)

    # 큐가 비었는데 `y`에 도달하지 못했다면
    return -1