def solution(numbers):
    memo = {}  # 메모이제이션을 위한 딕셔너리
    
    def calculate_sum(i, j):
        # 이미 계산한 값이 있는 경우 메모된 값을 반환
        if (i, j) in memo:
            return memo[(i, j)]
        
        # 두 수의 합을 계산하고 메모에 저장
        memo[(i, j)] = numbers[i] + numbers[j]
        return memo[(i, j)]
    
    result_set = set()
    n = len(numbers)
    
    for i in range(n):
        for j in range(i+1, n):
            result_set.add(calculate_sum(i, j))
    
    result = sorted(result_set)
    
    return result