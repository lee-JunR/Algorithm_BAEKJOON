from collections import deque

# 우선순위를 고려한 큐 운영체제 프로세스 실행 순서 확인 함수
def solution(priorities, location):
    # 큐에 프로세스의 우선순위와 해당 프로세스의 원래 위치를 저장
    queue = deque((priority, idx) for idx, priority in enumerate(priorities))
    execution_order = 0

    while queue:
        # 큐의 맨 앞 프로세스 선택
        current = queue.popleft()

        # 큐에 남아있는 프로세스 중 우선순위가 더 높은 것이 있는지 확인
        if any(current[0] < q[0] for q in queue):
            # 우선순위가 더 높은 프로세스가 있다면 다시 큐에 추가
            queue.append(current)
        else:
            # 우선순위가 더 높은 프로세스가 없다면 실행하고 종료
            execution_order += 1
            # 만약 해당 프로세스가 찾고자 하는 프로세스라면 순서를 반환
            if current[1] == location:
                return execution_order

    return execution_order