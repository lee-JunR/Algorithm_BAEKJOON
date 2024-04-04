import math

def find_divisors(n):
    divisors_list = []
    for i in range(3, int(math.sqrt(n)) + 1):
        if n % i == 0:
            divisors_list.append([n // i, i])
    return divisors_list


def solution(brown, yellow):
    # 1. brown과 yellow 의 합의 약수를 구한 후 약수에서 구하기
    entire_carpet_size = brown + yellow
    for answer in find_divisors(entire_carpet_size):
        if (answer[0] * 2 + answer[1] * 2 - 4) == brown:
            return answer