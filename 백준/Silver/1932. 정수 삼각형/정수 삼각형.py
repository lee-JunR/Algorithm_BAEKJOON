import sys
input = sys.stdin.readline

# input
n = int(input())
tri = [list(map(int, input().split())) for _ in range(n)]


for i in range(1, n):
    for j in range(i+1):
        if j != 0 and j != i:
            tri[i][j] = tri[i][j] + max(tri[i-1][j], tri[i-1][j-1])
        elif j == 0:
            tri[i][j] = tri[i][j] + tri[i-1][j]
        elif j == i:
            tri[i][j] = tri[i][j] + tri[i-1][j-1]
print(max(tri[n-1]))
