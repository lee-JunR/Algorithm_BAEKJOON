def solution(citations):
    # h 번 이상인 데이터가 h 개 이상일때.
    # 근데 h는 len(citations) 보다 클 수 없음.
    # 그렇다면 인용횟수를 배열로 잡으면 O(n) 복잡도로 풀 수 있지 않을까?

    # 논문의 인용횟수를 배열로 생성.
    max_citations = 10_000
    counts = [0] * (max_citations + 1) # 논문별 인용 횟수는 0회 이상 10,000회 이하

    # 각 인용 횟수에 해당하는 논문의 수를 카운트
    for citation in citations:
        if citation > max_citations:
            counts[max_citations] += 1
        else:
            counts[citation] += 1

    # 뒤에서부터 누적 합계로 인용 횟수 이상의 논문 수 계산
    total_papers = len(citations)
    running_total = 0
    h_index = 0
    for i in range(max_citations, -1, -1):
        running_total += counts[i]
        if running_total >= i:
            h_index = i
            break

    return h_index
citations = [3, 0, 6, 1, 5]
print(solution(citations))