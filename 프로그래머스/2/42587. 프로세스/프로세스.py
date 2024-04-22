from collections import deque

def solution(priorities, location):
    # 큐를 deque로 생성하고, 각 프로세스의 우선순위와 위치를 함께 저장
    queue = deque((priority, idx) for idx, priority in enumerate(priorities))
    execution_order = 0  # 몇 번째로 실행되는지 기록

    while queue:
        current = queue.popleft()  # 맨 앞 프로세스 제거

        # 큐에 더 높은 우선순위가 있는지 확인
        if any(current[0] < q[0] for q in queue):
            queue.append(current)  # 우선순위가 더 높으면 뒤로 보냄
        else:
            # 우선순위가 가장 높으므로 실행
            execution_order += 1  # 실행 순서 증가

            # 현재 프로세스가 목표 프로세스인지 확인
            if current[1] == location:
                return execution_order  # 해당 프로세스의 실행 순서 반환