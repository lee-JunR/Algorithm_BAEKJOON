def find_sequences(N, M, current, visited):
    if len(current) == M:
        print(' '.join(map(str, current)))
        return

    for num in range(1, N + 1):
        if not visited[num]:
            visited[num] = True
            find_sequences(N, M, current + [num], visited)
            visited[num] = False

if __name__ == "__main__":
    N, M = map(int, input().split())
    visited = [False] * (N + 1)
    find_sequences(N, M, [], visited)
