def abs(a):  # 절대값을 구하는 함수
  if a < 0:
    return -a
  else:
    return a

def main():
  n, m= map(int, input().split())
  d = int(input())
  sum = 0  # 택시 거리가 D 미만인 칸들의 개수를 저장할 변수
  arr = [[0 for _ in range(m + 1)] for _ in range(n + 1)]  # 2차원 배열

  # 왼쪽 위 모서리와의 택시 거리가 D 미만인 칸들을 1로 설정
  for i in range(1, n + 1):
    for j in range(1, m + 1):
      if abs(i - 1) + abs(j - 1) < d:
        arr[i][j] = 1

  # 오른쪽 위 모서리와의 택시 거리가 D 미만이고 1로 설정된 칸들을 2로 설정
  for i in range(1, n + 1):
    for j in range(1, m + 1):
      if abs(n - i) + abs(j - 1) < d and arr[i][j] == 1:
        arr[i][j] = 2

  # 왼쪽 아래 모서리와의 택시 거리가 D 미만이고 2로 설정된 칸들을 3으로 설정
  for i in range(1, n + 1):
    for j in range(1, m + 1):
      if abs(i - 1) + abs(m - j) < d and arr[i][j] == 2:
        arr[i][j] = 3

  # 오른쪽 아래 모서리와의 택시 거리가 D 미만이고 3으로 설정된 칸들의 개수를 센다
  for i in range(1, n + 1):
    for j in range(1, m + 1):
      if abs(n - i) + abs(m - j) < d and arr[i][j] == 3:
        sum += 1

  # 택시 거리가 D 미만인 칸들의 개수 출력
  print(sum)

if __name__ == "__main__":
  main()
