import sys

N = int(input())
points = []

# input
for i in range(N):
    points.append(list(map(int, sys.stdin.readline().split())))
    points[i].reverse()

points = sorted(points)

# output
for i in range(N):
    points[i].reverse()
    print(*points[i])
