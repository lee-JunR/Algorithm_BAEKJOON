def solution(n, m, section):
    answer = 0
    wall = [1] * n
    for paint_area in section:
        wall[paint_area - 1] = 0

    i = 0
    while i < n:
        if wall[i] == 0:
            for j in range(i, min(i + m, n)):
                wall[j] = 1
            answer += 1
            i += m
        else:
            i += 1

    return answer