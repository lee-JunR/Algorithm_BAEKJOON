import sys

def matrix_chain_order(p):
    n = len(p) - 1  
    m = [[0] * (n+1) for _ in range(n+1)]  
    for l in range(2, n+1):  
        for i in range(1, n-l+2):
            j = i + l - 1
            m[i][j] = sys.maxsize  
            for k in range(i, j):
                q = m[i][k] + m[k+1][j] + p[i-1] * p[k] * p[j]
                if q < m[i][j]:
                    m[i][j] = q
    return m[1][n]

n = int(input())  
matrix_sizes = []  
for _ in range(n):
    r, c = map(int, input().split())
    matrix_sizes.append((r, c))
    
result = matrix_chain_order([matrix_sizes[i][0] for i in range(n)] + [matrix_sizes[-1][1]])
print(result)

