N = int(input())
a = [int(input()) for _ in range(N)]

dp = [0] * N
if N == 1:
    dp[0] = a[0]
    print(a[0])
elif N == 2:
    dp[0] = a[0]
    dp[1] = a[0] + a[1]
    print(dp[1])
elif N == 3:
    dp[0] = a[0]
    dp[1] = a[0] + a[1]
    dp[2] = a[2] + max(a[0], a[1])
    print(dp[2])
else:
    dp[0] = a[0]
    dp[1] = a[0] + a[1]
    dp[2] = a[2] + max(a[0], a[1])
    for i in range(3, N):
        dp[i] = a[i] + max(dp[i - 2], dp[i - 3] + a[i - 1])
    print(dp[-1])
