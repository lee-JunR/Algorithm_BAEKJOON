import sys

# INPUT
N = int(sys.stdin.readline())  # 집의 개수 N
costs = [list(map(int, sys.stdin.readline().split())) for _ in range(N)] # 각 집당 칠하는 비용.


# DP 테이블 초기화
# dp[i][j]는 i번째 집을 j색(0: 빨강, 1: 초록, 2: 파랑)으로 칠할 때의 최소 비용
dp = [[0] * 3 for _ in range(N)]

# 첫 번째 집의 색칠 비용을 초기화
dp[0] = costs[0]

# 두 번째 집부터 마지막 집까지 순회하면서 최소 비용을 계산
for i in range(1, N):
    dp[i][0] = costs[i][0] + min(dp[i - 1][1], dp[i - 1][2])
    dp[i][1] = costs[i][1] + min(dp[i - 1][0], dp[i - 1][2])
    dp[i][2] = costs[i][2] + min(dp[i - 1][0], dp[i - 1][1])

# 모든 집을 칠한 후, 마지막 집에 대해 최소 비용을 찾음
minimum_cost = min(dp[-1])

print(minimum_cost)
