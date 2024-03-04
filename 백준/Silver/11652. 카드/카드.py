import sys
from collections import Counter\

def find_max(cards):
    counter = Counter(cards) # Counter 함수로 각 리스트별 중복횟수 dict 형식으로 변환
    max_count = -1
    for number in counter:
        if counter[number] > max_count:
            max_count = counter[number]
            max_number = number
        elif (counter[number] == max_count) and (number < max_number): # 가장 많이 가지고 있는 정수가 여러가지라면 작은것을 출력해야하니깐
            max_number = number
    return max_number

# input
N = int(sys.stdin.readline())
cards = [int(sys.stdin.readline()) for _ in range(N)]

# output
print(find_max(cards))