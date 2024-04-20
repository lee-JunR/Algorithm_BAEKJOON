def solution(rows, columns, queries):
    answer = []

    # 행렬 생성
    matrix = [[0] * columns for _ in range(rows)]
    for i in range(rows):
        for j in range(columns):
            matrix[i][j] = i * columns + j + 1

    # 회전마다 최소값 계산
    for x1, y1, x2, y2 in queries:
        x1, y1, x2, y2 = x1 - 1, y1 - 1, x2 - 1, y2 - 1
        
        border = []

        # 왼쪽 가로
        for i in range(x1, x2 + 1):
            border.append(matrix[i][y1])
        # 아래 세로 (왼쪽, 오른쪽 한변씩을 뺀)
        for i in range(y1 + 1, y2):
            border.append(matrix[x2][i])
        # 오른쪽 가로
        for i in range(x2, x1 - 1, -1):
            border.append(matrix[i][y2])
        # 윗 세로 (왼쪽, 오른쪽 한변씩을 뺀)
        for i in range(y2 - 1, y1, -1):
            border.append(matrix[x1][i])
        # 테두리 숫자 회전
        border = border[1:] + border[:1]

        # 왼쪽 가로
        idx = 0
        for i in range(x1, x2 + 1):
            matrix[i][y1] = border[idx]
            idx += 1
        # 아래 세로 (왼쪽, 오른쪽 한변씩을 뺀)
        for i in range(y1 + 1, y2):
            matrix[x2][i] = border[idx]
            idx += 1
        # 오른쪽 가로
        for i in range(x2, x1 - 1, -1):
            matrix[i][y2] = border[idx]
            idx += 1
        # 윗 세로 (왼쪽, 오른쪽 한변씩을 뺀)
        for i in range(y2 - 1, y1, -1):
            matrix[x1][i] = border[idx]
            idx += 1

        # 최소값 찾기
        minimum = min(border)
        answer.append(minimum)
    return answer

print(solution(3, 3, [[1, 1, 2, 2], [1, 2, 2, 3], [2, 1, 3, 2], [2, 2, 3, 3]]))
