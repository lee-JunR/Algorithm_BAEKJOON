import sys
import heapq

def merge_sorted_card_packs(card_packs):
  heapq.heapify(card_packs)
  total_comparisons = 0
  while len(card_packs) > 1:
    pack1 = heapq.heappop(card_packs)
    pack2 = heapq.heappop(card_packs)
    merged_pack = pack1 + pack2
    heapq.heappush(card_packs, merged_pack)
    total_comparisons += pack1 + pack2
  return total_comparisons

# 입력
N = int(sys.stdin.readline())
card_packs = [int(sys.stdin.readline()) for _ in range(N)]

# 출력
print(merge_sorted_card_packs(card_packs))