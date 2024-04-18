def solution(n,a,b):
    # 토너먼트 방식이므로 해당 수(n-1)를 2로 나눈 나머지가 같으면 a와 b는 만나게 된다.
    count = 0
    a, b = a-1, b-1
    while a != b:
        a = a//2
        b = b//2
        count +=1
    return count

print(solution(8,4,7))