def fib(N):
    if dp[N] == -1:
        dp[N] = fib(N-1) + fib(N-2)
    return dp[N]

dp = [-1] * 90
dp[0] = 1
dp[1] = 1
print(fib(int(input())-1))