import sys


def is_safe(board, row, col, n):
    for i in range(row):
        if board[i] == col or \
                board[i] - i == col - row or \
                board[i] + i == col + row:
            return False
    return True


def count_n_queens_util(board, row, n, count):
    if row == n:
        count[0] += 1
        return

    for col in range(n):
        if is_safe(board, row, col, n):
            board[row] = col
            count_n_queens_util(board, row + 1, n, count)


def count_n_queens(n):
    count = [0]
    board = [-1] * n
    count_n_queens_util(board, 0, n, count)
    return count[0]


print(count_n_queens(int(sys.stdin.readline())))
