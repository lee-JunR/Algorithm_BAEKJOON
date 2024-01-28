N = int(input())
A = list(map(int, input().split()))
A_reverse= A[::-1]
dp_Max = N * [1]
dp_Min = N * [1]
for i in range(N):
    for j in range(i):
        if A[i] > A[j]:
            dp_Max[i] = max(dp_Max[i], dp_Max[j] + 1)
        if A_reverse[i] > A_reverse[j]:
            dp_Min[i] = max(dp_Min[i], dp_Min[j] + 1)
for i in range(N):
    A[i] = dp_Max[i] + dp_Min[N-i-1] -1

print(max(A))