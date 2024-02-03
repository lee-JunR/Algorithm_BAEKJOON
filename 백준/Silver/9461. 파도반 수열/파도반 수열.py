T = int(input())
N = [int(input()) for _ in range(T)]
N_sorted = N.copy()
N_sorted.sort()

dp = [1] * 3 + [2] * 2 + 95 * [0]


def P(N):
    if N_sorted[-1] < 5:
        return dp
    for i in range(4, N_sorted[-1]):
        dp[i] = dp[i-5] + dp[i-1]
    return dp
dp = P(N)
for i in N :
    print(dp[i-1])