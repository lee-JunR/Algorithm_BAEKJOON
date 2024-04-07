def solution(numbers):
    result_set = set()  
    n = len(numbers)
    
    for i in range(n):
        for j in range(i+1, n):
            result_set.add(numbers[i] + numbers[j])
    
    result = sorted(list(result_set))
    
    return result