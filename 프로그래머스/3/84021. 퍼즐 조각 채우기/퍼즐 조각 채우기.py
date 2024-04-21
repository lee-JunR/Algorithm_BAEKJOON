from collections import deque

dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0,]

# 1. BFS 게임판의 빈칸찾기, 보드의 블록찾기
def BFS(board, num):
    n = len(board)
    empty_board_list = []
    
    for i in range(n):
        for j in range(n):
            if board[i][j] == num:
                queue = deque([(i, j)])
                board[i][j] = 1 - num
                temp = [(i, j)]
                
                while queue:
                    x, y = queue.popleft()
                    
                    for k in range(4):
                        nx = x + dx[k]
                        ny = y + dy[k]
                        
                        if 0 <= nx < n and 0 <= ny < n:
                            if board[nx][ny] == num:
                                queue.append((nx, ny))
                                board[nx][ny] = 1 - num
                                temp.append((nx, ny))
                empty_board_list.append(temp)
                
    return empty_board_list

def make_table(block):
    x, y = zip(*block)
    column, row = max(x) - min(x) + 1, max(y) - min(y) + 1
    table = [[0] * row for _ in range(column)]
    
    for i, j in block:
        i, j = i - min(x), j - min(y)
        table[i][j] = 1
    return table

# 3. 조각 회전하기
def rotate(piece):
    rotate = [[0] * len(piece) for _ in range(len(piece[0]))]
    count = 0
    for i in range(len(piece)):
        for j in range(len(piece[i])):
            if piece[i][j] == 1:
                count += 1
            rotate[j][len(piece) - 1 - i] = piece[i][j]
            
    return rotate, count
        

def solution(game_board, table):
    answer = 0
    empty_space = BFS(game_board, 0)
    blocks = BFS(table, 1)
        
    for empty in empty_space:
        is_empty = True
        table = make_table(empty)
        
        # 2. board에 넣어보기
        for block in blocks:
            if is_empty == False:
                break
            
            piece = make_table(block)
            for i in range(4):
                piece, count = rotate(piece)
                
                # 4. 조각이 들어가면 조각을 지워주기
                if table == piece:
                    answer += count
                    blocks.remove(block)
                    is_empty = False
                    break

    return answer
