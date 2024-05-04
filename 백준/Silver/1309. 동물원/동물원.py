import sys

input = sys.stdin.readline

n = int(input())

# dp 배열 초기화
dp = [[0, 0, 0] for _ in range(n + 1)]

# 첫 번째 열의 기본 배치
dp[1] = [1, 1, 1]  # 초기 상태는 세 가지 모두 가능

for i in range(2, n + 1):
    dp[i][0] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2]) % 9901
    dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % 9901
    dp[i][2] = (dp[i - 1][0] + dp[i - 1][1]) % 9901

result = (dp[n][0] + dp[n][1] + dp[n][2]) % 9901

# 결과 출력
print(result)
