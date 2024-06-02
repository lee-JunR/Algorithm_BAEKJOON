def calculate_sum(K, numbers):
    dp = [0] * (K + 1) 
    index = 0

    for i in range(K):
        if numbers[i] == 0:
            index -= 1
        else:
            index += 1
            dp[index] = dp[index - 1] + numbers[i]

    return dp[index]


K = int(input())
numbers = [int(input()) for _ in range(K)]

print(calculate_sum(K, numbers))
