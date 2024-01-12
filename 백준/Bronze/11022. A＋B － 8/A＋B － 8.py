T = int(input())
for test_case in range(1, T+1):
    A, B = map(int, input().split())
    print("Case #%d: %d + %d = %d" % (test_case, A, B, A+B))
