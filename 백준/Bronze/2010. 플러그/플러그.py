import sys
input = sys.stdin.readline

n = int(input())

# 멀티탭의 플러그 수 목록
total_plugs = 0
for i in range(n):
    total_plugs += int(input())

# 멀티탭의 연결 때문에 실제 사용할 수 있는 플러그 수 계산
usable_plugs = total_plugs - (n - 1)

print(usable_plugs)
