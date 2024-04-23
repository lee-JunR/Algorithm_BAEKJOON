import sys

def solution(input):
    input = input.split('-')
    answer = 0

    for i in input[0].split('+'):
        answer += int(i)

    for i in range(1, len(input)):
        for j in input[i].split('+'):
            answer -= int(j)
    return answer

input = sys.stdin.readline().strip('\n')
print(solution(input))