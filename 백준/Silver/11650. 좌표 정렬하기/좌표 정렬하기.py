import sys

N = int(input())
points = []
for i in range(N):
    points.append(list(map(int,sys.stdin.readline().split())))

points = sorted(points)

for i in range(N):
    print(*points[i])