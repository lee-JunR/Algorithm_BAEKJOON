def count_ways(n):
    # 초기화
    dp = [0] * (n + 1)

    # 초기 조건 설정
    dp[0] = 1
    dp[1] = 1

    # 동적 계획법을 사용한 방법의 수 계산
    for i in range(2, n + 1):
        dp[i] = dp[i - 1] + dp[i - 2]

    return dp[n]


# 2x9 직사각형의 경우
print(count_ways(int(input()))%10_007)