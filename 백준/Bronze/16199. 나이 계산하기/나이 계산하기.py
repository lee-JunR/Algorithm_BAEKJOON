import sys
import datetime

def calculate_duration(date_of_birth, now):
    # 세는 나이 계산
    연_나이 = now.year - date_of_birth.year

    # 만 나이 계산
    if (now.month, now.day) < (date_of_birth.month, date_of_birth.day): # 생일이 지나지 않았으면 만 나이에서 1을 뺌
        만_나이 = 연_나이 - 1
    else:
        만_나이 = 연_나이

    # 세는 나이는 연나이 + 1
    세는_나이 = 연_나이 + 1
    return [만_나이, 세는_나이, 연_나이]

# INPUT
input = sys.stdin.readline
date_of_birth = list(map(int, input().split()))
date_of_birth = datetime.datetime(date_of_birth[0], date_of_birth[1], date_of_birth[2])
now = list(map(int, input().split()))
now = datetime.datetime(now[0], now[1], now[2])

# OUTPUT
for i in calculate_duration(date_of_birth, now):
    print(i)