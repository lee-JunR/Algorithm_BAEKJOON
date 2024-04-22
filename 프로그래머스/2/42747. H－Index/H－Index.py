def solution(citations):
    answer = 0

    citations.sort()
    h_index = [0] * len(citations)
    for i, citation in enumerate(citations):
        n = sum([1 if citation <= c else 0 for c in citations[i:]])
        h_index[i] = min(citation, n)
    answer = max(h_index)
    return answer


