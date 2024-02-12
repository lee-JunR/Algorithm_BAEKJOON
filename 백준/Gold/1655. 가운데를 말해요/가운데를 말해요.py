import heapq
import sys

def solution(nums):
    min_heap = []  # 작은 수를 저장하는 최소 힙
    max_heap = []  # 큰 수를 저장하는 최대 힙

    result = []  # 결과를 저장하는 리스트

    for num in nums:
        # 최대 힙의 크기가 최소 힙의 크기보다 작거나 같도록 유지
        if len(max_heap) <= len(min_heap):
            heapq.heappush(max_heap, -num)
        else:
            heapq.heappush(min_heap, num)

        # 최대 힙의 최대값이 최소 힙의 최소값보다 크면 교환
        if min_heap and -max_heap[0] > min_heap[0]:
            max_top = -heapq.heappop(max_heap)
            min_top = heapq.heappop(min_heap)
            heapq.heappush(max_heap, -min_top)
            heapq.heappush(min_heap, max_top)

        # 현재까지의 중간값을 결과에 추가
        result.append(-max_heap[0])

    return result

# 입력 처리
N = int(input())
nums = [int(sys.stdin.readline().rstrip()) for _ in range(N)]

# 결과 출력
for res in solution(nums):
    print(res)
