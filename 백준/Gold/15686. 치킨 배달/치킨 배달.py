import sys

def cal(tlst):
    # 모든 집과 tlst의 치킨집 거리중 최솟값 누적치 구하기
    sm = 0
    for hi, hj in home:     # 집 좌표를 하나씩 처리(최솟값 처리)
        mn = 2*n
        for ci, cj in tlst: # 치킨집 좌표를 꺼내서 계산
            mn = min(mn, abs(hi-ci) + abs(hj-cj))
        sm += mn
    return sm

def dfs(n, tlst):
    global ans
    if n == CNT:                # 종료조건 : 모든 치킨ㅂ집의 폐업 여부 결정 완료시
        if len(tlst) == m:      # m개 유지 결정시 최소값 갱신
            ans = min(ans, cal(tlst))
        return

    dfs(n+1, tlst+[chicken[n]]) # 유지하는 경우
    dfs(n+1, tlst)              # 폐업하는 경우


input = sys.stdin.readline

# input
n, m = map(int, input().split())
gh = [list(map(int, input().split())) for _ in range(n)]
home, chicken = [], []

# 1. 집, 치킨집 좌표 home, chicken[] 에 저장
for i in range(n):
    for j in range(n):
        if gh[i][j] == 1:  # 집
            home.append((i, j))
        elif gh[i][j] == 2:  # 치킨집
            chicken.append((i, j))
CNT = len(chicken)


ans = 2*n*2*n    # 최대 2n 개의 집이 가장 멀리 떨어진 치킨집과의 거리.
dfs(0, [])
print(ans)