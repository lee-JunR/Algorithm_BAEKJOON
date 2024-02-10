def knapsack_max_value(N, K, weights, values):
    # DP 테이블 초기화
    dp = [[0] * (K + 1) for _ in range(N + 1)]

    # 물건을 하나씩 고려하여 DP 테이블 채우기
    for i in range(1, N + 1):
        for w in range(1, K + 1):
            # 현재 물건을 배낭에 넣을 수 있는 경우
            if weights[i - 1] <= w:
                # 현재 물건을 선택하는 경우와 선택하지 않는 경우 중 큰 가치 선택
                dp[i][w] = max(values[i - 1] + dp[i - 1][w - weights[i - 1]], dp[i - 1][w])
            else:
                # 현재 물건을 배낭에 넣을 수 없는 경우
                dp[i][w] = dp[i - 1][w]

    # 최적해의 가치 반환
    return dp[N][K]

# 입력 받기
N, K = map(int, input().split())
weights = []
values = []

for _ in range(N):
    W, V = map(int, input().split())
    weights.append(W)
    values.append(V)

# 최대 가치 계산 및 출력
result = knapsack_max_value(N, K, weights, values)
print(result)