n, k = map(int, input().split())
coin_values = [int(input()) for _ in range(n)]

# dp[i]: 동전을 사용해서 가치 i를 만들 수 있는 경우의 수
dp = [0] * (k + 1)
dp[0] = 1  # 가치 0을 만들기 위한 경우의 수는 1가지 (아무 동전도 사용하지 않는 경우)

for coin_value in coin_values:
    for i in range(coin_value, k + 1):
        dp[i] += dp[i - coin_value]

result = dp[k] % (2**31)  # 경우의 수가 2**31 미만이어야 하므로 나머지 연산을 수행
print(result)