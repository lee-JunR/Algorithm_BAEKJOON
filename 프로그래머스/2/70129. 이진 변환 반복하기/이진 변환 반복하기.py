def solution(s):
    answer = [0,0] # [이진변환 횟수, 제거된 0 갯수]

    def 이진변환(s):
        answer[0] += 1
        answer[1] += s.count('0')
        s = bin(len(s.replace('0', ''))).replace('0b','')
        if s == '1':
            return answer
        return 이진변환(s)
    
    return 이진변환(s)
