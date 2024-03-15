import sys
def find_receiver_tower(heights):
    stack = []
    receivers = [0] * len(heights)

    for i in range(len(heights) - 1, -1, -1):
        # 스택이 비어있지 않고, 스택의 탑이 현재 탑보다 높을 때
        while stack and heights[stack[-1]] < heights[i]:
            receiver = stack.pop()
            receivers[receiver] = i + 1  # 수신하는 탑의 번호 기록

        stack.append(i)  # 현재 탑을 스택에 추가

    return receivers


# 입력 받기
N = int(sys.stdin.readline())
heights = list(map(int, sys.stdin.readline().split()))

# 결과 계산
result = find_receiver_tower(heights)

# 결과 출력
print(*result)
