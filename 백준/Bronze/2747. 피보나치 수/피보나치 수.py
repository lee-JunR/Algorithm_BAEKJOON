m = int(input())
dp = [0] * (m+1)
dp[1] = 1
for i in range(2, m+1):
    dp[i] = dp[i-1] + dp[i-2]
print(dp[m])