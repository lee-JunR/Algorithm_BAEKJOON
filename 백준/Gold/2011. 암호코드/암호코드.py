def count_decodings(cipher):
    n = len(cipher)
    mod = 1000000
    dp = [0] * (n + 1)
    dp[0] = 1

    for i in range(1, n + 1):
        if 1 <= int(cipher[i - 1]):
            dp[i] = (dp[i] + dp[i - 1]) % mod
        if i > 1 and 10 <= int(cipher[i - 2:i]) <= 26:
            dp[i] = (dp[i] + dp[i - 2]) % mod

    return dp[n]

# 입력 받기
cipher = input().strip()

# 해석의 가짓수 계산
result = count_decodings(cipher)

# 결과 출력
print(result)