def solution(numbers):
    
    # 정렬을 위해 비교 기준을 정의
    def custom_key(x):
        # 동일한 정렬 기준을 위해, x를 두 번 반복하여 문자열 비교
        return x * 4  # 3번 반복하면 최대 1000을 3자리 수로 커버 가능
    
    answer = ''
    numbers = list(map(str, numbers))
    numbers.sort(key=custom_key, reverse=True)
    
    return '0' if numbers[0] == '0' else answer.join(numbers)
