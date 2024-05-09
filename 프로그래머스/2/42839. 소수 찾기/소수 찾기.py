from itertools import permutations

def find_primenumbers(n):
    primes = [True] * (n + 1)

    p = 2
    while p * p <= n:
        # p 가 소수인 경우
        if primes[p]:
            # p 의 배수들을 모두 '소수가 아님(False)' 으로 표시!
            i = p * 2
            while i <= n:
                primes[i] = False
                i += p
        p += 1

    # 소수로 표시된 모든 수를 결과 리스트에 추가
    result = []
    for i in range(2, n + 1):
        if primes[i]:
            result.append(i)
    return result

def find_permutations(numbers):
    result = []
    for i in range(1, len(numbers) + 1):
        for perm in permutations(numbers, i):
            num_str = "".join(perm)
            if num_str not in result:
                result.append(int(num_str))
    return result

def solution(numbers):
    # 1. 모든 가능한 숫자 순열 만들기
    tlist = set(find_permutations(numbers))
    # 2. 소수 후보 리스트 만들기
    numbers = list(numbers)
    numbers.sort(reverse=True)
    max_number = int("".join(numbers))
    prime_candidates = set(find_primenumbers(max_number)) # numbers 의 최댓값까지 가능한 소수 조합 고려
    # 3. 모든 가능한 숫자 순열과 소수 후보 리스트 의 교집합의 개수 구하기.
    answer = len(prime_candidates.intersection(tlist))
    return answer