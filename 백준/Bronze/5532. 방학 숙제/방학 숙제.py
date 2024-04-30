import sys
from math import ceil

def calculate_duration(amount, max_pages_per_day):
    return ceil(amount / max_pages_per_day)

# INPUT
input = sys.stdin.readline
vacation = int(input()) # 방학 일수
# 풀어야하는 페이지 수
A = int(input()) # 국어
B = int(input()) # 수학
# 하루에 풀 수 있는 최대 페이지
C = int(input()) # 국어
D = int(input()) # 수학

# OUTPUT
print(vacation - max(calculate_duration(A, C), calculate_duration(B, D))) # 끝내는 기한을 계산하여 걸리는 날이 큰 기한을 방학 기한에 뺌