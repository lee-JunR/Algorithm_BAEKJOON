def solution(citations):
    citations.sort(reverse=True)
    answer = 0
    for num, citation in enumerate(citations):
        if citation >= num+1: 
            h_index = num+1
            answer = h_index
    return answer

