def solution(n, m, section):
    # n미터인 벽에 페인트가 벗겨짐 그래서 1번부터 n번까지 번호 붙임
    # 페인트를 칠하는 롤러의 길이는 m미터
    # section 에서는 n미터 벽에 칠해야할 번호를 줌.

    # n = 8, m = 3 일 경우
    # 1. 00010000
    #     ---        1번
    # 2. 00110000
    #     ---       
    #    01001000 
    #     ---
    #        ---       2번
    #    01000100 
    #     ---
    #         ---      2번
    #    section 숫자의 차가 m보다 작을 경우 1번 클경우 2번
    # 3.   01011000 
    #       ---

    # 그렇다면 첫번째 section이 나오면 m번 칠하고 그 다음 setcion부터 탐색하면 어떨까?
    answer = 0
    wall = [1] * n

    # 페인트가 칠해야 할 구간을 0로 표시
    for paint_area in section:
        wall[paint_area - 1] = 0

    i = 0
    while i < n:
        # 현재 위치가 페인트가 칠해져 있지 않은 경우
        if wall[i] == 0:
            # 현재 위치부터 m만큼의 구간에 페인트를 칠함
            for j in range(i, min(i + m, n)):
                wall[j] = 1
            answer += 1
            # 다음 구간으로 이동
            i += m
        else:
            # 이미 페인트가 칠해져 있으면 다음 위치로 이동
            i += 1

    return answer
print(solution(4, 1, [1, 2, 3, 4]))
