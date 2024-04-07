def solution(numbers):
    answer = []
    for i in range(len(numbers)):
        for j in range(i + 1, len(numbers)):  # i 이후의 인덱스만 확인
            sum_num = numbers[i] + numbers[j]
            if sum_num not in answer:  # 중복 확인
                answer.append(sum_num)
    answer.sort()  # 결과 정렬
    return answer