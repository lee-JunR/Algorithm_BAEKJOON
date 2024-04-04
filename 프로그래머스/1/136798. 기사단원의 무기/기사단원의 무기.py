def count_divisors(number):
    divisors_count = [0] * (number + 1)

    for i in range(1, number+1):
        if i <= (number)//2:
            for j in range(i, number + 1, i):
                divisors_count[j] += 1
        else:
            divisors_count[i] += 1
    return divisors_count

def solution(number, limit, power):
    divisors_count = count_divisors(number)
    answer = 0

    for count in divisors_count[1:number + 1]:
        if count > limit:
            answer += power
        else:
            answer += count

    return answer