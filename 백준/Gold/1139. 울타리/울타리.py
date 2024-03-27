import math

def solve(idx, bitmask, fences, dp):
    if idx == len(fences):
        return 0
    
    if dp[idx][bitmask] != -1:
        return dp[idx][bitmask]
    
    maxArea = solve(idx + 1, bitmask, fences, dp)
    
    for i in range(len(fences)):
        for j in range(i + 1, len(fences)):
            for k in range(j + 1, len(fences)):
                if (bitmask & (1 << i)) == 0 and (bitmask & (1 << j)) == 0 and (bitmask & (1 << k)) == 0:
                    if fences[i] + fences[j] > fences[k]:
                        area = get_triangle_area(fences[i], fences[j], fences[k])
                        newBitmask = bitmask | (1 << i) | (1 << j) | (1 << k)
                        maxArea = max(maxArea, area + solve(idx + 1, newBitmask, fences, dp))
    
    dp[idx][bitmask] = maxArea
    return maxArea

def get_triangle_area(a, b, c):
    p = (a + b + c) / 2.0
    return math.sqrt(p * (p - a) * (p - b) * (p - c))

if __name__ == "__main__":
    N = int(input())
    fenceStr = input().split()
    fences = [int(x) for x in fenceStr]
    
    fences.sort()
    
    dp = [[-1] * (1 << N) for _ in range(N)]
    
    print("{:.10f}".format(solve(0, 0, fences, dp)))
