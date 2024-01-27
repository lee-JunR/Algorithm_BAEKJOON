# 2156
N = int(input())
w = [int(input()) for _ in range(N)]

dp = [0] * N
dp[0] = w[0]
if N == 1:
    print(dp[0])
elif N == 2:
    dp[1] = w[0] + w[1]
    print(dp[1])
else:
    dp[1] = w[0] + w[1]
    for i in range(2, N):
        dp[i] = max(dp[i - 1], dp[i - 2] + w[i], dp[i - 3] + w[i - 1] + w[i]) # 점화식
    print(dp[-1])



# 더 빠른 버전
# n=int(input())
# array=[0]*10000
# for i in range(n):
#   array[i]=int(input())
#
# d=[0]*10000
# d[0]=array[0]
# d[1]=array[0]+array[1]
# d[2]=max(array[2]+array[0], array[2]+array[1], d[1])
# for i in range(3,n):
#   d[i]=max(array[i]+d[i-2], array[i]+array[i-1]+d[i-3], d[i-1])
#
# print(max(d))
