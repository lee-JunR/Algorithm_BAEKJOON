def fib_dp(n):
    if dp[n] == -1:
        dp[n] = fib_dp(n-1) + fib_dp(n-2)
    return dp[n]

dp = [-1]*46
dp[0] = 0
dp[1] = 1
print(fib_dp(int(input())))