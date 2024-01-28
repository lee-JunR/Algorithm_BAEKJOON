N = int(input())
A = list(map(int, input().split()))

dp = [0] * N
maxA = max(A)
if maxA < 0:
    print(maxA)
else:
    for i in range(N):
        if i == 0:
            dp[0] = A[0]
        else:
            dp[i] = A[i] + dp[i - 1]
            if dp[i] < 0:
                dp[i] = 0
    print(max(dp))