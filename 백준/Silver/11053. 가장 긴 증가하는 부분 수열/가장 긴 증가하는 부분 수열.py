def lis_dynamic_programming(arr):
    lis = [1] * n

    for i in range(1, n):
        for j in range(0, i):
            if arr[i] > arr[j] and lis[i] < lis[j] + 1:
                lis[i] = lis[j] + 1

    return max(lis)

# 사용자 입력 받기
n = int(input())
A = list(map(int, input().split()))

result = lis_dynamic_programming(A)
print(result)