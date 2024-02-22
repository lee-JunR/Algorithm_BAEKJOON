def count_repaints(board, start_color):
    repaint_count = 0
    for i in range(8):
        for j in range(8):
            if (i + j) % 2 == 0:  
                if board[i][j] != start_color:
                    repaint_count += 1
            else:
                if board[i][j] == start_color:
                    repaint_count += 1
    return repaint_count

def minimum_repaints(N, M, board):
    min_repaints = float('inf')

    for i in range(N - 7):
        for j in range(M - 7):
            sub_board = [row[j:j+8] for row in board[i:i+8]]
            repaints_B = count_repaints(sub_board, 'B')
            repaints_W = count_repaints(sub_board, 'W')
            min_repaints = min(min_repaints, repaints_B, repaints_W)
    return min_repaints

N, M = map(int, input().split())
board = [input().strip() for _ in range(N)]

result = minimum_repaints(N, M, board)
print(result)
