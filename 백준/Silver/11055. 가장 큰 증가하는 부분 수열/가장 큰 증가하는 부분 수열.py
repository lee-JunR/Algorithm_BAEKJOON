N = int(input())
A = [0] + list(map(int, input().split()))
dp = [0] * (N + 1)
for i in range(N+1):
    for j in range(i):
        if A[i] > A[j]:
            dp[i] = max(dp[i] , dp[j] + A[i])
print(max(dp))