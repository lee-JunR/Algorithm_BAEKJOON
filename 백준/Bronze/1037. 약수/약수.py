count = int(input())
A = list(map(int, input().split()))
A.sort()
print(A[0] * A[len(A) - 1])