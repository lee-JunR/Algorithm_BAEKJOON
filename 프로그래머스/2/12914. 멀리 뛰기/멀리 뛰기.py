def solution(n):
    if n <= 1:
        return 1

    memo = [0] * 2000
    memo[1] = 1
    memo[2] = 2

    for i in range(3, n + 1):
        memo[i] = (memo[i - 1] + memo[i - 2]) % 1234567

    return memo[n]