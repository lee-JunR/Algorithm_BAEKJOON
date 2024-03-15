def knapsack(N, K, weights, values):
    dp = [[0] * (K + 1) for _ in range(N + 1)]
    
    for i in range(1, N + 1):
        for j in range(1, K + 1):
            if weights[i - 1] <= j:
                dp[i][j] = max(dp[i - 1][j], values[i - 1] + dp[i - 1][j - weights[i - 1]])
            else:
                dp[i][j] = dp[i - 1][j]
    
    return dp[N][K]

N, K = map(int, input().split())
weights = []
values = []
for _ in range(N):
    w, v = map(int, input().split())
    weights.append(w)
    values.append(v)

print(knapsack(N, K, weights, values))
