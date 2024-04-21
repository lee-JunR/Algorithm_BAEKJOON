import sys

# 두 수의 최대공약수를 구하는 함수
def gcd(x, y):
    while y:
        x, y = y, x % y  # 유클리드 알고리즘을 사용하여 최대공약수 구하기
    return x

# 분수 부분 구현.
def compute_continued_fraction_no_lib(a):
    분자 = 1  # 초기 분자
    분모 = a[-1]  # 마지막 요소가 초기 분모
    for i in reversed(a[:-1]):
        분자, 분모 = 분모, i * 분모 + 분자 # 분모와 분자를 바꾸면서 계산
    # 결과로 나오는 분수의 분자와 분모
    return 분자, 분모

# input
sys.stdin.readline()
input = list(map(int, sys.stdin.readline().split()))

# 주어진 리스트 a를 사용하여 컨티뉴드 프랙션 계산
분자, 분모 = compute_continued_fraction_no_lib(input)
# 톰이 가지고 있는 치즈의 양을 계산 (1 - (분자/분모))
톰의_치즈_분자 = 분모 - 분자  # 분자
톰의_치즈_분모 = 분모  # 분모

# 최대공약수를 사용하여 분수를 기약분수로 변환
최대공약수 = gcd(톰의_치즈_분자, 톰의_치즈_분모)
톰의_치즈_분자 = 톰의_치즈_분자 // 최대공약수  # 기약분수 분자
톰의_치즈_분모 = 톰의_치즈_분모 // 최대공약수  # 기약분수 분모

print(톰의_치즈_분자, 톰의_치즈_분모)  # 기약분수 결과 (분자, 분모)
