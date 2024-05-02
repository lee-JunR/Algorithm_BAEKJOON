def solution(target):
    # DP 배열을 초기화, 다트 수와 싱글+불 횟수 초기화
    # 목표 점수 범위에 따라 배열 크기 설정
    inf = float('inf')
    dp = [[inf, inf] for _ in range(target + 1)]

    # 목표점수 0은 다트가 필요 없음
    dp[0] = [0, 0]

    # 가능한 점수들: 트리플, 더블, 싱글, 불
    triples = [(i, 3 * i) for i in range(1, 21)]
    doubles = [(i, 2 * i) for i in range(1, 21)]
    singles = [(1, i) for i in range(1, 21)]
    bulls = [(1, 50)]

    # 모든 가능한 다트 방법을 탐색
    possible_scores = triples + doubles + singles + bulls

    for points, score in possible_scores:
        for t in range(score, target + 1):
            # 이전 점수에서 현재 다트를 사용해 가능한 경우
            current_darts = dp[t - score][0] + 1
            current_singles = dp[t - score][1] + (1 if points == 1 else 0)

            # 더 적은 다트로 도달했거나, 동일 다트에 더 많은 싱글을 사용한 경우
            if (current_darts < dp[t][0]) or (current_darts == dp[t][0] and current_singles > dp[t][1]):
                dp[t] = [current_darts, current_singles]

    return dp[target]
