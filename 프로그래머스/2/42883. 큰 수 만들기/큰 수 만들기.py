def solution(number, k):
    stack = []
    
    for num in number:
        # 스택에 있는 숫자가 현재 숫자보다 작으면 스택에서 제거
        while stack and k > 0 and stack[-1] < num:
            stack.pop()
            k -= 1
        
        stack.append(num)

    # k개의 숫자가 제거되지 않았을 경우, 남은 수 중에서 뒤에서부터 제거
    while k > 0:
        stack.pop()
        k -= 1
        
    return ''.join(stack)