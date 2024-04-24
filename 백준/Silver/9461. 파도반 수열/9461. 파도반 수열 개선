def generate_dp(max_val):
    dp = [1] * 3 + [2] * 2  # 초기값 설정
    while len(dp) <= max_val:
        next_val = dp[-1] + dp[-5]  # 이전 5개 범위의 연산
        dp.append(next_val)
    return dp


# 입력 수집
T = int(input())  # 몇 개의 입력이 있는지
N = [int(input()) for _ in range(T)]  # T개의 입력 수집

# 가장 큰 값을 찾고, 해당 값을 기반으로 dp를 생성
max_input = max(N)
dp = generate_dp(max_input)

# 입력 값에 따른 결과 출력
for value in N:
    print(dp[value - 1])
