def count_stair_numbers(N):
    if N == 1:
        return 9  # 길이가 1인 경우 1부터 9까지 9개의 계단 수가 있습니다.

    # dp[i][j]: 길이가 i이고 마지막 숫자가 j인 계단 수의 개수
    dp = [[0] * 10 for _ in range(N + 1)]

    # 길이가 1인 경우 초기화
    for i in range(1, 10):
        dp[1][i] = 1

    # 길이가 2 이상인 경우
    for i in range(2, N + 1):
        for j in range(10):
            if j == 0:
                dp[i][j] = dp[i - 1][1]
            elif j == 9:
                dp[i][j] = dp[i - 1][8]
            else:
                dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j + 1]

    return sum(dp[N])

# 예시: 길이가 2인 계단 수의 개수 구하기
N = int(input())
print(count_stair_numbers(N)%1_000_000_000)