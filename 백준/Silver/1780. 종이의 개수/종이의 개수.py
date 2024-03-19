def count_papers(matrix, size, x, y):
    count = [0, 0, 0]  # -1, 0, 1 종이의 개수를 저장하는 리스트
    
    # 해당 부분이 모두 같은 숫자로 이루어져 있는지 확인
    all_same = True
    first = matrix[x][y]
    for i in range(x, x + size):
        for j in range(y, y + size):
            if matrix[i][j] != first:
                all_same = False
                break
        if not all_same:
            break
    
    # 모두 같은 숫자로 이루어져 있지 않으면 9등분하여 재귀적으로 확인
    if not all_same:
        new_size = size // 3
        for i in range(3):
            for j in range(3):
                count = [x + y for x, y in zip(count, count_papers(matrix, new_size, x + i * new_size, y + j * new_size))]
    else:
        # 모두 같은 숫자로 이루어져 있으면 해당 숫자의 종이 개수 증가
        if first == -1:
            count[0] += 1
        elif first == 0:
            count[1] += 1
        else:
            count[2] += 1
    
    return count

# 입력 받기
N = int(input())
matrix = [list(map(int, input().split())) for _ in range(N)]

# 결과 출력
result = count_papers(matrix, N, 0, 0)
for count in result:
    print(count)
