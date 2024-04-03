import math

def solution(number, limit, power):
    answer = 0
    divisors = count_divisors(number)

    for i in divisors:
        if i > limit:
            answer += power
        else:
            answer += i
    return answer
def count_divisors(number):
    divisors_list = [-1] + [1] + [0] * 99_999  # -1은 index를 위해 버리는 수
    
    for i in range(2, number + 1):
        root_i = int(math.sqrt(i))
        for j in range(1, root_i + 1):
            if i % j == 0:
                divisors_list[i] += 1
        if root_i * root_i == i:
            divisors_list[i] = divisors_list[i] * 2 - 1
        else:
            divisors_list[i] = divisors_list[i] * 2
    return divisors_list[1:number + 1]
