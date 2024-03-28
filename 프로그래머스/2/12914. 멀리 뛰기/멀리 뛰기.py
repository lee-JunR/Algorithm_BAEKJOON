def solution(n):
    l = [1, 1]
    if n < 2:
        return l[n-1]
    for i in range(2, n + 2):
        l.append((l[i - 1] + l[i - 2]) % 1234567)
    return l[n]